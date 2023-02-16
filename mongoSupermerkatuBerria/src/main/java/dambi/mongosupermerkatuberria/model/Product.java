package dambi.mongosupermerkatuberria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int _id;
    private String product_name;
    private double price;
    private Date delivery_date;
    private String origin;
    private List<String> categories;
    private boolean is_in_stock;
}


/*
    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }


    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Date getDeliveryDate() {
        return delivery_date;
    }

    public void setDeliveryDate(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public boolean isInStock() {
        return is_in_stock;
    }

    public void setInStock(boolean is_in_stock) {
        this.is_in_stock = is_in_stock;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return product_name;
    }

    public void setProductName(String product_name) {
        this.product_name = product_name;
    }
}
*/
