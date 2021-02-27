package springboot.practice.sawoookclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SawoookClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SawoookClinicApplication.class, args);
	}

}
