package sudo.holidays.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sudo.holidays.docs.UsuarioDocumentation;
import sudo.holidays.dto.UsuarioDTO;
import sudo.holidays.entity.Usuario;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioController extends UsuarioDocumentation {

    @PostMapping("create")
    public Usuario inserirUsuario(@RequestBody @Valid UsuarioDTO usuario) {



        return null;
    }
}
