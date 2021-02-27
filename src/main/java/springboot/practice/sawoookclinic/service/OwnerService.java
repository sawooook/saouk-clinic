package springboot.practice.sawoookclinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.practice.sawoookclinic.domain.Owner;
import springboot.practice.sawoookclinic.domain.dto.owner.OwnerResponseDto;
import springboot.practice.sawoookclinic.repository.OwnerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public List<OwnerResponseDto> findAll() {
        List<OwnerResponseDto> ownerListResponseDtos = ownerRepository.findAll().stream().map(owner -> new OwnerResponseDto(owner)).collect(Collectors.toList());
        return ownerListResponseDtos;
    }

    public Long join(Owner owner) {
        ownerRepository.save(owner);
        return owner.getId();
    }

    public Owner findOne(Long id) {
        Owner owner = ownerRepository.findOne(id);
        return owner;
    }
}
