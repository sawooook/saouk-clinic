package springboot.practice.sawoookclinic.domain;

import lombok.Getter;
import lombok.Setter;
import springboot.practice.sawoookclinic.domain.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

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

    private LocalDate ReservationTime;
}
