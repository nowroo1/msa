package msaneil.domain;

import java.util.Date;
import lombok.Data;
import msaneil.infra.AbstractEvent;

@Data
public class ReservationAccepted extends AbstractEvent {

    private Long rsvId;
    private Long payId;
    private Integer status;
    private Long roomId;
}
