package msaneil.domain;

import java.util.Date;
import lombok.Data;
import msaneil.infra.AbstractEvent;

@Data
public class RoomReserved extends AbstractEvent {

    private Long roomId;
    private Boolean status;
    private Integer reviewCnt;
    private String description;
}
