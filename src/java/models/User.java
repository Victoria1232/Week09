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

    String email;
    String firstName;
    String lastName;
    String password;
    String role;

    public User(String email, String firstName, String lastName, String password, String role) {

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;

    }
    
    public String toString() {
        
        return "User email: " + this.email + " user first name: " + this.firstName + " user last name: " + this.lastName + " user role: " + this.role;  
    }

}
