package sudo.holidays;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "API de Feriados", version = "1.0", description = "API de gerenciamento de feriados."))
@SpringBootApplication
public class HolidaysApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolidaysApplication.class, args);
	}

}
