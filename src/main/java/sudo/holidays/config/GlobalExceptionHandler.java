package sudo.holidays.config;

import io.netty.handler.codec.CodecException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import sudo.holidays.dto.FeriadoDTO;
import sudo.holidays.exception.ApiError;
import sudo.holidays.exception.ErrorField;
import sudo.holidays.exception.FeriadoNotFoundException;
import sudo.holidays.exception.UsuarioNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({WebExchangeBindException.class, CodecException.class})
    public ResponseEntity<Object> handleInputFields(WebExchangeBindException ex, HandlerMethod handlerMethod) {

        final var lsErros = new ArrayList<ErrorField>();

        ex.getFieldErrors().forEach(
                error -> lsErros.add(new ErrorField(error.getField(), error.getDefaultMessage()))
        );

        final var apiError = ApiError.builder()
                .status(BAD_REQUEST)
                .message("O servidor não pode processar a requisição.")
                .path(getPathException(handlerMethod))
                .errors(lsErros)
                .build();

        return ResponseEntity.ofNullable(apiError);
    }

    @ExceptionHandler({UsuarioNotFoundException.class, FeriadoNotFoundException.class})
    public ResponseEntity<Object> handleUsuarioNotFoundException(Exception ex, HandlerMethod handlerMethod) {

        final var apiError = ApiError.builder()
                .status(NOT_FOUND)
                .message(ex.getMessage())
                .path(getPathException(handlerMethod))
                .build();

        return ResponseEntity.ofNullable(apiError);
    }

//    @ExceptionHandler({Exception.class})
//    public ResponseEntity<Object> handleStudentNotFoundException(Exception exception) {
//
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(exception);
//    }

    private String getPathException(HandlerMethod handlerMethod) {
        return new StringBuilder().append(handlerMethod.getBeanType().getName()).toString();
    }
}
