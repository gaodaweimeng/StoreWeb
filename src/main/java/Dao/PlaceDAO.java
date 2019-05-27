package Dao;

import Bean.Place;
import Bean.User;
import Util.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceDAO {
    public ArrayList<Place> showPlace(User user){
        DataAccess dataAccess = new DataAccess();
        Connection con = dataAccess.getConnection();

        PreparedStatement pst;
        ResultSet rs;

        String Email = user.getEmail();

        String sql = "select Place.id,Place.place,Place.email from StoreWeb.Place,StoreWeb.User where User.email=Place.email and User.email=' "+Email+" '";

        ArrayList<Place> place_list = new ArrayList<>();
        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if(rs.next()){
                Place place = new Place();
                place.setId(rs.getInt("id"));
                place.setEmail(rs.getString("email"));
                place.setPlace(rs.getString("place"));
                place_list.add(place);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return place_list;
    }
}
