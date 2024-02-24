package sudo.holidays.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import sudo.holidays.enums.EnumTipoFeriado;

@Builder
@AllArgsConstructor
public record FiltroFeriadoDTO(

        EnumTipoFeriado tipoFeriado,

        Integer anoFeriado,

        Integer idUf,

        Integer idMunicipio,

        Boolean flagPontoFacultativo
) {
}
