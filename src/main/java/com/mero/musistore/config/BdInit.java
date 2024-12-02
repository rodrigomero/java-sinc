package com.mero.musistore.config;

import com.mero.musistore.domain.model.User;
import com.mero.musistore.domain.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local")
@Configuration
public class BdInit {
    @Autowired
    private UsersRepository repository;

    @Bean
    public User startDB() {
        User user = new User(null, "rodrigo", "123", "meroo@gmail.com", true, null);
        return repository.save(user);
    }
}