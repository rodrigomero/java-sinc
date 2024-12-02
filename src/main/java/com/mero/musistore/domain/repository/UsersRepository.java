package com.mero.musistore.domain.repository;

import com.mero.musistore.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
