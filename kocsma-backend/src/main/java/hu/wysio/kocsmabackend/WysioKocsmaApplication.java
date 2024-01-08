package hu.wysio.kocsmabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EntityScan("hu.wysio.datamanager.model")
public class WysioKocsmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WysioKocsmaApplication.class, args);
	}

}
