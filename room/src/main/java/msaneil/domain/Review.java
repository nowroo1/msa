package msaneil.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msaneil.RoomApplication;
import msaneil.domain.ReviewCreated;
import msaneil.domain.ReviewDeleted;
import msaneil.domain.ReviewModified;

@Entity
@Table(name = "Review_table")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;

    private Long roomId;

    private String content;

    @PostPersist
    public void onPostPersist() {
        ReviewCreated reviewCreated = new ReviewCreated(this);
        reviewCreated.publishAfterCommit();

        ReviewModified reviewModified = new ReviewModified(this);
        reviewModified.publishAfterCommit();

        ReviewDeleted reviewDeleted = new ReviewDeleted(this);
        reviewDeleted.publishAfterCommit();
    }

    public static ReviewRepository repository() {
        ReviewRepository reviewRepository = RoomApplication.applicationContext.getBean(
            ReviewRepository.class
        );
        return reviewRepository;
    }
}
