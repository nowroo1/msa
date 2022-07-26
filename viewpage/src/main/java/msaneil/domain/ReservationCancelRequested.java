package msaneil.domain;

import java.util.Date;
import lombok.Data;
import msaneil.infra.AbstractEvent;

@Data
public class ReservationCancelRequested extends AbstractEvent {

    private Long rsvId;
    private Long roomId;
    private Long payId;
    private Integer status;
}
