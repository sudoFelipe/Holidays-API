package sudo.holidays.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sudo.holidays.dto.FeriadoDTO;
import sudo.holidays.entity.Feriado;
import sudo.holidays.repository.FeriadoRepository;
import sudo.holidays.service.FeriadoConverter;
import sudo.holidays.service.FeriadoService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeriadoServiceImp implements FeriadoService {

    private final FeriadoRepository repository;
    private final FeriadoConverter converter;

    @Override
    public FeriadoDTO incluirFeriado(Feriado feriado) {

        final var retorno = this.repository.save(feriado);

        return converter.toFeriadoDTO(retorno);
    }
}
