/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data_access.UserDB;
import java.util.List;
import models.User;

/**
 *
 * @author mfgperez
 */
public class UserService {
    
    private UserDB userDB;
    private final String path;

    public UserService(String path) {
        this.path = path;
    }
    
    
      public List<User> getAccounts() throws Exception {
          
        userDB = new UserDB(path);
        List<User> users = userDB.getAllUsers();
        
        return users;
    }
}
