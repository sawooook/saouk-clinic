package springboot.practice.sawoookclinic.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OwnerForm {

    private String name;
    private String city;
    private String street;
    private String zipcode;
}
