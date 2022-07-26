package msaneil.domain;

import java.util.*;
import lombok.*;
import msaneil.domain.*;
import msaneil.infra.AbstractEvent;

@Data
@ToString
public class ReservationCancelRequested extends AbstractEvent {

    private Long rsvId;
    private Long roomId;
    private Long payId;
    private Integer status;

    public ReservationCancelRequested(Reservation aggregate) {
        super(aggregate);
    }

    public ReservationCancelRequested() {
        super();
    }
    // keep

}
