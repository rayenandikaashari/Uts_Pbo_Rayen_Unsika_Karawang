package hotelmanagement.rooms;

public interface Reservable {
    boolean reserve(int roomNumber, String name, String address, String phone);
    boolean cancel(int roomNumber, String name, String phone);
}
