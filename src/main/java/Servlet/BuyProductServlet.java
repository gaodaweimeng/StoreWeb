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


@WebServlet(name = "BuyProductServlet")
public class BuyProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataAccess dataAccess = new DataAccess();
        Connection con = dataAccess.getConnection();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");
        PreparedStatement pst;

        try{
            con.setAutoCommit(false);

            int PID = Integer.parseInt(request.getParameter("pid"));

            String sql_update = "insert into StoreWeb.List(user_id, product_id, num) values(?,?,?)";
            pst = con.prepareStatement(sql_update);
            pst.setString(1, user.getEmail());
            pst.setInt(2, PID);
            pst.setInt(3, 1);
            pst.executeUpdate();
            con.commit();

            pst.close();
            con.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        request.getRequestDispatcher("/show_all_product").forward(request,response);
    }
}
