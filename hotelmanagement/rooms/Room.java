package hotelmanagement.rooms;

import hotelmanagement.users.Customer;
import java.util.ArrayList;
import java.util.Scanner;

public class Room implements Reservable {
    protected int roomNumber;
    protected String roomType;
    protected int pricePerNight;
    private ArrayList<Integer> isAvailable;
    private ArrayList<Customer> roomBookings;
    private ArrayList<String> foodOrders;

    public Room(int roomNumber, String roomType, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = new ArrayList<>();
        this.roomBookings = new ArrayList<>();
        this.foodOrders = new ArrayList<>();
    }

    public ArrayList<Integer> getAvailableRooms() {
        return isAvailable;
    }

    public void setAvailableRooms(ArrayList<Integer> isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void addAvailableRooms(int startRoomNumber, int maxRooms) {
        for (int i = 0; i < maxRooms; i++) {
            int roomNumber = startRoomNumber + i;
            isAvailable.add(roomNumber);
        }
    }

    public void checkAvailability() {
        if (isAvailable.size() > 0) {
            System.out.println("Kamar yang tersedia : " + isAvailable);
        } else {
            System.out.println("Maaf, kamar sudah penuh.");
        }
    }

    public void displayAvailableRooms() {
        if (isAvailable.size() > 0) {
            System.out.println("Kamar yang tersedia : " + roomType + isAvailable);
        } else {
            System.out.println("All " + roomType + " rooms are fully booked.");
        }
    }
    
    public void hargaPerMalam(){
        System.out.println("Harga per malam : Rp " + pricePerNight);
    }

    public boolean getRoomDetails(String name, String phone) {
        for (Customer customer : roomBookings) {
            if (customer.getName().equalsIgnoreCase(name) && customer.getPhone().equals(phone)) {
                System.out.println("Detail Booking : ");
                customer.displayDetails();
                return true;
            }
        }
        return false;
    }

    public boolean reserve(int roomNumber, String name, String address, String phone) {
        if (isAvailable.contains(roomNumber)) {
            isAvailable.remove(Integer.valueOf(roomNumber));
            Customer customer = new Customer(name, address, phone, roomNumber, this.roomType);
            roomBookings.add(customer);
            System.out.println("Kamu telah memesan kamar " + roomNumber + "("+ this.roomType +").");
            return true;
        } else {
            System.out.println("Nomor kamar " + roomNumber + " tidak relevan.");
            return false;
        }
    }

    public boolean cancel(int roomNumber, String name, String phone) {
        for (Customer customer : roomBookings) {
            if (customer.getRoomNumber() == roomNumber && customer.getName().equalsIgnoreCase(name) && customer.getPhone().equals(phone)) {
                System.out.println("Detail Booking : ");
                customer.displayDetails();
                isAvailable.add(roomNumber);
                roomBookings.remove(customer);
                System.out.println("Nomor kamar " + roomNumber + " tidak relevan.");
                return true;
            }
        }
        System.out.println("Nama & Password tdak terdaftar pada ruangan " + roomNumber + ".");
        return false;
    }

    public void displayAllBookings() {
        if (roomBookings.isEmpty()) {
            System.out.println("Belum ada kamar yang di pesan.");
        } else {
            for (Customer customer : roomBookings) {
                System.out.println("\nDetail Booking untuk kamar " + customer.getRoomNumber() + ":");
                customer.displayDetails();
            }
        }
    }

    public boolean bookRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Apakah anda yakin ingin memesan kamar ini? (y/n): ");
        String confirm = scanner.next();
        return confirm.equalsIgnoreCase("y");
    }

    public boolean cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Apakah anda yakin ingin membatalkan pesanan? (y/n): ");
        String confirm = scanner.next();
        return confirm.equalsIgnoreCase("y");
    }

    public void displayRoomFacilities() {
        System.out.println("Fasilitas untuk kamar " + roomType + " tidak tersedia.");
    }
}
