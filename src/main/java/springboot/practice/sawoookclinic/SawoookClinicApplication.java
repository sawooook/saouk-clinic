package springboot.practice.sawoookclinic;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springboot.practice.sawoookclinic.domain.Doctor;
import springboot.practice.sawoookclinic.repository.DoctorRepository;

@EnableJpaAuditing
@SpringBootApplication
public class SawoookClinicApplication {
	public static void main(String[] args) {
		SpringApplication.run(SawoookClinicApplication.class, args);
	}
}
