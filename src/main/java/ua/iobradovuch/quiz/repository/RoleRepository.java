package ua.iobradovuch.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import ua.iobradovuch.quiz.model.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
    @Query(value = "select * from roles where roleid= (select roleid from user_role where userid = :id)", nativeQuery = true)
    List<Role> findRoleByUser(@Param("id") long id);
}
