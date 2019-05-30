package Servlet;

import Bean.Product;
import Util.DataAccess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "PriceSortServlet")
public class PriceSortServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataAccess dataAccess = new DataAccess();
        Connection con = dataAccess.getConnection();

        String sql = "select Product.id,name,type_rela_id,price,size,color,photo from Product order by price";
        Statement stmt = null;
        ResultSet rs = null;

        Product product;
        ArrayList<Product> list = new ArrayList<>();

        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

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
        }
        finally {
            try{
                if(rs!=null){
                    rs.close();
                }
                if(stmt!=null){
                    stmt.close();
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
