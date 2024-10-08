package hotelmanagement.rooms;

public class StandardRoom extends Room {
    public StandardRoom(int roomNumber, int pricePerNight) {
        super(roomNumber, "Standard", pricePerNight);
    }

    public void displayRoomFacilities() {
        System.out.println("Fasilitas Kamar Standar:");
        System.out.println("1. Tempat tidur single bed");
        System.out.println("2. Lemari pakaian");
        System.out.println("3. Meja dan kursi");
        System.out.println("4. Televisi");
        System.out.println("5. Kamar mandi dengan shower");
        System.out.println("6. Perlengkapan mandi dasar (sabun, sampo)");
        System.out.println("7. AC");
    }
}
