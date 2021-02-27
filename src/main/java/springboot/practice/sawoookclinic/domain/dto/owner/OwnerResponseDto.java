package springboot.practice.sawoookclinic.domain.dto.owner;

import lombok.Getter;
import springboot.practice.sawoookclinic.domain.Owner;

@Getter
public class OwnerResponseDto {
    private Long id;
    private String name;
    private String city;
    private int age;
    private String telephone;

    public OwnerResponseDto(Owner entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.city = entity.getCity();
        this.telephone = entity.getTelephone();
        this.age = entity.getAge();
    }
}
