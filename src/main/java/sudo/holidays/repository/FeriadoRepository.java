package sudo.holidays.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import sudo.holidays.dto.FeriadoDTO;
import sudo.holidays.entity.Feriado;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FeriadoRepository extends JpaRepository<Feriado, Integer>, PagingAndSortingRepository<Feriado, Integer> {

    @Query("""
            SELECT f FROM Feriado f
            WHERE f.dataFeriado
            between :start and :end
            """)
    List<Feriado> findByPeriod(LocalDate start, LocalDate end);

    List<Feriado> findByMunicipio(Integer idMunicipio);
}
