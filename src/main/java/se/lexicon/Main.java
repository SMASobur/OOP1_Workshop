package se.lexicon;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Create Categories
        Category electronics = new Category("Electronics");
        Category accessories = new Category("Accessories");
        Category networking = new Category("Networking");

        // 2. Create Customers
        Customer anna = new Customer(1, "Anna", "anna@lexicon.com");
        Customer ragavi = new Customer(2, "ragavi", "ragavi@lexicon.se");
        Customer muthana = new Customer(3, "muthana", "muthana@mail.com");
        Customer shamu = new Customer(4, "shamu", "shamu@lexicon.se");

        // 3. Define Products with Category objects
        Product p1 = new Product(1, "Monitor", 7199.90, electronics);
        Product p2 = new Product(2, "65-inch TV", 6150.0, electronics);
        Product p3 = new Product(3, "Laptop Backpack", 450.0, accessories);
        Product p4 = new Product(4, "Converter", 499.90, electronics);
        Product p5 = new Product(5, "Calculator", 250.0, electronics);
        Product p6 = new Product(6, "Headphones", 800.0, accessories);
        Product p7 = new Product(7, "Charger", 200.0, accessories);
        Product p8 = new Product(8, "Mouse", 349.90, accessories);
        Product p9 = new Product(9, "USB Cable", 90.0, accessories);
        Product p10 = new Product(10, "Router", 380.0, networking);
        Product p11 = new Product(11, "Type-C Cable", 180.0, accessories);
        Product p12 = new Product(12, "HDMI Cable", 180.0, accessories);

        // 4. Create Orders using methods
        createOrder(anna, 101, createProductList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10)); // Anna's Order with 10 products
        createOrder(muthana, 102, createProductList(p6, p8, p9));
        createOrder(shamu, 103, createProductList(p8, p11, p9, p7));
        createOrder(ragavi, 104, createProductList(p3, p10, p8, p1, p5, p6));
    }



    // Method to add products to a list
    private static List<Product> createProductList(Product... products) {
        List<Product> list = new ArrayList<>();
        for (Product p : products) {
            list.add(p);
        }
        return list;
    }

    // method to initialize the Order and display its summary
    private static void createOrder(Customer customer, int orderId, List<Product> products) {

        //This line calls the constructor of the Order class.
        Order order = new Order(orderId, customer);

        // Add each product to the order
        for (Product p : products) {
            order.addProduct(p);
        }
        // Display the results as summary
        order.displayOrder();
    }
}
