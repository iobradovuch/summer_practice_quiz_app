package ua.iobradovuch.quiz.service;

import org.springframework.stereotype.Service;
import ua.iobradovuch.quiz.model.Role;

import java.util.List;

@Service
public interface RoleService {
    void saveRole(Role role);
    Role findRoleByRoleName(String name);
    List<Role> getAllRoles();
    List<Role> getRolesByUser(long id);
}
