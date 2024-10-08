package hotelmanagement.users;

public class User {
    private String name;
    private String address;
    private String phone;

    // Constructor untuk kelas User
    public User(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // Getter untuk nama
    public String getName() {
        return name;
    }

    // Setter untuk nama
    public void setName(String name) {
        this.name = name;
    }

    // Getter untuk alamat
    public String getAddress() {
        return address;
    }

    // Setter untuk alamat
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter untuk telepon
    public String getPhone() {
        return phone;
    }

    // Setter untuk telepon
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
