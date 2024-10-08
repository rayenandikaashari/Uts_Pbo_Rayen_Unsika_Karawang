package hotelmanagement.rooms;

public class DeluxeRoom extends Room {
    public DeluxeRoom(int roomNumber, int pricePerNight) {
        super(roomNumber, "Deluxe", pricePerNight);
    }

    public void displayRoomFacilities() {
        System.out.println("Fasilitas Kamar Deluxe:");
        System.out.println("1. Ukuran kamar lebih luas");
        System.out.println("2. Desain interior yang lebih elegan dan modern");
        System.out.println("3. Tempat tidur yang lebih nyaman (kasur berukuran king-size)");
        System.out.println("4. Pilihan bantal yang lebih beragam");
        System.out.println("5. Kamar mandi yang lebih besar dengan bathtub atau shower rain");
        System.out.println("6. Perlengkapan mandi yang lebih lengkap dan bermerek");
        System.out.println("7. Akses internet berkecepatan tinggi");
        System.out.println("8. Minibar atau kulkas mini");
    }
}
