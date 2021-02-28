package springboot.practice.sawoookclinic.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springboot.practice.sawoookclinic.domain.Doctor;
import springboot.practice.sawoookclinic.domain.Owner;
import springboot.practice.sawoookclinic.domain.Reservation;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReservationRepository {

    private final EntityManager em;

    public Long save(Reservation reservation) {
        em.persist(reservation);
        return reservation.getId();
    }


    public List<Reservation> findAll() {
        return em.createQuery("select r from Reservation r", Reservation.class)
                .getResultList();
    }

}
