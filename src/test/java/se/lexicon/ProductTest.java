package se.lexicon;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Category electronics;
    private Product product;

    @BeforeEach
    void setUp() {
        electronics = new Category("Electronics");
        product = new Product(1, "Laptop", 999.99, electronics);
    }

    @Test
    @DisplayName("Should create product with valid data")
    void testCreateValidProduct() {
        assertNotNull(product);
        assertEquals(1, product.getProductId());
        assertEquals("Laptop", product.getName());
        assertEquals(999.99, product.getPrice());
        assertEquals(electronics, product.getCategory());
    }

    @Test
    @DisplayName("Should throw exception when product name is null")
    void testCreateProductWithNullName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product(2, null, 100.0, electronics);
        });
        assertEquals("Product name cannot be empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when product name is empty")
    void testCreateProductWithEmptyName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product(2, "", 100.0, electronics);
        });
        assertEquals("Product name cannot be empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when price is negative")
    void testCreateProductWithNegativePrice() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product(2, "Test", -50.0, electronics);
        });
        assertEquals("Price cannot be negative.", exception.getMessage());
    }

    @Test
    @DisplayName("Should allow zero price")
    void testCreateProductWithZeroPrice() {
        Product zeroPriceProduct = new Product(3, "Free Item", 0.0, electronics);
        assertEquals(0.0, zeroPriceProduct.getPrice());
    }

    @Test
    @DisplayName("Should update product name with valid value")
    void testUpdateProductName() {
        product.setName("New Product Name");
        assertEquals("New Product Name", product.getName());
    }

    @Test
    @DisplayName("Should update product price with valid value")
    void testUpdateProductPrice() {
        product.setPrice(1499.99);
        assertEquals(1499.99, product.getPrice());
    }

    @Test
    @DisplayName("Should update product category")
    void testUpdateProductCategory() {
        Category newCategory = new Category("Accessories");
        product.setCategory(newCategory);
        assertEquals(newCategory, product.getCategory());
    }

    @Test
    @DisplayName("Should throw exception when setting null category")
    void testSetNullCategory() {
        assertThrows(IllegalArgumentException.class, () -> {
            product.setCategory(null);
        });
    }

    @Test
    @DisplayName("Should return correct product info")
    void testGetProductInfo() {
        String expected = "Product ID: 1 | Name: Laptop | Price: SEK 999,99";
        assertEquals(expected, product.getProductInfo());
    }

    @Test
    @DisplayName("Should handle price with two decimal places in product info")
    void testProductInfoWithDecimals() {
        Product preciseProduct = new Product(4, "Precise", 99.999, electronics);
        String expected = "Product ID: 4 | Name: Precise | Price: SEK 100,00";
        assertEquals(expected, preciseProduct.getProductInfo());
    }
}