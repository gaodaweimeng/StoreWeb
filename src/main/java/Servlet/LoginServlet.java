package Servlet;

import Util.DataAccess;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean flag=false;

        try{
            DataAccess dataAccess = new DataAccess();
            Connection con = dataAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from StoreWeb.User where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                flag=true;
            }
            rs.close();
            ps.close();
            con.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        if(flag){
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            request.getRequestDispatcher("/index_login.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }
}
