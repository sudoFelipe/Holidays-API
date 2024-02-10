package sudo.holidays.service;

import sudo.holidays.dto.FeriadoDTO;
import sudo.holidays.entity.Feriado;

import java.util.Optional;

public interface FeriadoService {

    FeriadoDTO incluirFeriado(Feriado feriado);
}
