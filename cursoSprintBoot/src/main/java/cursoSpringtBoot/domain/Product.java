package cursoSpringtBoot.domain;

public class Product {

    private Integer ID;
    private String Name;
    private Double price;
    private Integer stock;

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
