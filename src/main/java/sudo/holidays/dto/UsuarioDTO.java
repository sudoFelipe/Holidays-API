package sudo.holidays.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UsuarioDTO(

        @NotNull
        String login,

        @NotNull
        String senha
) {}
