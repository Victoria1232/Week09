/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import models.User;

/**
 *
 * @author mfgperez
 */
public class UserDB {

    private String path;

    public UserDB(String path) {
        this.path = path;
    }

    public List<User> getAllUsers() throws Exception {
        
        ArrayList<User> usersArray = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(new File(path + "/users.txt")));
        String line = br.readLine();

        while (line != null) {
            
            String[] parts = line.split(",");
        
            User user = new User(parts[0], parts[1], parts[2], parts[3] , parts[4]);
            usersArray.add(user);
            line = br.readLine();
        }
        br.close();

        return usersArray;
    }
}
