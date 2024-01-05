package sudo.holidays.entity;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "SENHA")
	private String senha;
	
	@OneToMany
	private List<Feriado> feriados;
}
