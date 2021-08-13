package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.model.Role;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao rl;

    @Override
    public void createRole(Role role) {
        rl.createRole(role);
    }

    @Override
    public void updateRole(Role role) {
        rl.updateRole(role);
    }

    @Override
    public void deleteRole(Long id) {
        rl.deleteRole(id);
    }

    @Override
    public List<Role> getRolesList() {
        return rl.getRolesList();
    }

    @Override
    public Role getRoleByName(String s) {
        return rl.getRoleByName(s);
    }
}
