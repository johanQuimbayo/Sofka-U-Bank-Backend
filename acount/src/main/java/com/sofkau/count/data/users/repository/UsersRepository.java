package com.sofkau.count.data.users.repository;



import com.sofkau.count.data.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(Integer id);

    Optional<User> findByDocument(Integer document);

    Optional<User> findByEmail(String email);

    List<User> findAllByOrderByIdAsc();

}
