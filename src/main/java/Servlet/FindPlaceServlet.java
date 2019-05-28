package Servlet;


import Bean.Place;
import Bean.User;
import Dao.PlaceDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "FindPlaceServlet")
public class FindPlaceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");
        List<Place> list=new PlaceDAO().showPlace(user);
        request.setAttribute("personal_place", list);
        request.getRequestDispatcher("/UserMessage.jsp").forward(request,response);
    }
}
