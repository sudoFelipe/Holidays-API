package sudo.holidays.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumTipoFeriado {

	N("Nacional"),
	E("Estadual"),
	L("Local");
	
	private String nome;
}
