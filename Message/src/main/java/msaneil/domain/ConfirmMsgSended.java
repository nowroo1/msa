package msaneil.domain;

import java.util.*;
import lombok.*;
import msaneil.domain.*;
import msaneil.infra.AbstractEvent;

@Data
@ToString
public class ConfirmMsgSended extends AbstractEvent {

    private Long msgId;
    private Long roomId;
    private Long rsvId;
    private String content;

    public ConfirmMsgSended(Message aggregate) {
        super(aggregate);
    }

    public ConfirmMsgSended() {
        super();
    }
    // keep

}
