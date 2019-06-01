package Dao;

import Bean.User;
import Util.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    public Boolean Login(String email, String password){
        DataAccess dataAccess = new DataAccess();
        Connection con = dataAccess.getConnection();
        String sql = "select * from StoreWeb.User where email=? and password=?";
        PreparedStatement ps;
        ResultSet rs;
        boolean flag = false;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            rs=ps.executeQuery();
            if(rs.next()){
                flag=true;
            }
            rs.close();
            ps.close();
            con.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return flag;
    }

    public boolean Register(String email, String password, String tel){
        DataAccess dataAccess = new DataAccess();
        Connection conn = dataAccess.getConnection();
        ResultSet rs=null;
        PreparedStatement pst=null;
        boolean flag = false;

        User user = new User();
        try{
            conn.setAutoCommit(false);
            ArrayList<String> user_list = new ArrayList<>();
            String sql_search  = "select email from StoreWeb.User";
            pst = conn.prepareStatement(sql_search);
            rs = pst.executeQuery();

            while(rs.next()){
                user_list.add(rs.getString("email"));
            }

            if(!user_list.contains(user.getEmail())){
                String sql_update = "insert into StoreWeb.User(email, password, tel) values(?,?,?)";
                pst = conn.prepareStatement(sql_update);

                pst.setString(1,email);
                pst.setString(2,password);
                pst.setString(3,tel);
                pst.executeUpdate();
                conn.commit();
                flag = true;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                assert rs != null;
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

}
