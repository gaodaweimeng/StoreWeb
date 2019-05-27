package Bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {
    private Integer id;
    private String name;
    private Integer type_rela_id;
    private String price;
    private String size;
    private String color;
    private String photo;

    public Product(){}

    public Product(Integer id, String name, Integer type_rela_id, String price, String size, String color, String photo){
        super();
        this.id = id;
        this.name = name;
        this.type_rela_id = type_rela_id;
        this.price = price;
        this.size = size;
        this.color = color;
        this.photo = photo;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType_rela_id() {
        return type_rela_id;
    }

    public void setType_rela_id(Integer type_rela_id) {
        this.type_rela_id = type_rela_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
