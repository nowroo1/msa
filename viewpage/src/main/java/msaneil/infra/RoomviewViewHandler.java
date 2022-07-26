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

            List<Roomview> roomviewList = roomviewRepository.findByRsvId(
                reservationRequested.getRsvid()
            );
            for (Roomview roomview : roomviewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setRsvStatus(reservationRequested.getStatus());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // keep

}
