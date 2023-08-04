package data_access;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Role;
import models.User;

/**
 *
 * @author mfgperez
 */
public class RoleDB {

    Role role;

    public RoleDB() {
    }
    // return an array of role objects 
    // then use role service 
    // then get role service then call method to get role name then add it to user 
    // 

    public Role get(String email) throws Exception {

        EntityManager eManager = DBUtil.getEmFactory().createEntityManager();

        try {

            Role roles = eManager.find(Role.class, email);
            return roles;

        } finally {

            eManager.close();

        }

    }

       public void delete(User user, Role role) throws Exception {

        EntityManager eManager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction eTransaction = eManager.getTransaction();

        try {

            role.getUserList().remove(user); // add to role list (admin list , reg user list )
            eTransaction.begin();
            eManager.remove(eManager.merge(user));
            eManager.merge(role);
            eTransaction.commit(); // save 
        } catch (Exception ex) {
            eTransaction.rollback(); // if problem rollback to the commit 

        } finally {
            eManager.close();
        }

    }

}
