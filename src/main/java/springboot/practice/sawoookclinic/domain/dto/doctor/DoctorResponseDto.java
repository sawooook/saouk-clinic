package springboot.practice.sawoookclinic.domain.dto.doctor;

import lombok.Getter;
import springboot.practice.sawoookclinic.domain.Doctor;

@Getter
public class DoctorResponseDto {

    private Long id;
    private String name;

    public DoctorResponseDto(Doctor enitity) {
        this.id = enitity.getId();
        this.name = enitity.getName();
    }
}
