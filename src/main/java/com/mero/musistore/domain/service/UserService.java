package com.mero.musistore.domain.service;

import com.mero.musistore.domain.model.dto.LoginDTO;
import com.mero.musistore.domain.model.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO findUser(Integer id);
    UserDTO findByUsername(String username);
    UserDTO saveUser(UserDTO dto);
    UserDTO login(LoginDTO dto);
    List<UserDTO> findAll();
}
