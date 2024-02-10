package sudo.holidays.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record SocketDTO(
        @NotNull
        Integer id,
        @NotNull
        String name
) {}
