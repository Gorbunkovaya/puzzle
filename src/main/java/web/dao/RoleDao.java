package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {
    //User getRole(String name);

    void createRole(Role role);

    void updateRole(Role role);

    void deleteRole(Long id);

    List<Role> getRolesList();

    Role getRoleByName(String s);
}
