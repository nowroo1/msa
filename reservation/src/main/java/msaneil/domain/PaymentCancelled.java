package msaneil.domain;

import java.util.*;
import lombok.*;
import msaneil.domain.*;
import msaneil.infra.AbstractEvent;

@Data
@ToString
public class PaymentCancelled extends AbstractEvent {

    private Long payId;
    private Long rsvId;
    private Long roomId;
    private Boolean status;
    // keep

}
