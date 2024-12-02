package com.mero.musistore.domain.model;

import com.mero.musistore.domain.model.dto.UserDTO;
import com.mero.musistore.domain.utils.UtilReflection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String email;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orders;

    public void cloneFromDTO(UserDTO userDTO) {
        String[] ignoredProperties = UtilReflection.getIgnoredProperties(userDTO);
        BeanUtils.copyProperties(userDTO, this, ignoredProperties);
    }
}
