public class Contact {
    private final String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String id, String firstName, String lastName, String phone, String address) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        if (phone == null) {
            throw new IllegalArgumentException("Phone number cannot be null");
        }
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        if (id.length() > 10) {
            throw new IllegalArgumentException("ID must be less than 10 characters");
        }
        if (firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be less than 10 characters");
        }
        if (lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must be less than 10 characters");
        }
        if (phone.length() != 10) {
            throw new IllegalArgumentException("Phone number must be exactly 10 characters");
        }
        if (address.length() > 30) {
            throw new IllegalArgumentException("Address must be less than 30 characters");
        }

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
