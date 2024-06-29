package ua.iobradovuch.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.iobradovuch.quiz.model.Role;
import ua.iobradovuch.quiz.repository.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public List<Role> getRolesByUser(long id) {
        return roleRepository.findRoleByUser(id);
    }

    @Override
    @Transactional
    public void saveRole (Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public Role findRoleByRoleName(String name) {
        return roleRepository.findByRoleName(name);
    }
}
