package Servlet;

import Bean.User;
import Dao.PlaceDAO;
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
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");
        String InputWord = request.getParameter("addPlace");

        PlaceDAO placeDAO = new PlaceDAO();
        placeDAO.AddPlace(user, InputWord);
        request.getRequestDispatcher("/findPlace").forward(request,response);
    }
}
