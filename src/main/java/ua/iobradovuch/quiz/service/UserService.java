package ua.iobradovuch.quiz.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ua.iobradovuch.quiz.model.User;

@Service
public interface UserService extends UserDetailsService {
    UserDetails loadUserByUsername(String username);
    User findByUserName(String name);
}
