package hotelmanagement.users;

public class Customer extends User {
    private int roomNumber;
    private String roomType;

    public Customer(String name, String address, String phone, int roomNumber, String roomType) {
        super(name, address, phone);
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayDetails() {
        System.out.println("Nama: " + getName());
        System.out.println("Alamat: " + getAddress());
        System.out.println("No Telepon: " + getPhone());
        System.out.println("Nomor Kamar: " + getRoomNumber());
        System.out.println("Tipe Kamar: " + getRoomType());
    }
}
