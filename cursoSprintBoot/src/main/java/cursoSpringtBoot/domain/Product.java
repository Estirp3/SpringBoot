package cursoSpringtBoot.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//forzamos el llamado en orden del json
@JsonPropertyOrder({"id", "name", "price", "stock"})
public class Product {

    private Integer ID;
    private String Name;
    private Double price;
    private Integer stock;

    // Contructor vacio
    public Product(){}


    public Product(Integer ID, String Name, Double precio, Integer stock) {
        this.ID = ID;
        this.Name = Name;
        this.price = precio;
        this.stock = stock;
    }


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
