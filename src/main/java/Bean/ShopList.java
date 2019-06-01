package Bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ShopList implements Serializable {
    private String user_id;
    private Integer product_id;
    private Integer num;

    public ShopList(){}

    public ShopList(String user_id, Integer product_id, Integer num){
        this.user_id = user_id;
        this.product_id = product_id;
        this.num = num;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
