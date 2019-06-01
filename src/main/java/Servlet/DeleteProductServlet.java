package Servlet;

import Bean.User;
import Dao.ProductDAO;
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

@WebServlet(name = "DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");
        String Email = user.getEmail();
        Integer ProductId = Integer.valueOf(request.getParameter("pid"));

        ProductDAO productDAO = new ProductDAO();
        productDAO.DeleteProduct(ProductId,Email);
        request.getRequestDispatcher("/product_handler").forward(request,response);
    }
}
