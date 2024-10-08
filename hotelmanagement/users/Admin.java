package hotelmanagement.users;

public class Admin extends User {
    private String adminPassword;

    public Admin(String name, String address, String phone, String adminPassword) {
        super(name, address, phone);
        this.adminPassword = adminPassword;
    }

    public boolean validatePassword(String inputPassword) {
        return this.adminPassword.equals(inputPassword);
    }
}
