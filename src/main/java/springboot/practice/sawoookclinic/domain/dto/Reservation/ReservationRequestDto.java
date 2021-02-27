package springboot.practice.sawoookclinic.domain.dto.Reservation;

import lombok.Getter;
import springboot.practice.sawoookclinic.domain.Reservation;

import java.time.LocalDateTime;

@Getter
public class ReservationRequestDto {
    private Long id;
    private LocalDateTime reservationTime;
    private Long DoctorId;
    private Long ownerId;

    public ReservationRequestDto(Reservation entity) {
        this.id = entity.getId();
        this.reservationTime = entity.getReservationTime();
        DoctorId = entity.getDoctor().ge;
        this.ownerId = ownerId;
    }
}
