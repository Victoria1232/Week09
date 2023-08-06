package data_access;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Role;
import models.User;

/**
 *
 * @author Victo
 */
public class UserDB {

    public UserDB() {

    }

    public List<User> getAllUsers(int roleID) throws Exception {

        EntityManager eManager = DBUtil.getEmFactory().createEntityManager();

        // List<User> users = eManager.createNamedQuery("User.findAll", User.class).getResultList();
        try {

            Role roles = eManager.find(Role.class, roleID);
            return roles.getUserList();

        } finally {

            eManager.close();

        }

    }

    public User get(int roleID) throws Exception {

        EntityManager eManager = DBUtil.getEmFactory().createEntityManager();

        try {

            User user = eManager.find(User.class, roleID); // goes hear first 
            return user; // sets this to be returned seccond  / goes back to the return statment fourth then executes 
        } finally {
            eManager.close(); // does this third 
        }

    }

    public void insert(Role role, User user) throws Exception {

        EntityManager eManager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction eTransaction = eManager.getTransaction();

        try {

            role.getUserList().add(user); // add to role list (admin list , reg user list )
            eTransaction.begin();
            eManager.persist(user);
            //eManager.merge(role); 
            eTransaction.commit(); // save 
        } catch (Exception ex) {
            eTransaction.rollback(); // if problem rollback to the commit 

        } finally {
            eManager.close();
        }

    }

    public void update(User user) throws Exception {

        EntityManager eManager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction eTransaction = eManager.getTransaction();

        try {

            eTransaction.begin();
            eManager.merge(user);
            eTransaction.commit(); // save 
        } catch (Exception ex) {
            eTransaction.rollback(); // if problem rollback to the commit 

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
