package springboot.practice.sawoookclinic.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springboot.practice.sawoookclinic.domain.Reservation;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReservationRepository {

    private final EntityManager em;


    public List<Reservation> findAll() {
        List<Reservation> reservationList = em.createQuery("select r Reservation from r", Reservation.class)
                .getResultList();
        return reservationList;
    }
}
