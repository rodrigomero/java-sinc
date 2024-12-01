package com.mero.musistore.domain.service;

import com.mero.musistore.domain.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO findUser(Integer id);
    Integer saveUser(UserDTO dto);

    List<UserDTO> findAll();
}
