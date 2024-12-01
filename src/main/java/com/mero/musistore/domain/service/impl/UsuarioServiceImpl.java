package com.mero.musistore.domain.service.impl;

import com.mero.musistore.domain.model.Usuario;
import com.mero.musistore.domain.model.dto.UsuarioDTO;
import com.mero.musistore.domain.repository.UsuarioRepository;
import com.mero.musistore.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    public UsuarioDTO buscarUsuario(Integer id) {
        if(id == null) {
            //toDo implementar exception personalizada
            throw new RuntimeException("Id nulo");
        }
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.map(UsuarioDTO::toDTO).orElse(null);
    }

    @Override
    public Integer salvar(UsuarioDTO dto) {
        Usuario entity = dto.toEntity();
        repository.save(entity);

        return entity.getId();
    }
}
