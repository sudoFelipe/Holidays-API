package sudo.holidays.entity;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import sudo.holidays.enums.EnumExpediente;
import sudo.holidays.enums.EnumTipoFeriado;

@Data
@Entity
@Table(name = "Feriado")
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
	@ManyToOne
	private Usuario usuario;
	
	@Column(name = "DATA_INCLUSAO")
	private LocalDateTime dataInclusao;
	
	@Column(name = "TP_FERIADO")
	private EnumTipoFeriado tipoFeriado;

	@Column(name = "FL_PONTO_FACULTATIVO")
	private EnumExpediente flagPontoFacultativo;
}
