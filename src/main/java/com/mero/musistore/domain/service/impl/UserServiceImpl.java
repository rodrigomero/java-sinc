package com.mero.musistore.domain.service.impl;

import com.mero.musistore.domain.model.User;
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
        if(id == null) {
            //toDo implementar exception personalizada
            throw new RuntimeException("Id nulo");
        }
        Optional<User> usuario = repository.findById(id);

        return usuario.map(UserDTO::toDTO).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
    }

    @Override
    public Integer saveUser(UserDTO dto) {
        User entity = dto.toEntity();
        repository.save(entity);

        return entity.getId();
    }

    @Override
    public List<UserDTO> findAll() {
        repository.findAll().stream().allMatch(user -> user.getId() != null);
        return repository.findAll().stream()
                .map(UserDTO::toDTO).toList();
    }
}
