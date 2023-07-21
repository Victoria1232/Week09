/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author mfgperez
 */
public class User implements Serializable {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Role role;
    private int roleID;
    private String roleName;

    public User(String email, String firstName, String lastName, String password , String roleName) {

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleName = roleName;
        this.password = password; 
        role = new Role(1, roleName);

    }

    public User(String email, String firstName, String lastName, int roleID)  throws InvalidArgumentException{

        
        if (roleID == 1) {
            this.roleName = "System Admin"; 
            this.roleID = roleID;
        }
        else if (roleID == 2) {
             this.roleName = "Regular User"; 
               this.roleID = roleID;
        }
        else {
            throw new InvalidArgumentException();
        }
       
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
      

    }

    public User(String email, String firstName, String lastName) {

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

    }

   

    public String toString() {

        return "User email: " + this.email + " user first name: " + this.firstName + " user last name: " + this.lastName + " user role: " + this.role;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getRoleName() {
        return role.getRoleName();
    }

    public int getRoleID() {
        return role.getRoleID();
    }

}
