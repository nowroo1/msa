package msaneil.domain;

import java.util.Date;
import lombok.Data;
import msaneil.infra.AbstractEvent;

@Data
public class ReservationCancelled extends AbstractEvent {

    private Long rsvId;
    private Long roomId;
    private Integer status;
    private Long payId;
}
