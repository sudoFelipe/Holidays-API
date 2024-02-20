package sudo.holidays.entity;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Usuario")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "SENHA")
	private String senha;

	@Column(name = "NOME")
	private String nome;

	@OneToMany(fetch = LAZY)
	private List<Feriado> feriados;
}
