package sudo.holidays.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import sudo.holidays.entity.Feriado;

@Repository
public interface FeriadoRepository extends JpaRepository<Feriado, Integer>, PagingAndSortingRepository<Feriado, Integer> {

}
