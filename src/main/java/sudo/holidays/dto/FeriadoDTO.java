package sudo.holidays.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import sudo.holidays.enums.EnumTipoFeriado;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FeriadoDTO(

        @NotNull(message = "campo obrigatório.")
        Integer uf,

        @NotNull(message = "campo obrigatório.")
        Integer municipio,

        @NotNull(message = "campo obrigatório.")
        LocalDate dataFeriado,

        LocalDateTime dataInclusao,

        @NotNull(message = "campo obrigatório.")
        Integer usuario,

        @NotNull(message = "campo obrigatório.")
        EnumTipoFeriado tipoFeriado,

        boolean flagPontoFacultativo

) {}
