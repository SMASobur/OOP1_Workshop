package se.lexicon;

public class Product {
    //Private fields (Encapsulation)
    private int productId;
    private String name;
    private double price;
    private Category category;

    // Constructor
    public Product(int productId, String name, double price,  Category category) {
        this.productId = productId;
        setName(name);
        setPrice(price);
    }

    // Getters and Setters,

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
    }
    public Category getCategory() { return category; }

    public String getProductInfo() {
        return "Product ID: " + productId + " | Name: " + name + " | Price: SEK " + price;
    }
}