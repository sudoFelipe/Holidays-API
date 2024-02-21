package sudo.holidays.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sudo.holidays.client.IbgeClient;
import sudo.holidays.docs.IbgeDocumentation;
import sudo.holidays.dto.ibge.MunicipioDTO;
import sudo.holidays.dto.ibge.UnidadeFederativaDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ibge")
public class IbgeController extends IbgeDocumentation {

    private final IbgeClient client;

    @GetMapping("/city")
    public List<MunicipioDTO> recuperarMunicipios(Integer idUf) {
        return client.getMunicipiosPorUf(idUf);
    }

    @GetMapping("/state")
    public List<UnidadeFederativaDTO> recuperarMunicipios() {
        return client.getUfs();
    }

    @GetMapping("/state/{idUf}")
    public UnidadeFederativaDTO recuperarEstados(Integer idUf) {
        return client.getUfPorId(idUf);
    }
}
