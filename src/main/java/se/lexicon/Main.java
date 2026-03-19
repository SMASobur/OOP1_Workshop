package se.lexicon;

public class Main {
    static void main() {
        System.out.println("Workshop OOP1\n");

        //crating customer

        Customer anna = new Customer(01, "Anna", "anna@mail.com");
        /*System.out.println(anna.getCustomerInfo());
        anna.setPhoneNumber("0737373700");
        System.out.println(anna.getCustomerInfo());*/

        //Create an Order and link it to Anna
        Order orderAnna = new Order(101, anna);

        orderAnna.addProduct(new Product(1, "Mouse", 99.9));
        orderAnna.addProduct(new Product(1, "Keyboard", 299.9));
        orderAnna.addProduct(new Product(1, "Pen", 49.9));


        //Show the summary
        orderAnna.displayOrder();
    }
}
