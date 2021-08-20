package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void deleteRole(Long id) {
        Role roleDel = entityManager.find(Role.class, id);
        entityManager.remove(roleDel);
    }

    @Override
    public Role getRoleByName(String role) {
        return entityManager.createQuery("SELECT role FROM Role role JOIN FETCH role.users WHERE role.role=:role",
                Role.class).setParameter("role", role).getSingleResult();
    }

    @Override
    public List<Role> getRolesList() {
        return entityManager.createQuery("SELECT role FROM Role role JOIN FETCH role.users", Role.class).getResultList();
    }
}
