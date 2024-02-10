package sudo.holidays.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sudo.holidays.client.IbgeClient;
import sudo.holidays.dto.FeriadoDTO;
import sudo.holidays.dto.SocketDTO;
import sudo.holidays.dto.ibge.UnidadeFederativaDTO;
import sudo.holidays.implementation.FeriadoServiceImp;
import sudo.holidays.service.FeriadoConverter;
import sudo.holidays.service.SocketService;

import java.util.List;

@RestController
@RequestMapping("/holidays")
@RequiredArgsConstructor
public class FeriadoController {

	private final FeriadoServiceImp feriadoService;
	private final FeriadoConverter converter;

	private IbgeClient client;
	@Autowired
	private SocketService socket;

	@PostMapping("/create")
	public FeriadoDTO criarFeriado(@RequestBody @Valid FeriadoDTO feriado) {
		return this.feriadoService.incluirFeriado(converter.toFeriado(feriado));
	}

	@GetMapping("/teste/{idUf}")
	public List<UnidadeFederativaDTO> recuperarFeriadosPorAno(@PathVariable Integer idUf) {
		return client.getUfs();
	}

	@PostMapping("/socket")
	public void getCallSocket(@RequestBody SocketDTO infoSocket) {

		socket.comunicarChegada(infoSocket);
	}
}
