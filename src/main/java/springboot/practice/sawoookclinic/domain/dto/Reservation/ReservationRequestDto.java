package springboot.practice.sawoookclinic.domain.dto.Reservation;

import lombok.Getter;
import lombok.Setter;
import springboot.practice.sawoookclinic.domain.Reservation;

import java.time.LocalDateTime;

@Getter @Setter
public class ReservationRequestDto {
    private Long id;
    private LocalDateTime reservationTime;
    private Long doctorId;
    private Long ownerId;
}
