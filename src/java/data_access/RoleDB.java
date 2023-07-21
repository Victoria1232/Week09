/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access;

/**
 *
 * @author mfgperez
 */
public class RoleDB {
    
    
    
    
    
    public ArrayList<User> getAllUsers() throws Exception {

        ArrayList<User> users = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM user"; 

        try {
            ps = con.prepareStatement(sql);
            // ps.setString(1, owner); // set ? in query  
            rs = ps.executeQuery();

            while (rs.next()) {

                String email = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                //String role = rs.getString(4);
                //int role = rs.getInt(4);

                User user = new User(email, firstName, lastName);
                users.add(user);
            }
        } finally {
            DBUtil.closePreparedStatement(ps); // equivalent to ps.close()
            DBUtil.closeResultSet(rs); // equivalent to rs.close()
            cp.freeConnection(con);
        }

        return users;
    }
}
