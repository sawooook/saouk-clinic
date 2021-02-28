package springboot.practice.sawoookclinic.domain.dto.doctor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springboot.practice.sawoookclinic.domain.Doctor;

@Getter
@Setter
public class DoctorResponseDto {
    private String name;
    private Long id;

    public DoctorResponseDto(Doctor entity) {
        this.name = entity.getName();
        this.id = entity.getId();
    }
}
