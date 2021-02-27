package springboot.practice.sawoookclinic.domain;

import lombok.*;
import springboot.practice.sawoookclinic.domain.base.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Entity
public class Owner extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OWNER_ID")
    private Long id;

    private String name;

    private String city;

    private String telephone;

    private int age;

    @OneToMany(mappedBy = "owner")
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "owner")
    private List<Dog> dogs = new ArrayList<>();

    @Builder
    public Owner(Long id, String name, String city, String telephone, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.telephone = telephone;
        this.age = age;
    }
}
