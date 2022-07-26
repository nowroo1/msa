package msaneil.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msaneil.ReservationApplication;
import msaneil.domain.ReservationAccepted;
import msaneil.domain.ReservationCancelRequested;
import msaneil.domain.ReservationCancelled;
import msaneil.domain.ReservationConfirmed;
import msaneil.domain.ReservationRejected;
import msaneil.domain.ReservationRequested;

@Entity
@Table(name = "Reservation_table")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rsvId;

    private Long roomId;

    private Integer status;

    private Long payId;

    @PostPersist
    public void onPostPersist() {
        ReservationRequested reservationRequested = new ReservationRequested(
            this
        );
        reservationRequested.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        msaneil.external.Payment payment = new msaneil.external.Payment();
        // mappings goes here
        ReservationApplication.applicationContext
            .getBean(msaneil.external.PaymentService.class)
            .approvePayment(payment);

        ReservationAccepted reservationAccepted = new ReservationAccepted(this);
        reservationAccepted.publishAfterCommit();

        ReservationRejected reservationRejected = new ReservationRejected(this);
        reservationRejected.publishAfterCommit();

        ReservationCancelRequested reservationCancelRequested = new ReservationCancelRequested(
            this
        );
        reservationCancelRequested.publishAfterCommit();

        ReservationConfirmed reservationConfirmed = new ReservationConfirmed(
            this
        );
        reservationConfirmed.publishAfterCommit();

        ReservationCancelled reservationCancelled = new ReservationCancelled(
            this
        );
        reservationCancelled.publishAfterCommit();
    }

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }

    public static void confirmReserve(PaymentApproved paymentApproved) {
        /** Example 1:  new item 
        Reservation reservation = new Reservation();
        repository().save(reservation);

        ReservationConfirmed reservationConfirmed = new ReservationConfirmed(reservation);
        reservationConfirmed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paymentApproved.get???()).ifPresent(reservation->{
            
            reservation // do something
            repository().save(reservation);

            ReservationConfirmed reservationConfirmed = new ReservationConfirmed(reservation);
            reservationConfirmed.publishAfterCommit();

         });
        */

    }

    public static void confirmCancel(PaymentCancelled paymentCancelled) {
        /** Example 1:  new item 
        Reservation reservation = new Reservation();
        repository().save(reservation);

        ReservationCancelled reservationCancelled = new ReservationCancelled(reservation);
        reservationCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paymentCancelled.get???()).ifPresent(reservation->{
            
            reservation // do something
            repository().save(reservation);

            ReservationCancelled reservationCancelled = new ReservationCancelled(reservation);
            reservationCancelled.publishAfterCommit();

         });
        */

    }
}
