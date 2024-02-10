package sudo.holidays.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sudo.holidays.dto.FeriadoDTO;
import sudo.holidays.entity.Feriado;
import sudo.holidays.implementation.UsuarioServiceImp;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class FeriadoConverter {

    private final UsuarioServiceImp usuarioService;

    public Feriado toFeriado(FeriadoDTO feriado) {

        return Feriado.builder()
                .uf(feriado.uf())
                .municipio(feriado.municipio())
                .dataFeriado(feriado.dataFeriado())
                .usuario(this.usuarioService.obterUsuario(feriado.usuario()))
                .dataInclusao(LocalDateTime.now())
                .tipoFeriado(feriado.tipoFeriado())
                .flagPontoFacultativo(feriado.flagPontoFacultativo())
                .build();
    }

    public FeriadoDTO toFeriadoDTO(Feriado retorno) {

        return FeriadoDTO.builder()
                .uf(retorno.getUf())
                .municipio(retorno.getMunicipio())
                .dataFeriado(retorno.getDataFeriado())
                .usuario(retorno.getUsuario().getId())
                .dataInclusao(retorno.getDataInclusao())
                .tipoFeriado(retorno.getTipoFeriado())
                .flagPontoFacultativo(retorno.isFlagPontoFacultativo())
                .build();
    }
}
