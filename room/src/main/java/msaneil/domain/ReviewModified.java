package msaneil.domain;

import java.util.*;
import lombok.*;
import msaneil.domain.*;
import msaneil.infra.AbstractEvent;

@Data
@ToString
public class ReviewModified extends AbstractEvent {

    private Long reviewId;
    private Long roomId;
    private String content;

    public ReviewModified(Review aggregate) {
        super(aggregate);
    }

    public ReviewModified() {
        super();
    }
    // keep

}
