package se.lexicon;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer(1, "Anna", "anna@lexicon.com");
    }

    @Test
    @DisplayName("Should create customer with valid data")
    void testCreateValidCustomer() {
        assertNotNull(customer);
        assertEquals(1, customer.getCustomerId());
        assertEquals("Anna", customer.getName());
        assertEquals("anna@lexicon.com", customer.getEmail());
    }

    @Test
    @DisplayName("Should create default customer with no-arg constructor")
    void testDefaultConstructor() {
        Customer defaultCustomer = new Customer();
        assertEquals(0, defaultCustomer.getCustomerId());
        assertEquals("Unknown", defaultCustomer.getName());
        assertEquals("Unknown", defaultCustomer.getEmail());
        assertNull(defaultCustomer.getPhoneNumber());
    }

    @Test
    @DisplayName("Should throw exception when name is null")
    void testSetNullName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Customer(2, null, "test@test.com");
        });
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when name is empty")
    void testSetEmptyName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Customer(2, "", "test@test.com");
        });
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should trim whitespace from name")
    void testNameTrimming() {
        Customer trimmedCustomer = new Customer(2, "  John Doe  ", "john@test.com");
        assertEquals("John Doe", trimmedCustomer.getName());
    }

    @Test
    @DisplayName("Should throw exception when email is null")
    void testSetNullEmail() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Customer(2, "Test", null);
        });
        assertEquals("Email cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should convert email to lowercase")
    void testEmailToLowerCase() {
        Customer emailCustomer = new Customer(3, "Test", "TEST@EXAMPLE.COM");
        assertEquals("test@example.com", emailCustomer.getEmail());
    }

    @Test
    @DisplayName("Should set and get phone number")
    void testSetAndGetPhoneNumber() {
        customer.setPhoneNumber("123-456-7890");
        assertEquals("123-456-7890", customer.getPhoneNumber());
    }

    @Test
    @DisplayName("Should return correct customer info")
    void testGetCustomerInfo() {
        customer.setPhoneNumber("123-456-7890");
        String expected = "Customer ID: 1, Customer Name: Anna, Email: anna@lexicon.com, Phone Number: 123-456-7890";
        assertEquals(expected, customer.getCustomerInfo());
    }

    @Test
    @DisplayName("Should return customer info without phone number when not set")
    void testGetCustomerInfoWithoutPhone() {
        String expected = "Customer ID: 1, Customer Name: Anna, Email: anna@lexicon.com, Phone Number: null";
        assertEquals(expected, customer.getCustomerInfo());
    }

    @Test
    @DisplayName("Should update name with valid value")
    void testUpdateName() {
        customer.setName("Updated Name");
        assertEquals("Updated Name", customer.getName());
    }

    @Test
    @DisplayName("Should update email with valid value")
    void testUpdateEmail() {
        customer.setEmail("new@email.com");
        assertEquals("new@email.com", customer.getEmail());
    }
}