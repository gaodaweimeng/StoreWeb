package Bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Place implements Serializable {
    private String email;
    private String place;

    public Place(){}

    public Place(Integer id, String email, String place){
        super();
        this.email = email;
        this.place = place;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
