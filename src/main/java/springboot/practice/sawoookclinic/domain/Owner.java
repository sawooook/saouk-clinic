package springboot.practice.sawoookclinic.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import springboot.practice.sawoookclinic.domain.base.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
}
