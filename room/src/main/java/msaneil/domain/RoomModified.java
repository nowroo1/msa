package msaneil.domain;

import java.util.*;
import lombok.*;
import msaneil.domain.*;
import msaneil.infra.AbstractEvent;

@Data
@ToString
public class RoomModified extends AbstractEvent {

    private Long roomId;
    private Boolean status;
    private Integer reviewCnt;
    private String description;

    public RoomModified(Room aggregate) {
        super(aggregate);
    }

    public RoomModified() {
        super();
    }
    // keep

}
