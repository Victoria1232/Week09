package servlets;

import java.io.IOException;

import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

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

        UserService userService = new UserService();

        try {
            ArrayList<User> usersArray = userService.getAll();

            if (usersArray == null) {

                request.setAttribute("error", "No users found, Please add user");
            }

            request.setAttribute("users", usersArray);

        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex); // ???
        }

        // String edit = request.getParameter("edit");
        // String delete = request.getParameter("delete");
        String action = request.getParameter("action");

        if (action != null && action.equals("edit_link")) {
            
            String userEmail= request.getParameter("users_email");
            request.setAttribute("edit_table", true);
            request.setAttribute("email", userEmail); // set the email var in jsp to be the user email 
            try {
               // User user = userService.getUserByName(userName);
                //request.setAttribute("selectedUser", user);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

           

            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            return;

        }

        

        if (action != null && action.equals("delete")) {

            String userName = request.getParameter("user_name"); // worka
            try {

                //User user = userService.getUserByName(userName); // get selected user 
                userService.delete(userName); // delete that user 
                ArrayList<User> usersArray = userService.getAll(); // get users again to get the updated table  
                request.setAttribute("users", usersArray); // send to users 

            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("message", "Deleted user " + userName); // confirmation msg that user was deleted 

            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            return;

        }


       

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService();
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String password = request.getParameter("password");
        //String role = request.getParameter("");
        //String submitButton = request.getParameter("submitvalue");
        String action = request.getParameter("action");
       //String table = request.getParameter("edit_table");

        // if not filled out
        if (firstName == null || firstName.equalsIgnoreCase("") || lastName == null || lastName.equalsIgnoreCase("") || password == null || password.equalsIgnoreCase("")) {

            request.setAttribute("error", "All fields are required");
            request.setAttribute("email", email);
           
            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            return;
        }
        // otherwise 

        // create new user 
        User newUser = new User(email, firstName, lastName, password, 1);

        
        if (action.equalsIgnoreCase("edit")) { 
            
            String userName = request.getParameter("user_name"); // worka
            try {
                userService.update(newUser);
                    ArrayList<User> usersArray = userService.getAll(); // get users again to get the new user
                     request.setAttribute("users", usersArray); // send to users 
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
           
             request.setAttribute("message", "updated user: " + userName);
            
             getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
             return;
        }
        
        
        // otherwise add user if the action does not equal edit 
        try {
           
    
            userService.insert(newUser);
             ArrayList<User> usersArray = userService.getAll(); // get users again to get the new user
            request.setAttribute("users", usersArray); // send to users 
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        return;

    }

}
