package springboot.practice.sawoookclinic.domain;


import lombok.Getter;
import lombok.Setter;
import springboot.practice.sawoookclinic.domain.base.BaseEntity;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Dog extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DOG_ID")
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

}
