package sudo.holidays.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import sudo.holidays.client.IbgeClient;
import sudo.holidays.converter.FeriadoConverter;
import sudo.holidays.docs.FeriadoDocumentation;
import sudo.holidays.dto.FeriadoDTO;
import sudo.holidays.dto.SocketDTO;
import sudo.holidays.enums.EnumTipoFeriado;
import sudo.holidays.implementation.FeriadoServiceImp;
import sudo.holidays.service.SocketService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/holidays")
@RequiredArgsConstructor
public class FeriadoController extends FeriadoDocumentation {

	private final FeriadoServiceImp feriadoService;
	private final FeriadoConverter converter;

	private IbgeClient client;
	@Autowired
	private SocketService socket;

	@PostMapping
	@Transactional
	public FeriadoDTO criarFeriado(@RequestBody @Valid FeriadoDTO feriado) {
		return this.feriadoService.incluirFeriado(converter.toFeriado(feriado));
	}

	@PutMapping("/{idFeriado}")
	public FeriadoDTO modificarFeriado(@RequestBody @Valid FeriadoDTO feriado, @PathVariable Integer idFeriado) {
		return this.feriadoService.alterarFeriado(converter.toFeriado(feriado, idFeriado));
	}

	@DeleteMapping("/{idFeriado}")
	public void removerFeriado(@PathVariable Integer idFeriado) {
		this.feriadoService.deletarFeriado(idFeriado);
	}

	@PatchMapping("/{idFeriado}")
	public FeriadoDTO modificarDataFeriado(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFeriado, @PathVariable Integer idFeriado) {

		return this.feriadoService.alterarDataFeriado(idFeriado, dataFeriado);
	}

	@GetMapping("/{idFeriado}")
	public FeriadoDTO recuperarFeriadosAnuais(@PathVariable Integer idFeriado) {
		return this.feriadoService.obterFeriadoPorId(idFeriado);
	}

	@GetMapping
	public List<FeriadoDTO> recuperarFeriadosPorAno() {

		return this.feriadoService.obterFeriados();
	}

//	@GetMapping("/ano")
//	public FeriadoDTO recuperarFeriadosPorAno(@RequestParam Integer anoFeriado) {
//
//		return this.feriadoService.obterFeriadoPorAno(anoFeriado);
//	}
//
//	@PostMapping("/socket")
//	public void getCallSocket(@RequestBody SocketDTO infoSocket) {
//
//		socket.comunicarChegada(infoSocket);
//	}
}
