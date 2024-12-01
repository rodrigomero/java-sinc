package com.mero.musistore.domain.service;

import com.mero.musistore.domain.model.Usuario;
import com.mero.musistore.domain.model.dto.UsuarioDTO;

public interface UsuarioService {
    UsuarioDTO buscarUsuario(Integer id);
    Integer salvar(UsuarioDTO dto);

}
