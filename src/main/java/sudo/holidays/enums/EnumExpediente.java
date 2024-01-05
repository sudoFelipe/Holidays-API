package sudo.holidays.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumExpediente {

	S("Sim"),
	N("Não");
	
	private String nome;
}
