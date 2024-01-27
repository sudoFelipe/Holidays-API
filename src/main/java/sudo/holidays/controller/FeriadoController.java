package sudo.holidays.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sudo.holidays.client.IbgeClient;
import sudo.holidays.dto.ibge.UnidadeFederativaDTO;

import java.util.List;

@RestController
@RequestMapping("/holidays")
public class FeriadoController {

	@Autowired
	private IbgeClient client;

	@GetMapping("/teste/{idUf}")
	public List<UnidadeFederativaDTO> recuperarFeriadosPorAno(@PathVariable Integer idUf) {
		return client.getUfs();
	}
}
