package Servlet;

import Dao.UserDAO;

import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();

        if(userDAO.Login(email, password)){
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            request.getRequestDispatcher("/show_all_product").forward(request,response);
        }else {
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }
}
