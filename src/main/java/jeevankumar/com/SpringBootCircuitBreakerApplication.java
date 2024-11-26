package jeevankumar.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCircuitBreakerApplication.class, args);
	}

}
