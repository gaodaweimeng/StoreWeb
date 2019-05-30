package Servlet;

import Bean.User;
import Util.DataAccess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "AddPlaceServlet")
public class AddPlaceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataAccess dataAccess = new DataAccess();
        Connection con = dataAccess.getConnection();

        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");

        PreparedStatement pst;
        String sql = "insert into Place(email, place) values(?, ?) ";

        try{
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getEmail());
            pst.setString(2, request.getParameter("addPlace"));
            pst.executeUpdate();
            con.commit();
            pst.close();
            con.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        request.getRequestDispatcher("/findPlace").forward(request,response);
    }
}
