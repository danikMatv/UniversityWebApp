package com.foxmided.univerweb.Repository;

import com.foxmided.univerweb.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT c FROM User c WHERE c.userName = :username")
    Optional<User> findByUsername(@Param("username") String username);

    @Query(value = "SELECT c FROM User c WHERE c.email = :email and c.password = :password")
    User findUserByEmailAndPassword(@Param("email") String email,@Param("password") String password);
}
