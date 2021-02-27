package springboot.practice.sawoookclinic.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springboot.practice.sawoookclinic.domain.Doctor;

import javax.persistence.EntityManager;
import javax.print.Doc;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DoctorRepository {

    private final EntityManager em;

    public void save(Doctor doctor) {
        em.persist(doctor);
    }

    public Doctor finOne(Long doctorId) {
        return em.find(Doctor.class, doctorId);
    }

    public List<Doctor> findAll() {
        return em.createQuery("select D from DOCTOR D", Doctor.class).getResultList();
    }
}
