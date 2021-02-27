package springboot.practice.sawoookclinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.practice.sawoookclinic.domain.Owner;
import springboot.practice.sawoookclinic.domain.dto.OwnerForm;
import springboot.practice.sawoookclinic.domain.dto.OwnerListResponseDto;
import springboot.practice.sawoookclinic.repository.OwnerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public List<OwnerListResponseDto> findAll() {
        List<OwnerListResponseDto> ownerListResponseDtos = ownerRepository.findAll().stream().map(owner -> new OwnerListResponseDto(owner)).collect(Collectors.toList());
        return ownerListResponseDtos;
    }

    public Long join(Owner owner) {
        ownerRepository.save(owner);
        return owner.getId();
    }
}
