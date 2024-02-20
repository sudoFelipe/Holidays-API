package sudo.holidays.converter;

import org.springframework.stereotype.Service;
import sudo.holidays.dto.UsuarioDTO;
import sudo.holidays.entity.Usuario;

@Service
public class UsuarioConverter {

    public Usuario toUsuario(UsuarioDTO usuario) {
        return Usuario.builder()
                .login(usuario.login())
                .senha(usuario.senha())
                .nome(usuario.nome())
                .build();
    }

    public UsuarioDTO toUsuarioDTO(Usuario retorno) {
        return UsuarioDTO.builder()
                .nome(retorno.getNome())
                .login(retorno.getLogin())
                .build();
    }
}
