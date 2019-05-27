package Dao;

import Bean.Place;
import Bean.User;
import Util.DataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaceDAO {
    public List<Place> showPlace(User user){
        List<Place> place_list = new ArrayList<>();
        DataAccess dataAccess = new DataAccess();
        Connection con = dataAccess.getConnection();

        String Email = user.getEmail();
        String sql = "select id , Place.email, place from StoreWeb.Place,StoreWeb.User where Place.email=User.email and Place.email=' "+Email+" ' ";
        Statement stmt=null;
        ResultSet rs=null;
        Place place;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                place = new Place();
                place.setId(rs.getInt("id"));
                place.setEmail(rs.getString("email"));
                place.setPlace(rs.getString("place"));
                place_list.add(place);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
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
        return place_list;
    }
}
