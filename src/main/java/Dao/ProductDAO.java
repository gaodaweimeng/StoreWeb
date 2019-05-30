package Dao;

import Bean.Product;
import Bean.User;
import Util.DataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public ArrayList<Product> ShowAllProduct(){
        DataAccess dataAccess = new DataAccess();
        Connection con = dataAccess.getConnection();

        String sql = "select * from Product";

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
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally {
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
    return list;
    }

    public List<Product> ShowPersonalProduct(User user){
        DataAccess dataAccess = new DataAccess();
        Connection con = dataAccess.getConnection();
        String Email = user.getEmail();
        String sql = "select Product.id,name,type_rela_id,price,size,color,photo from Product,List,User where user_id=User.email and product_id=Product.id and user_id='"+Email+"'";

        Statement stmt=null;
        ResultSet rs=null;

        Product product;
        List<Product> list = new ArrayList<>();

        try {
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
        }finally {
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
        return list;
    }

    public void SearchProduct(User user) {}


    public void DeleteProduct(){

    }

}
