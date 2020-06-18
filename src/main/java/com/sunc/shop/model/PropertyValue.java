package com.sunc.shop.model;

/**
 * @auther sunc
 * @date 2020/4/23 16:43
 */
public class PropertyValue {

    private int id;
    private Product product;
    private Property property;
    private String value;

    @Override
    public String toString() {
        return "PropertyValue{" +
                "id=" + id +
                ", product=" + product +
                ", property=" + property +
                ", value='" + value + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
