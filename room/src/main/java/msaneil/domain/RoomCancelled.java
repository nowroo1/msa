package msaneil.domain;

import java.util.*;
import lombok.*;
import msaneil.domain.*;
import msaneil.infra.AbstractEvent;

@Data
@ToString
public class RoomCancelled extends AbstractEvent {

    private Long roomId;
    private Boolean status;
    private Integer reviewCnt;
    private String description;

    public RoomCancelled(Room aggregate) {
        super(aggregate);
    }

    public RoomCancelled() {
        super();
    }
    // keep

}
