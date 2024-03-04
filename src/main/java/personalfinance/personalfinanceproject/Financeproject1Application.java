package personalfinance.personalfinanceproject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@SpringBootApplication
public class Financeproject1Application {

	public static void main(String[] args) {
		SpringApplication.run(Financeproject1Application.class, args);
	}

}
