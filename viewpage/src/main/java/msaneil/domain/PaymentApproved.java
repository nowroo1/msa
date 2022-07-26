package msaneil.domain;

import java.util.Date;
import lombok.Data;
import msaneil.infra.AbstractEvent;

@Data
public class PaymentApproved extends AbstractEvent {

    private Long payId;
    private Long rsvId;
    private Long roomId;
    private Boolean status;
}
