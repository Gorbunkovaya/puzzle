package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {

    void createRole(Role role);

    void updateRole(Role role);

    void deleteRole(Long id);

    List<Role> getRolesList();

    Role getRoleByName(String s);
}
