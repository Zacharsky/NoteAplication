package pl.kodu.akademia.NoteAplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NoteAplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteAplicationApplication.class, args);
	}
}
