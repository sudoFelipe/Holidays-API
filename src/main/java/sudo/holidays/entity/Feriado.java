package sudo.holidays.entity;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sudo.holidays.enums.EnumTipoFeriado;

@Data
@Entity
@Table(name = "Feriado")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Feriado {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	@Column(name = "UF")
	private Integer uf;
	
	@Column(name = "MUNICIPIO")
	private Integer municipio;
	
	@Column(name = "DATA_FERIADO")
	private LocalDate dataFeriado;
	
	@JoinColumn(name = "USUARIO")
	@ManyToOne(fetch = LAZY)
	private Usuario usuario;
	
	@Column(name = "DATA_INCLUSAO")
	private LocalDateTime dataInclusao;
	
	@Column(name = "TP_FERIADO")
	@Enumerated(EnumType.STRING)
	private EnumTipoFeriado tipoFeriado;

	@Column(name = "FL_PONTO_FACULTATIVO")
	private boolean flagPontoFacultativo;
}
