package se.lexicon;

import java.util.ArrayList;
import java.util.List;

public class Order {
    //private fields
    private int orderId;
    private List<Product> products;
    private Customer customer;


    //Constructor
    public Order(int orderId, Customer customer){
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    // Add a product to the list
    public void addProduct(Product p) {
        if (p != null) {
            products.add(p);
        }
    }

    // Remove a product from the list
    public void removeProduct(Product p) {
        products.remove(p);
    }

    // Calculate total price
    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }
    //Getters & setters

    public Customer getCustomer() {
        return customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        for (Product p : products) {
            System.out.println( p.getProductInfo());
        }
        System.out.println("Total Order Value: SEK " + calculateTotal());
        System.out.println("------------------------------------------");
    }


}
