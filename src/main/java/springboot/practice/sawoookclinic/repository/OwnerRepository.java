package springboot.practice.sawoookclinic.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springboot.practice.sawoookclinic.domain.Owner;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OwnerRepository {

    private final EntityManager em;

    public void save(Owner owner) {
        em.persist(owner);
    }

    public Owner findOne(Long ownerId) {
        return em.find(Owner.class, ownerId);
    }

    public List<Owner> findAll() {
        return em.createQuery("SELECT o FROM Owner o", Owner.class)
                .getResultList();
    }
}
