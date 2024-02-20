package sudo.holidays.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UsuarioDTO(

        @NotNull(message = "campo nome é obrigatório")
        String nome,

        @NotNull(message = "campo login é obrigatório")
        String login,

        @NotNull(message = "campo senha é obrigatório")
        String senha
) {}
