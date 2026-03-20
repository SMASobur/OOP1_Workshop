package se.lexicon;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 1. Create Customers list
        Customer anna = new Customer(1, "Anna", "anna@lexicon.com");
        Customer ragavi = new Customer(2, "ragavi", "ragavi@lexicon.se");
        Customer muthana = new Customer(1, "muthana", "muthana@mail.com");
        Customer shamu = new Customer(2, "shamu", "shamu@lexicon.se");

        // 2. Define Products list
        Product p1 = new Product(1, "Monitor", 7199.90);
        Product p2 = new Product(2, "65-inch TV", 6150.0);
        Product p3 = new Product(3, "Laptop Backpack", 450.0);
        Product p4 = new Product(4, "Converter", 499.90);
        Product p5 = new Product(5, "Calculator", 250.0);
        Product p6 = new Product(6, "Headphones", 800.0);
        Product p7 = new Product(7, "Charger", 200.0);
        Product p8 = new Product(8, "Mouse", 349.90);
        Product p9 = new Product(9, "USB Cable", 90.0);
        Product p10 = new Product(10, "Router", 380.0);
        Product p11 = new Product(11, "Type-C Cable", 180.0);
        Product p12 = new Product(11, "HDMI Cable", 180.0);

        // 3. Create Orders using methods

        // Anna's Order with 10 products
        createOrder(anna, 101, createProductList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
        // Mutana's Order with a few products
        createOrder(muthana, 102, createProductList(p6, p8, p9));
        // Shamu's Order with a few products
        createOrder(shamu, 103, createProductList(p8, p11, p9, p7));
        // Ragavi's Order with a few products
        createOrder(ragavi, 103, createProductList(p3, p10, p8, p1, p5, p6));
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
