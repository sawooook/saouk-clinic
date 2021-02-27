package springboot.practice.sawoookclinic.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import springboot.practice.sawoookclinic.domain.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@Entity
public class Reservation extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "RESERVATION_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;

    private LocalDateTime ReservationTime;

    public boolean checkTime(LocalDateTime wantReserveTime) {
        if (this.getReservationTime() == wantReserveTime) {
            return false;
        } else {
            return true;
        }
    }

    @Builder
    public Reservation(Long id, Owner owner, Doctor doctor, LocalDateTime reservationTime) {
        this.id = id;
        this.owner = owner;
        this.doctor = doctor;
        ReservationTime = reservationTime;
    }
}
