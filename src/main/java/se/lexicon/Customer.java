package se.lexicon;

public class Customer {
    //Private fields (Encapsulation)
    private int customerId;
    private String name;
    private String email;
    private String phoneNumber;

    //Constructors
    public Customer(int customerId, String name, String email){
        this.customerId=customerId;
        setName(name);
        setEmail(email);
    }
    // Default constructor
    public Customer() {
        this.customerId = 0;
        this.name = "Unknown";
        this.email = "Unknown";
        this.phoneNumber = null;
    }


    //Getters and Setters

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        this.email = email.toLowerCase().trim();
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    //Methods

    public String getCustomerInfo(){
        return "Customer ID: "+ customerId + ", Customer Name: " + name + ", Email: "+ email +", Phone Number: " + phoneNumber;
    }

}
