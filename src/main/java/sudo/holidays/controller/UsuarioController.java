package sudo.holidays.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sudo.holidays.converter.UsuarioConverter;
import sudo.holidays.docs.UsuarioDocumentation;
import sudo.holidays.dto.UsuarioDTO;
import sudo.holidays.entity.Usuario;
import sudo.holidays.implementation.UsuarioServiceImp;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioController extends UsuarioDocumentation {

    private final UsuarioServiceImp usuarioService;
    private final UsuarioConverter converter;

    @PostMapping("create")
    @Transactional
    public UsuarioDTO inserirUsuario(@RequestBody @Valid UsuarioDTO usuario) {
        return this.usuarioService.inserirUsuario(converter.toUsuario(usuario));
    }
}
