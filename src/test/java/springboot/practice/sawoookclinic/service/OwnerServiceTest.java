package springboot.practice.sawoookclinic.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import springboot.practice.sawoookclinic.domain.Owner;
import springboot.practice.sawoookclinic.repository.OwnerRepository;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OwnerServiceTest {

    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    OwnerService ownerService;

    @Test
    void 주인저장된지_확인() {
        Owner owner = new Owner();
        owner.setTelephone("010");
        owner.setCity("seoul");
        owner.setName("saouk");
        owner.setAge(18);

        System.out.println("=======================");
        System.out.println(owner);
        System.out.println("=======================");

        ownerRepository.save(owner);

        Owner findOwner = ownerRepository.findOne(owner.getId());
        Assertions.assertThat(owner.getId()).isEqualTo(findOwner.getId());
    }

    @Test
    void 주인리스트가져오는지확인() {
        Owner owner = new Owner();
        owner.setTelephone("010");
        owner.setCity("seoul");
        owner.setName("saouk");
        owner.setAge(18);

        Owner owner1 = new Owner();
        owner1.setTelephone("010");
        owner1.setCity("seoul");
        owner1.setName("saouk");
        owner1.setAge(18);

        ownerRepository.save(owner);
        ownerRepository.save(owner1);

        List<Owner> all = ownerService.findAll();

        // 1번 저장 주인
        Assertions.assertThat(owner.getId()).isEqualTo(all.get(0).getId());

        // 2번 저장 주인
        Assertions.assertThat(owner1.getId()).isEqualTo(all.get(1).getId());
    }

}