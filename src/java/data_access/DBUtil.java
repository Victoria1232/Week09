/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Victo
 */
public class DBUtil {
    
    // factory is used to create entity managers based on persist xml 
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("usersPU");
    
    // get this em factory 
    public static EntityManagerFactory getEmFactory() {
        
        return emf; 
    }
  
 
}
