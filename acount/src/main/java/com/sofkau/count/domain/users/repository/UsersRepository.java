package com.sofkau.count.domain.users.repository;



import com.sofkau.count.domain.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(Integer id);

    Optional<User> findByDocument(Integer document);

    Optional<User> findByEmail(String email);

}
