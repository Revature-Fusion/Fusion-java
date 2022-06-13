package models;

import java.util.Arrays;
import java.util.Objects;

public class Product {

    private int p_id;
    private String name;
    private String desc;
    private float price;
    private int stock;
    private String picture;

    public Product() {}

    public Product(int p_id, String name, String desc, float price, int stock, String picture) {
        this.p_id = p_id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.stock = stock;
        this.picture = picture;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return p_id == product.p_id && Float.compare(product.price, price) == 0 && stock == product.stock && Objects.equals(name, product.name) && Objects.equals(desc, product.desc) && Objects.equals(picture, product.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p_id, name, desc, price, stock, picture);
    }
}
