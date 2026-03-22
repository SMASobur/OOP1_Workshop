package se.lexicon;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category("Electronics");
    }

    @Test
    @DisplayName("Should create category with valid name")
    void testCreateCategoryWithValidName() {
        assertNotNull(category);
        assertEquals("Electronics", category.getName());
    }

    @Test
    @DisplayName("Should throw exception when category name is null")
    void testCreateCategoryWithNullName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Category(null);
        });
        assertEquals("Category name cannot be empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when category name is empty")
    void testCreateCategoryWithEmptyName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Category("");
        });
        assertEquals("Category name cannot be empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when category name is only whitespace")
    void testCreateCategoryWithWhitespaceName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Category("   ");
        });
        assertEquals("Category name cannot be empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Should trim whitespace from category name")
    void testCategoryNameTrimming() {
        Category trimmedCategory = new Category("  Accessories  ");
        assertEquals("Accessories", trimmedCategory.getName());
    }

    @Test
    @DisplayName("Should update category name with valid value")
    void testSetValidCategoryName() {
        category.setName("New Category");
        assertEquals("New Category", category.getName());
    }

    @Test
    @DisplayName("Should throw exception when setting null category name")
    void testSetNullCategoryName() {
        assertThrows(IllegalArgumentException.class, () -> {
            category.setName(null);
        });
    }
}