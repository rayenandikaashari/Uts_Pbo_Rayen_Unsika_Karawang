package hotelmanagement.rooms;

public class SuiteRoom extends Room {
    public SuiteRoom(int roomNumber, int pricePerNight) {
        super(roomNumber, "Suite", pricePerNight);
    }

    public void displayRoomFacilities() {
        System.out.println("Fasilitas Kamar Suite:");
        System.out.println("1. Ukuran kamar sangat luas");
        System.out.println("2. Desain interior yang sangat mewah dan personal");
        System.out.println("3. Perabotan berkualitas tinggi");
        System.out.println("4. Fasilitas hiburan lengkap (televisi layar lebar, sistem suara surround)");
        System.out.println("5. Dapur kecil atau pantry");
        System.out.println("6. Ruang kerja yang nyaman");
        System.out.println("7. Kamar mandi yang sangat luas dengan bathtub, shower terpisah, dan ada sauna");
    }
}
