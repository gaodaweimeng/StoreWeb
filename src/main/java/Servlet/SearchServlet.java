package Servlet;

import Bean.Product;
import Dao.ProductDAO;
import Util.DataAccess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String search_word ='%'+request.getParameter("search_product")+'%';

        ProductDAO productDAO = new ProductDAO();
        ArrayList<Product> list = productDAO.SearchProduct(search_word);

        request.setAttribute("Product",list);
        request.getRequestDispatcher("/index_login.jsp").forward(request,response);
    }
}
