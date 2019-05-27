package Bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
    private String email;
    private String password;
    private String tel;

    public User(){}

    public User(String email, String password, String tel){
        super();
        this.email = email;
        this.password = password;
        this.tel = tel;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
