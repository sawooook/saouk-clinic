package springboot.practice.sawoookclinic.domain;

import lombok.Getter;
import lombok.Setter;
import springboot.practice.sawoookclinic.domain.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Doctor extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DOCTOR_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "doctor")
    private List<Reservation> reservations = new ArrayList<>();

    public Boolean checkReservation(LocalDateTime wantReserveTime) {

        for (Reservation reservation : reservations) {
            if (!reservation.checkTime(wantReserveTime)) {
                return false;
            }
        }
        return true;
    }
}
