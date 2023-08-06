/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;



import data_access.DBUtil;
import data_access.RoleDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import models.Role;
import models.User;


/**
 *
 * @author Victo
 */
public class RoleService {
    
    
    
        private final RoleDB ROLE_DB = new RoleDB();

    public RoleService() {

    }

    public ArrayList<Role> getAll() throws Exception {

        //ArrayList<Role> roles = ROLE_DB.getAllRoles();
       // return roles;
       return null ;
    }
    
   public void delete(String userName) throws Exception {

       // ROLE_DB.delete(userName);
    }
   
   
     public void insert(Role role) throws Exception {

  
}
     
     
}
