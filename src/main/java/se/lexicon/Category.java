package se.lexicon;

public class Category {
    private String name;

    public Category(String name) {
        setName(name);
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be empty.");
        }
        this.name = name.trim();
    }
}
