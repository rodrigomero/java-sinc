package com.mero.musistore.domain.service.impl;

import com.mero.musistore.domain.model.User;
import com.mero.musistore.domain.model.dto.LoginDTO;
import com.mero.musistore.domain.model.dto.UserDTO;
import com.mero.musistore.domain.repository.UsersRepository;
import com.mero.musistore.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersRepository repository;

    @Override
    public UserDTO findUser(Integer id) {
        if (id == null) {
            //toDo implementar exception personalizada
            throw new RuntimeException("Id nulo");
        }
        Optional<User> usuario = repository.findById(id);

        return usuario.map(UserDTO::toDTO).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
    }

    @Override
    public UserDTO findByUsername(String username) {
        User user = repository.findByUsername(username);
        if(user == null) {
            throw new RuntimeException("Usuario nao encontrado");
        }
        return UserDTO.toDTO(user);
    }

    @Override
    public UserDTO saveUser(UserDTO dto) {
        if (dto.getId() != null) {
            return updateUser(dto);
        }
        User entity = dto.toEntity();
        repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    private UserDTO updateUser(UserDTO dto) {
        Optional<User> user = repository.findById(dto.getId());
        if (user.isEmpty()) {
            throw new RuntimeException("Usuario nao encontrado");
        }
        user.get().cloneFromDTO(dto);

        repository.save(user.get());
        return UserDTO.toDTO(user.get());
    }

    @Override
    public List<UserDTO> findAll() {
        repository.findAll().stream().allMatch(user -> user.getId() != null);
        return repository.findAll().stream()
                .map(UserDTO::toDTO).toList();
    }

    @Override
    public UserDTO login(LoginDTO dto) {
        UserDTO user = findByUsername(dto.getUsername());

        return user.getPassword().equals(dto.getPassword()) ? user : null;
    }
}
