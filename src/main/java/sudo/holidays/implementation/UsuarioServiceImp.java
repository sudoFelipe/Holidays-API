package sudo.holidays.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sudo.holidays.entity.Usuario;
import sudo.holidays.exception.UsuarioNotFoundException;
import sudo.holidays.repository.UsuarioRepository;
import sudo.holidays.service.UsuarioService;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    public Usuario obterUsuario(Integer id) {
        return this.repository.findById(id)
                .orElseThrow(UsuarioNotFoundException::new);
    }
}
