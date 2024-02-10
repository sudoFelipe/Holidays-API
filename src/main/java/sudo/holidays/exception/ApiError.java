package sudo.holidays.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private HttpStatusCode status;

    private int code;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private String message;

    private String path;

    private List<ErrorField> errors;

    public ApiError(HttpStatusCode status, int code, LocalDateTime timestamp, String message, String path, List<ErrorField> errors) {
        this.status = status;
        this.code = status.value();
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.path = path;
        this.errors = errors;
    }
}
