package Servlet;

import Bean.Product;
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
        DataAccess dataAccess = new DataAccess();
        Connection con = dataAccess.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;

        String search_word ='%'+request.getParameter("search_product")+'%';

        String sql="select Product.id,name,type_rela_id,price,size,color,photo from Product where Product.name like '"+search_word+"'";

        ArrayList<Product> list = new ArrayList<>();
        Product product;

        System.out.println(search_word);

        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()){
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setType_rela_id(rs.getInt("type_rela_id"));
                product.setPrice(rs.getString("price"));
                product.setSize(rs.getString("size"));
                product.setColor(rs.getString("color"));
                product.setPhoto(rs.getString("photo"));
                list.add(product);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try{
                if(rs!=null){
                    rs.close();
                }
                if(pst!=null){
                    pst.close();
                }
                if(con!=null){
                    con.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        System.out.println(list);
        request.setAttribute("Product",list);
        request.getRequestDispatcher("/index_login.jsp").forward(request,response);
    }
}
