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
        String sql = "select Product.id,name,type_rela_id,price,size,color,photo from Product,ShopList,User where user_id=User.email and product_id=Product.id and user_id='"+Email+"'";

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

    public void BuyProduct(User user, Integer PID) {
        DataAccess dataAccess = new DataAccess();
        Connection con = dataAccess.getConnection();
        PreparedStatement pst=null;

        try{
            con.setAutoCommit(false);

            String sql_update = "insert into StoreWeb.ShopList(user_id, product_id, num) values(?,?,?)";
            pst = con.prepareStatement(sql_update);
            pst.setString(1, user.getEmail());
            pst.setInt(2, PID);
            pst.setInt(3, 1);
            pst.executeUpdate();
            con.commit();

            pst.close();
            con.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try{
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
    }


    public void DeleteProduct(Integer ProductId, String Email){
        DataAccess dataAccess = new DataAccess();
        Connection con = dataAccess.getConnection();
        String sql = "delete from StoreWeb.ShopList where product_id='"+ProductId+"' and user_id='"+Email+"'";
        PreparedStatement pst=null;

        try{
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            con.commit();
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                assert pst != null;
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Product> SearchProduct(String search_word){
        DataAccess dataAccess = new DataAccess();
        Connection con = dataAccess.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="select Product.id,name,type_rela_id,price,size,color,photo from Product where Product.name like '"+search_word+"' or Product.color like'"+search_word+"'";

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
        return list;
    }

    public ArrayList<Product> PriceSort(){
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
        return list;
    }
}
