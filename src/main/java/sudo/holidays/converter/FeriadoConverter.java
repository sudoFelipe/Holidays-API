package sudo.holidays.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sudo.holidays.dto.FeriadoDTO;
import sudo.holidays.entity.Feriado;
import sudo.holidays.implementation.UsuarioServiceImp;

import java.time.LocalDateTime;
import java.util.List;

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

    public Feriado toFeriado(FeriadoDTO feriado, Integer id) {

        final var feriadoConvertido = toFeriado(feriado);
        feriadoConvertido.setId(id);

        return feriadoConvertido;
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

    public List<FeriadoDTO> toFeriadoDTO(List<Feriado> feriados) {
        return feriados.stream()
                .map(this::toFeriadoDTO)
                .toList();
    }
}
