package com.picpaylira.picpayLira.repositories;

import com.picpaylira.picpayLira.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // We use option since we are not sure that the user will be found.
    // Just the declaration is fine because the Jpa repository already knows what to do since we followed a patter in the name of the method.
    Optional<User> findUserByDocument(String document);

    Optional<User> findUserById(Long id);

}
