/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import data_access.ConnectionPool;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.UserService;

/**
 *
 * @author mfgperez
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        /**
         * GAME PLAN
         * 
         * get everything from our data base 
         * create a bunch of user objects  using the result set containing all users in our db 
         * add to array list 
         * print out each one in jsp using jstl 
         * 
         * add edit feature 
         * and add user feature 
         * delete feature 
         *
         */
        
        UserService service = new UserService("hhh");
        
        
     /*
        try {
            // get accounts returns an array of accounts 
             List<User> users =  service.getAccounts();
             // set users to be accounts in jsp 
             request.setAttribute("accounts", users);
             
               ConnectionPool pool = ConnectionPool.getInstance(); // make a pool 
        Connection connection = pool.getConnection(); // get a connection object 
        
   ArrayList<User> usersArray = new ArrayList<>();
        String sql = "SELECT * FROM user"; 
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet users = ps.executedQuery();
        users.close();
        
        while (users.next()) {
            String email = users.getString(1);
            String firstName = users.getString(2);
            String lastName = users.getString(3);
            String password = users.getString(4);
            int role = users.getInt(5);
           
            
    }
        } catch (Exception e) {
           System.out.println("Error occured");
        }
       
        
      
        pool.freeConnection(connection); // close the connection object 

        String edit = request.getParameter("edit");
        String delete = request.getParameter("delete");
        
        
        if (edit != null) {
            // go to edit mode 
        }
        else if (delete != null) {
            // delete user 
        }

*/
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        return;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String password = request.getParameter("password");

        if (firstName == null || firstName.equalsIgnoreCase("") || lastName == null || lastName.equalsIgnoreCase("") || password == null || password.equalsIgnoreCase("")) {

            request.setAttribute("error", "All fields are required");
            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        return;

    }

}
