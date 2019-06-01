package Servlet;

import Bean.User;
import Dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "BuyProductServlet")
public class BuyProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");
        int PID = Integer.parseInt(request.getParameter("pid"));

        ProductDAO productDAO = new ProductDAO();
        productDAO.BuyProduct(user,PID);
        request.getRequestDispatcher("/show_all_product").forward(request,response);
    }
}
