package msaneil.domain;

import java.util.*;
import lombok.*;
import msaneil.domain.*;
import msaneil.infra.AbstractEvent;

@Data
@ToString
public class ReservationRejected extends AbstractEvent {

    private Long rsvId;
    private Long roomId;
    private Integer status;

    public ReservationRejected(Reservation aggregate) {
        super(aggregate);
    }

    public ReservationRejected() {
        super();
    }
    // keep

}
