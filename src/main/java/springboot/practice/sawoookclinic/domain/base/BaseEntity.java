package springboot.practice.sawoookclinic.domain.base;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class BaseEntity {
    private String createdAt;
    private LocalDate createdDate;

    private String updateAt;
    private LocalDate updateDate;
}
