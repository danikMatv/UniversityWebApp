package com.foxmided.univerweb.Service.ModelService;

import com.foxmided.univerweb.Models.Role;
import com.foxmided.univerweb.Models.User;
import com.foxmided.univerweb.Repository.UserRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }

    @Transactional
    public User addUser(@Param("username") String username, @Param("email") String email,
                        @Param("password") String password, @Param("userRole") String userRole) {
        User user = new User(username, email, password, Role.valueOf(userRole));
        return userRepository.save(user);
    }
}
