package msaneil.domain;

import java.util.*;
import lombok.*;
import msaneil.domain.*;
import msaneil.infra.AbstractEvent;

@Data
@ToString
public class RoomReserved extends AbstractEvent {

    private Long roomId;
    private Boolean status;
    private Integer reviewCnt;
    private String description;

    public RoomReserved(Room aggregate) {
        super(aggregate);
    }

    public RoomReserved() {
        super();
    }
    // keep

}
