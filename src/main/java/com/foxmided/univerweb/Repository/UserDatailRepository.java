package com.foxmided.univerweb.Repository;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDatailRepository {
    UserDetails loadUserByUserName(String userName) throws UsernameNotFoundException;
    UserDetails loadUserByEmailAndPassword(String email,String password) throws UsernameNotFoundException;
}
