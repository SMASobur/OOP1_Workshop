package se.lexicon;

import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Category electronics;
    private Category accessories;
    private Customer customer;
    private Order order;
    private Product product1;
    private Product product2;
    private Product product3;

    @BeforeEach
    void setUp() {
        electronics = new Category("Electronics");
        accessories = new Category("Accessories");
        customer = new Customer(1, "Anna", "anna@lexicon.com");
        order = new Order(101, customer);

        product1 = new Product(1, "Monitor", 7199.90, electronics);
        product2 = new Product(2, "Mouse", 349.90, accessories);
        product3 = new Product(3, "USB Cable", 90.0, accessories);
    }

    @Test
    @DisplayName("Should create order with valid data")
    void testCreateValidOrder() {
        assertNotNull(order);
        assertEquals(101, order.getOrderId());
        assertEquals(customer, order.getCustomer());
        assertTrue(order.getProducts().isEmpty());
    }

    @Test
    @DisplayName("Should throw exception when creating order with null customer")
    void testCreateOrderWithNullCustomer() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Order(102, null);
        });
        assertEquals("Order must have a customer.", exception.getMessage());
    }

    @Test
    @DisplayName("Should add product to order")
    void testAddProduct() {
        order.addProduct(product1);
        List<Product> products = order.getProducts();
        assertEquals(1, products.size());
        assertEquals(product1, products.get(0));
    }

    @Test
    @DisplayName("Should not add null product")
    void testAddNullProduct() {
        order.addProduct(null);
        assertEquals(0, order.getProducts().size());
    }

    @Test
    @DisplayName("Should add multiple products")
    void testAddMultipleProducts() {
        order.addProduct(product1);
        order.addProduct(product2);
        order.addProduct(product3);

        List<Product> products = order.getProducts();
        assertEquals(3, products.size());
        assertEquals(product1, products.get(0));
        assertEquals(product2, products.get(1));
        assertEquals(product3, products.get(2));
    }

    @Test
    @DisplayName("Should remove product from order")
    void testRemoveProduct() {
        order.addProduct(product1);
        order.addProduct(product2);
        order.addProduct(product3);

        assertEquals(3, order.getProducts().size());

        order.removeProduct(product2);
        List<Product> products = order.getProducts();
        assertEquals(2, products.size());
        assertEquals(product1, products.get(0));
        assertEquals(product3, products.get(1));
    }

    @Test
    @DisplayName("Should calculate total price correctly")
    void testCalculateTotal() {
        order.addProduct(product1); // 7199.90
        order.addProduct(product2); // 349.90
        order.addProduct(product3); // 90.00

        double expectedTotal = 7199.90 + 349.90 + 90.00;
        assertEquals(expectedTotal, order.calculateTotal(), 0.001);
    }

    @Test
    @DisplayName("Should return zero total for empty order")
    void testCalculateTotalForEmptyOrder() {
        assertEquals(0.0, order.calculateTotal(), 0.001);
    }

    @Test
    @DisplayName("Should calculate total correctly after removing products")
    void testCalculateTotalAfterRemoval() {
        order.addProduct(product1);
        order.addProduct(product2);
        order.addProduct(product3);

        double totalBeforeRemoval = order.calculateTotal();
        assertEquals(7199.90 + 349.90 + 90.00, totalBeforeRemoval, 0.001);

        order.removeProduct(product2);
        double totalAfterRemoval = order.calculateTotal();
        assertEquals(7199.90 + 90.00, totalAfterRemoval, 0.001);
    }

    @Test
    @DisplayName("Should return a copy of products list (immutable)")
    void testGetProductsReturnsCopy() {
        order.addProduct(product1);
        List<Product> products1 = order.getProducts();
        List<Product> products2 = order.getProducts();

        // Should be different instances
        assertNotSame(products1, products2);
        // But with same content
        assertEquals(products1, products2);

        // Modifying returned list should not affect order
        products1.add(product2);
        assertEquals(1, order.getProducts().size());
    }

    @Test
    @DisplayName("Should update customer")
    void testSetCustomer() {
        Customer newCustomer = new Customer(2, "Bob", "bob@test.com");
        order.setCustomer(newCustomer);
        assertEquals(newCustomer, order.getCustomer());
    }

    @Test
    @DisplayName("Should throw exception when setting null customer")
    void testSetNullCustomer() {
        assertThrows(IllegalArgumentException.class, () -> {
            order.setCustomer(null);
        });
    }

    @Test
    @DisplayName("Should handle duplicate products")
    void testAddDuplicateProducts() {
        order.addProduct(product1);
        order.addProduct(product1);
        order.addProduct(product1);

        List<Product> products = order.getProducts();
        assertEquals(3, products.size());
        assertEquals(product1, products.get(0));
        assertEquals(product1, products.get(1));
        assertEquals(product1, products.get(2));

        double expectedTotal = product1.getPrice() * 3;
        assertEquals(expectedTotal, order.calculateTotal(), 0.001);
    }

    @Test
    @DisplayName("Should display order without errors")
    void testDisplayOrder() {
        order.addProduct(product1);
        order.addProduct(product2);

        // This should not throw any exceptions
        assertDoesNotThrow(() -> order.displayOrder());
    }
}