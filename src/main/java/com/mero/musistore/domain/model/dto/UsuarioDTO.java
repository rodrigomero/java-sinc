package com.mero.musistore.domain.model.dto;

import com.mero.musistore.domain.model.Usuario;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Integer id;
    private String username;
    private String email;

    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(this, usuario);
        return usuario;
    }

    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        BeanUtils.copyProperties(usuario, dto);
        return dto;
    }
}
