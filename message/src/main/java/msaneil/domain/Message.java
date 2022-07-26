package msaneil.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msaneil.MessageApplication;
import msaneil.domain.CancellMsgSended;
import msaneil.domain.ConfirmMsgSended;
import msaneil.domain.ConfirmRequestMsgSended;

@Entity
@Table(name = "Message_table")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long msgId;

    private Long roomId;

    private String content;

    private Long rsvId;

    @PrePersist
    public void onPrePersist() {
        ConfirmMsgSended confirmMsgSended = new ConfirmMsgSended(this);
        confirmMsgSended.publishAfterCommit();

        CancellMsgSended cancellMsgSended = new CancellMsgSended(this);
        cancellMsgSended.publishAfterCommit();

        ConfirmRequestMsgSended confirmRequestMsgSended = new ConfirmRequestMsgSended(
            this
        );
        confirmRequestMsgSended.publishAfterCommit();
    }

    public static MessageRepository repository() {
        MessageRepository messageRepository = MessageApplication.applicationContext.getBean(
            MessageRepository.class
        );
        return messageRepository;
    }

    public static void sendConfirmMsg(
        ReservationConfirmed reservationConfirmed
    ) {
        /** Example 1:  new item 
        Message message = new Message();
        repository().save(message);

        ConfirmMsgSended confirmMsgSended = new ConfirmMsgSended(message);
        confirmMsgSended.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reservationConfirmed.get???()).ifPresent(message->{
            
            message // do something
            repository().save(message);

            ConfirmMsgSended confirmMsgSended = new ConfirmMsgSended(message);
            confirmMsgSended.publishAfterCommit();

         });
        */

    }

    public static void sendCancellMsg(
        ReservationCancelled reservationCancelled
    ) {
        /** Example 1:  new item 
        Message message = new Message();
        repository().save(message);

        CancellMsgSended cancellMsgSended = new CancellMsgSended(message);
        cancellMsgSended.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reservationCancelled.get???()).ifPresent(message->{
            
            message // do something
            repository().save(message);

            CancellMsgSended cancellMsgSended = new CancellMsgSended(message);
            cancellMsgSended.publishAfterCommit();

         });
        */

    }

    public static void sendConfirmRequesMsg(
        ReservationRequested reservationRequested
    ) {
        /** Example 1:  new item 
        Message message = new Message();
        repository().save(message);

        ConfirmRequestMsgSended confirmRequestMsgSended = new ConfirmRequestMsgSended(message);
        confirmRequestMsgSended.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reservationRequested.get???()).ifPresent(message->{
            
            message // do something
            repository().save(message);

            ConfirmRequestMsgSended confirmRequestMsgSended = new ConfirmRequestMsgSended(message);
            confirmRequestMsgSended.publishAfterCommit();

         });
        */

    }
}
