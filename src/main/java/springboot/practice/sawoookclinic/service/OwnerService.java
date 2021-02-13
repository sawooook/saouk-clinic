package springboot.practice.sawoookclinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.practice.sawoookclinic.domain.Owner;
import springboot.practice.sawoookclinic.repository.OwnerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }
}
