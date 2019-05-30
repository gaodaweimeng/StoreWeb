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
        String sql = "select Place.email,place from Place,User where User.email=Place.email and Place.email='"+Email+"'";
        Statement stmt=null;
        ResultSet rs=null;
        Place place;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                place = (Place) tableToClass(rs);
                place_list.add(place);
            }
        } catch(Exception ex){
            ex.printStackTrace();
        } finally{
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

    public static Object tableToClass(ResultSet rs) throws Exception {
        // TODO Auto-generated method stub
        Place place = new Place();
        place.setEmail(rs.getString("email"));
        place.setPlace(rs.getString("place"));
        return place;
    }
}
