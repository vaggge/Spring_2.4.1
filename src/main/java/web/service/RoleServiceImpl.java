package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDAO;
import web.model.Role;

@Component
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDAO roleDAO;

    @Transactional
    @Override
    public Role getRoleById(long id) {
       return roleDAO.getRoleByID(id);
    }
}
