/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data_access.UserDB;
import java.util.ArrayList;

import models.User;

/**
 *
 * @author mfgperez
 */
public class UserService {

    private final UserDB USER_DB = new UserDB();

    public UserService() {

    }

    public ArrayList<User> getAll() throws Exception {

        ArrayList<User> users = USER_DB.getAllUsers();
        return users;
    }

    public void insert(User user) throws Exception {

        USER_DB.insert(user);
    }

    public User getUserByName(String userName) throws Exception {

        return USER_DB.getUserName(userName);
    }

    public void update(User user) throws Exception {

        USER_DB.update(user);
    }

    public void delete(User user) throws Exception {

        USER_DB.delete(user);
    }
    
      public void delete(String userName) throws Exception {

        USER_DB.delete(userName);
    }
}
