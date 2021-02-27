package springboot.practice.sawoookclinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.practice.sawoookclinic.domain.Doctor;
import springboot.practice.sawoookclinic.domain.dto.doctor.DoctorResponseDto;
import springboot.practice.sawoookclinic.repository.DoctorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public Doctor findOne(Long id) {
        Doctor doctor = doctorRepository.finOne(id);
        return doctor;
    }

    public List<DoctorResponseDto> findAll() {
        return doctorRepository.findAll()
                .stream().map(doctor -> new DoctorResponseDto(doctor)).collect(Collectors.toList());
    }
}
