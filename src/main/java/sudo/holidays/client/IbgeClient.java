package sudo.holidays.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import sudo.holidays.dto.ibge.MunicipioDTO;
import sudo.holidays.dto.ibge.UnidadeFederativaDTO;

import java.util.List;

public interface IbgeClient {

    @GetExchange("/estados/{id}/municipios")
    List<MunicipioDTO> getMunicipiosPorUf(@PathVariable Integer id);

    @GetExchange("/estados")
    List<UnidadeFederativaDTO> getUfs();

    @GetExchange("/estados/{id}/municipios")
    List<UnidadeFederativaDTO> getUfPorId(@PathVariable Integer id);
}
