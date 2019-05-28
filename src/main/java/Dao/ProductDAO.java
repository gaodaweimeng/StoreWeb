package Dao;

import Bean.Product;
import Util.DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO {
    public ArrayList<Product> ShowAllProduct(){
        DataAccess dataAccess = new DataAccess();
        Connection con = dataAccess.getConnection();

        String sql = "select * from Product";

        Statement stmt = null;
        ResultSet rs = null;

        Product product = new Product();
        ArrayList<Product> list = new ArrayList<>();
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()){
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
}
