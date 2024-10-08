package hotelmanagement.users;

public class bersih {
    public static void bersih() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Windows OS
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based OS (Linux/Mac)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
