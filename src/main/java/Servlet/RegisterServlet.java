package Servlet;

import Bean.User;
import Util.DataAccess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataAccess dataAccess = new DataAccess();
        Connection conn = dataAccess.getConnection();

        ResultSet rs;
        PreparedStatement pst;

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
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String tel = request.getParameter("tel");
                pst.setString(1,email);
                pst.setString(2,password);
                pst.setString(3,tel);
                pst.executeUpdate();
                conn.commit();
                flag = true;
            }
            rs.close();
            pst.close();
            conn.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        if(flag){
            request.getRequestDispatcher("/LogIn.jsp").forward(request,response);
        }
    }
}
