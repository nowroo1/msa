package msaneil.domain;

import java.util.*;
import lombok.*;
import msaneil.domain.*;
import msaneil.infra.AbstractEvent;

@Data
@ToString
public class ReservationAccepted extends AbstractEvent {

    private Long rsvId;
    private Long payId;
    private Integer status;
    private Long roomId;

    public ReservationAccepted(Reservation aggregate) {
        super(aggregate);
    }

    public ReservationAccepted() {
        super();
    }
    // keep

}
