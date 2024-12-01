package com.mero.musistore.domain.model.dto;

import com.mero.musistore.domain.model.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    @NotEmpty(message = "username nao encontrado")
    private String username;
    private String password;
    private String email;
    private Boolean isAdmin;

    public User toEntity() {
        User user = new User();
        BeanUtils.copyProperties(this, user);
        return user;
    }

    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }
}
