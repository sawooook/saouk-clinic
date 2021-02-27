package springboot.practice.sawoookclinic.domain.dto;

import lombok.Getter;
import springboot.practice.sawoookclinic.domain.Owner;

@Getter
public class OwnerListResponseDto {
    private String name;
    private String city;
    private int age;
    private String telephone;

    public OwnerListResponseDto(Owner entity) {
        this.name = entity.getName();
        this.city = entity.getCity();
        this.telephone = entity.getTelephone();
        this.age = entity.getAge();
    }
}
