package com.mero.musistore.config;

import com.mero.musistore.domain.model.Order;
import com.mero.musistore.domain.model.Product;
import com.mero.musistore.domain.model.ProductOrder;
import com.mero.musistore.domain.model.User;
import com.mero.musistore.domain.model.enums.CategoryEnum;
import com.mero.musistore.domain.model.enums.StatusOrderEnum;
import com.mero.musistore.domain.repository.OrdersRepository;
import com.mero.musistore.domain.repository.ProductOrdersRepository;
import com.mero.musistore.domain.repository.ProductsRepository;
import com.mero.musistore.domain.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Profile("local")
@Configuration
public class BdInit {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ProductOrdersRepository productOrdersRepository;

    @Bean
    public Boolean startDB() {
        User user1 = new User(null, "rodrigo", "123", "meroo@gmail.com", true, null);
        User user2 = new User(null, "rodrigo2", "123", "meroo@gmail.com", false, null);
        User user3 = new User(null, "rodrigo3", "123", "meroo@gmail.com", true, null);
        usersRepository.save(user1);
        usersRepository.save(user2);
        usersRepository.save(user3);

        Product product1 = new Product(null, "Guitarra", "descricao", CategoryEnum.INSTRUMENTO, BigDecimal.TEN, 10, true, null);
        Product product2 = new Product(null, "Afinador", "descricao", CategoryEnum.ACESSORIO, BigDecimal.TEN, 10, true, null);
        Product product3 = new Product(null, "Marshall", "descricao", CategoryEnum.AMPLIFICADOR, BigDecimal.TEN, 10, true, null);
        Product product4 = new Product(null, "Invisivel", "descricao", CategoryEnum.INSTRUMENTO, BigDecimal.TEN, 10, false, null);
        Product product5 = new Product(null, "Guitarra4", "descricao", CategoryEnum.INSTRUMENTO, BigDecimal.TEN, 10, true, null);
        Product product6 = new Product(null, "Guitarra4", "descricao", CategoryEnum.INSTRUMENTO, BigDecimal.TEN, 10, true, null);
        productsRepository.save(product1);
        productsRepository.save(product2);
        productsRepository.save(product3);
        productsRepository.save(product4);
        productsRepository.save(product5);
        productsRepository.save(product6);

        Order order = new Order(null, user1.getId(), LocalDateTime.now(), StatusOrderEnum.CONFIRMADO,2, BigDecimal.valueOf(20), null, null );
        ordersRepository.save(order);

        ProductOrder productOrder1 = new ProductOrder(null, 2, BigDecimal.valueOf(20), product1.getId(), order.getId(), null, null);
        productOrdersRepository.save(productOrder1);

        return Boolean.TRUE;
    }
}