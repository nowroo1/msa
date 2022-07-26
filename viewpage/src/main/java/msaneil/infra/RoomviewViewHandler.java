package msaneil.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import msaneil.config.kafka.KafkaProcessor;
import msaneil.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class RoomviewViewHandler {

    @Autowired
    private RoomviewRepository roomviewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomRegistered_then_CREATE_1(
        @Payload RoomRegistered roomRegistered
    ) {
        try {
            if (!roomRegistered.validate()) return;

            // view 객체 생성
            Roomview roomview = new Roomview();
            // view 객체에 이벤트의 Value 를 set 함
            roomview.setRoomId(roomRegistered.getRoomId());
            roomview.setDesciption(roomRegistered.getDescription());
            roomview.setReviewCnt(roomRegistered.getReviewCnt());
            roomview.setRoomStatus(roomRegistered.getStatus());
            // view 레파지 토리에 save
            roomviewRepository.save(roomview);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationRequested_then_UPDATE_1(
        @Payload ReservationRequested reservationRequested
    ) {
        try {
            if (!reservationRequested.validate()) return;
            // view 객체 조회
            Optional<Roomview> roomviewOptional = roomviewRepository.findById(
                reservationRequested.getRoomId()
            );

            if (roomviewOptional.isPresent()) {
                Roomview roomview = roomviewOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setRsvId(reservationRequested.getRsvId());
                roomview.setRsvStatus(reservationRequested.getStatus());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomModified_then_UPDATE_2(
        @Payload RoomModified roomModified
    ) {
        try {
            if (!roomModified.validate()) return;
            // view 객체 조회
            Optional<Roomview> roomviewOptional = roomviewRepository.findById(
                roomModified.getRoomId()
            );

            if (roomviewOptional.isPresent()) {
                Roomview roomview = roomviewOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setDesciption(roomModified.getDescription());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationAccepted_then_UPDATE_3(
        @Payload ReservationAccepted reservationAccepted
    ) {
        try {
            if (!reservationAccepted.validate()) return;
            // view 객체 조회

            List<Roomview> roomviewList = roomviewRepository.findByRsvId(
                reservationAccepted.getId()
            );
            for (Roomview roomview : roomviewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setRsvStatus(reservationAccepted.getStatus());
                roomview.setPayId(reservationAccepted.getPayId());
                roomview.setPayStatus(0);
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationConfirmed_then_UPDATE_4(
        @Payload ReservationConfirmed reservationConfirmed
    ) {
        try {
            if (!reservationConfirmed.validate()) return;
            // view 객체 조회

            List<Roomview> roomviewList = roomviewRepository.findByRsvId(
                reservationConfirmed.getId()
            );
            for (Roomview roomview : roomviewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setRsvStatus(reservationConfirmed.getStatus());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCancelRequested_then_UPDATE_5(
        @Payload ReservationCancelRequested reservationCancelRequested
    ) {
        try {
            if (!reservationCancelRequested.validate()) return;
            // view 객체 조회

            List<Roomview> roomviewList = roomviewRepository.findByRsvStatus(
                reservationCancelRequested.getStatus()
            );
            for (Roomview roomview : roomviewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setRsvStatus(reservationCancelRequested.getStatus());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationRejected_then_UPDATE_6(
        @Payload ReservationRejected reservationRejected
    ) {
        try {
            if (!reservationRejected.validate()) return;
            // view 객체 조회

            List<Roomview> roomviewList = roomviewRepository.findByRsvId(
                reservationRejected.getId()
            );
            for (Roomview roomview : roomviewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setRsvStatus(0);
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCancelled_then_UPDATE_7(
        @Payload ReservationCancelled reservationCancelled
    ) {
        try {
            if (!reservationCancelled.validate()) return;
            // view 객체 조회

            List<Roomview> roomviewList = roomviewRepository.findByRsvId(
                reservationCancelled.getId()
            );
            for (Roomview roomview : roomviewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setRsvId(0);
                roomview.setRsvStatus(0);
                roomview.setPayId(0);
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomReserved_then_UPDATE_8(
        @Payload RoomReserved roomReserved
    ) {
        try {
            if (!roomReserved.validate()) return;
            // view 객체 조회
            Optional<Roomview> roomviewOptional = roomviewRepository.findById(
                roomReserved.getId()
            );

            if (roomviewOptional.isPresent()) {
                Roomview roomview = roomviewOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setRoomStatus(roomReserved.getStatus());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentApproved_then_UPDATE_9(
        @Payload PaymentApproved paymentApproved
    ) {
        try {
            if (!paymentApproved.validate()) return;
            // view 객체 조회

            List<Roomview> roomviewList = roomviewRepository.findByPayId(
                paymentApproved.getPayId()
            );
            for (Roomview roomview : roomviewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setPayStatus(paymentApproved.getStatus());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCancelled_then_UPDATE_10(
        @Payload PaymentCancelled paymentCancelled
    ) {
        try {
            if (!paymentCancelled.validate()) return;
            // view 객체 조회

            List<Roomview> roomviewList = roomviewRepository.findByPayId(
                paymentCancelled.getId()
            );
            for (Roomview roomview : roomviewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setPayStatus(paymentCancelled.getStatus());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomDeleted_then_DELETE_1(
        @Payload RoomDeleted roomDeleted
    ) {
        try {
            if (!roomDeleted.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            roomviewRepository.deleteById(roomDeleted.getRoomId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // keep

}
