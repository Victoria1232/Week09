/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import data_access.RoleDB;
import java.util.ArrayList;
import models.Role;


/**
 *
 * @author mfgperez
 */
public class RoleService {
    
    
    
        private final RoleDB ROLE_DB = new RoleDB();

    public RoleService() {

    }

    public ArrayList<Role> getAll() throws Exception {

        ArrayList<Role> roles = ROLE_DB.getAllRoles();
        return roles;
    }
}
