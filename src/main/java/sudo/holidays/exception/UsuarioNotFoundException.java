package sudo.holidays.exception;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException() {
        super("Usuário informado não encontrado.");
    }
}
