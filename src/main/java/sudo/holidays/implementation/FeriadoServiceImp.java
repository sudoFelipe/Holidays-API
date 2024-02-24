package sudo.holidays.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sudo.holidays.converter.FeriadoConverter;
import sudo.holidays.dto.FeriadoDTO;
import sudo.holidays.dto.FiltroFeriadoDTO;
import sudo.holidays.entity.Feriado;
import sudo.holidays.enums.EnumTipoFeriado;
import sudo.holidays.exception.FeriadoNotFoundException;
import sudo.holidays.repository.FeriadoRepository;
import sudo.holidays.service.FeriadoService;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

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

    public FeriadoDTO alterarFeriado(Feriado feriado) {

        final var retorno = this.repository.findById(feriado.getId())
                .orElseThrow(FeriadoNotFoundException::new);

        return incluirFeriado(feriado);
    }

    public void deletarFeriado(Integer idFeriado) {
        this.repository.deleteById(idFeriado);
    }

    public FeriadoDTO alterarDataFeriado(Integer idFeriado, LocalDate data) {
        final var feriado = this.repository.findById(idFeriado)
                .orElseThrow(FeriadoNotFoundException::new);

        feriado.setDataFeriado(data);

        return incluirFeriado(feriado);
    }

    public FeriadoDTO obterFeriadoPorId(Integer idFeriado) {
        final var feriado = this.repository.findById(idFeriado)
                .orElseThrow(FeriadoNotFoundException::new);

        return converter.toFeriadoDTO(feriado);
    }

    public List<FeriadoDTO> obterFeriados() {

        final var feriados = buscarFeriados();

        validarExistenciaFeriados(feriados);

        return converter.toFeriadoDTO(feriados);
    }

    public List<FeriadoDTO> obterFeriadosPorAno(Integer ano) {

        final var feriados = buscarFeriadosPorAno(ano);

        validarExistenciaFeriados(feriados);

        return converter.toFeriadoDTO(feriados);
    }

    public List<FeriadoDTO> obterFeriadosPorMunicipio(Integer idMunicipio) {

        final var feriados = this.repository.findByMunicipio(idMunicipio);

        validarExistenciaFeriados(feriados);

        return converter.toFeriadoDTO(feriados);
    }

    public List<FeriadoDTO> obterFeriadosPorUf(Integer idUf) {

        final var feriados = this.repository.findByUf(idUf);

        validarExistenciaFeriados(feriados);

        return converter.toFeriadoDTO(feriados);
    }

    public List<FeriadoDTO> obterFeriadosPorTipo(EnumTipoFeriado tipoFeriado) {

        final var feriados = this.repository.findByTipoFeriado(tipoFeriado);

        validarExistenciaFeriados(feriados);

        return converter.toFeriadoDTO(feriados);
    }

    private List<Feriado> buscarFeriados() {
        return this.repository.findAll(Sort.by(Sort.Direction.DESC, "dataFeriado"));
    }

    private List<Feriado> buscarFeriadosPorAno(Integer year) {

        final var dataInicial = LocalDate.of(year, Month.JANUARY, LocalDate.MIN.getDayOfMonth());
        final var dataFinal = LocalDate.of(year, Month.DECEMBER, LocalDate.MAX.getDayOfMonth());

        return this.repository.findByPeriod(dataInicial, dataFinal);
    }

    private static void validarExistenciaFeriados(List<Feriado> feriados) {
        if (feriados.isEmpty())
            throw new FeriadoNotFoundException();
    }

    public List<FeriadoDTO> recuperarFeriadosPorFiltro(EnumTipoFeriado tipoFeriado, Integer anoFeriado, Integer idUf, Integer idMunicipio, Boolean flagPontoFacultativo) {

        final var filtro = montarFiltro(tipoFeriado, anoFeriado, idUf, idMunicipio, flagPontoFacultativo);

        return new ArrayList<>();
    }

    private FiltroFeriadoDTO montarFiltro(EnumTipoFeriado tipoFeriado, Integer anoFeriado, Integer idUf, Integer idMunicipio, Boolean flagPontoFacultativo) {
        return FiltroFeriadoDTO.builder()
                .tipoFeriado(tipoFeriado)
                .anoFeriado(anoFeriado)
                .idUf(idUf)
                .idMunicipio(idMunicipio)
                .flagPontoFacultativo(flagPontoFacultativo)
                .build();
    }
}
