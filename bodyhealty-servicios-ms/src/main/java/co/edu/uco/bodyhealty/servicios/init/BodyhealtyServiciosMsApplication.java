package co.edu.uco.bodyhealty.servicios.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.bodyhealty"})
@EnableJpaRepositories(basePackages = "co.edu.uco.bodyhealty.servicios.application.secondaryports.repository")
@EntityScan(basePackages = "co.edu.uco.bodyhealty.servicios.application.secondaryports.entity")
public class BodyhealtyServiciosMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BodyhealtyServiciosMsApplication.class, args);
	}

}