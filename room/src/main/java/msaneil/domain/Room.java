package msaneil.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msaneil.RoomApplication;
import msaneil.domain.RoomCancelled;
import msaneil.domain.RoomDeleted;
import msaneil.domain.RoomModified;
import msaneil.domain.RoomRegistered;
import msaneil.domain.RoomReserved;

@Entity
@Table(name = "Room_table")
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomId;

    private Boolean status;

    private Integer reviewCnt;

    private String description;

    @PostPersist
    public void onPostPersist() {

        reviewCnt = 0;
        status = true;

        RoomRegistered roomRegistered = new RoomRegistered(this);
        roomRegistered.publishAfterCommit();

        // RoomModified roomModified = new RoomModified(this);
        // roomModified.publishAfterCommit();

        // RoomDeleted roomDeleted = new RoomDeleted(this);
        // roomDeleted.publishAfterCommit();

        // RoomReserved roomReserved = new RoomReserved(this);
        // roomReserved.publishAfterCommit();

        // RoomCancelled roomCancelled = new RoomCancelled(this);
        // roomCancelled.publishAfterCommit();
    }

    public static RoomRepository repository() {
        RoomRepository roomRepository = RoomApplication.applicationContext.getBean(
            RoomRepository.class
        );
        return roomRepository;
    }

    public static void updateReview(ReviewCreated reviewCreated) {
        /** Example 1:  new item 
        Room room = new Room();
        repository().save(room);

        */

        /** Example 2:  finding and process
        
        repository().findById(reviewCreated.get???()).ifPresent(room->{
            
            room // do something
            repository().save(room);


         });
        */

    }

    public static void updateReview(ReviewDeleted reviewDeleted) {
        /** Example 1:  new item 
        Room room = new Room();
        repository().save(room);

        */

        /** Example 2:  finding and process
        
        repository().findById(reviewDeleted.get???()).ifPresent(room->{
            
            room // do something
            repository().save(room);


         });
        */

    }

    public static void confirmReserve(
        ReservationConfirmed reservationConfirmed
    ) {
        RoomReserved roomReserved = new RoomReserved(room);
        roomReserved.publishAfterCommit();

        /** Example 2:  finding and process
        
        repository().findById(reservationConfirmed.get???()).ifPresent(room->{
            
            room // do something
            repository().save(room);

            RoomReserved roomReserved = new RoomReserved(room);
            roomReserved.publishAfterCommit();

         });
        */

    }

    public static void cancel(ReservationCancelled reservationCancelled) {
        /** Example 1:  new item 
        Room room = new Room();
        repository().save(room);

        RoomCancelled roomCancelled = new RoomCancelled(room);
        roomCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reservationCancelled.get???()).ifPresent(room->{
            
            room // do something
            repository().save(room);

            RoomCancelled roomCancelled = new RoomCancelled(room);
            roomCancelled.publishAfterCommit();

         });
        */

    }

    public static void cancel(ReservationRejected reservationRejected) {
        /** Example 1:  new item 
        Room room = new Room();
        repository().save(room);

        RoomCancelled roomCancelled = new RoomCancelled(room);
        roomCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reservationRejected.get???()).ifPresent(room->{
            
            room // do something
            repository().save(room);

            RoomCancelled roomCancelled = new RoomCancelled(room);
            roomCancelled.publishAfterCommit();

         });
        */

    }
}
