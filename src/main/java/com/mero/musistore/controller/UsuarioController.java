package com.mero.musistore.controller;

import com.mero.musistore.domain.model.dto.UsuarioDTO;
import com.mero.musistore.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping("/{id}")
    public UsuarioDTO getUsuario(@PathVariable Integer id) {
        return service.buscarUsuario(id);
    }

    @PostMapping("/salvar")
    public Integer salvarUsuario(@RequestBody UsuarioDTO dto) {
        return service.salvar(dto);

    }
}
