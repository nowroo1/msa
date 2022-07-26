package msaneil.domain;

import java.util.*;
import lombok.*;
import msaneil.domain.*;
import msaneil.infra.AbstractEvent;

@Data
@ToString
public class ReservationCancelled extends AbstractEvent {

    private Long rsvId;
    private Long roomId;
    private Integer status;
    private Long payId;

    public ReservationCancelled(Reservation aggregate) {
        super(aggregate);
    }

    public ReservationCancelled() {
        super();
    }
    // keep

}
