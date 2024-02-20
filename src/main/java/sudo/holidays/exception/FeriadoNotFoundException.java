package sudo.holidays.exception;

public class FeriadoNotFoundException extends RuntimeException {

    public FeriadoNotFoundException () {
        super("O feriado não foi encontrado!");
    }
}
