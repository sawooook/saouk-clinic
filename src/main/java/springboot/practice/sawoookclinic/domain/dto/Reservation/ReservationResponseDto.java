package springboot.practice.sawoookclinic.domain.dto.Reservation;

import lombok.Getter;
import springboot.practice.sawoookclinic.domain.Reservation;

import java.time.LocalDateTime;

@Getter
public class ReservationResponseDto {
    private Long id;
    private LocalDateTime reservationTime;
    private Long DoctorId;
    private Long ownerId;

    public ReservationResponseDto(Reservation entity) {
        DoctorId = entity.getDoctor().getId();
        this.ownerId = entity.getOwner().getId();
        this.reservationTime = entity.getReservationTime();

    }
}

