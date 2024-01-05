package sudo.holidays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FeriadoController {

	@GetMapping("/teste")
	public String recuperarFeriadosPorAno() {
		return "Teste";
	}
}
