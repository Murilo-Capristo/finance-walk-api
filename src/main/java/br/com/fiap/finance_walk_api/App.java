package br.com.fiap.finance_walk_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API Finance Walk",
				version = "v1",
				description = "API do SaaS Finance Walk de controle financeiro",
				contact = @Contact(	name = "Murilo Capristo",
									email = "murilocapristo@gmail.com.br")


		)
)
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
