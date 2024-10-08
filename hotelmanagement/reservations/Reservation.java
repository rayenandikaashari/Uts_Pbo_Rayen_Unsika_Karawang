package hotelmanagement.reservations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reservation {
    private List<FoodOrder> foodOrders = new ArrayList<>();

    class FoodOrder {
        private String customerName;
        private String foodItem;
        private int quantity;
        private double price;

        public FoodOrder(String customerName, String foodItem, int quantity, double price) {
            this.customerName = customerName;
            this.foodItem = foodItem;
            this.quantity = quantity;
            this.price = price;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getFoodItem() {
            return foodItem;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getTotalPrice() {
            return quantity * price;
        }

        public String toString() {
            return "Customer: " + customerName + ", Makanan: " + foodItem + ", Jumlah: " + quantity + ", Total Harga: " + getTotalPrice();
        }
    }

    public void customerMenu(Scanner scanner, String customerName) {
        boolean ordering = true;
        while (ordering) {
            System.out.println("\nMenu Makanan:");
            System.out.println("1. Nasi Goreng - Rp 30,000");
            System.out.println("2. Mie Goreng - Rp 25,000");
            System.out.println("3. Ayam Bakar - Rp 50,000");
            System.out.println("4. Soto Ayam - Rp 35,000");
            System.out.println("5. Sate Ayam - Rp 40,000");
            System.out.println("6. Gado-Gado - Rp 20,000");
            System.out.println("7. Bakso - Rp 30,000");
            System.out.println("8. Lihat Detail Pemesanan Makanan");
            System.out.println("9. Kembali");
            System.out.print("Pilih (1-9): ");
            int foodChoice = scanner.nextInt();

            switch (foodChoice) {
                case 1:
                    processFoodOrder(scanner, customerName, "Nasi Goreng", 30000);
                    break;
                case 2:
                    processFoodOrder(scanner, customerName, "Mie Goreng", 25000);
                    break;
                case 3:
                    processFoodOrder(scanner, customerName, "Ayam Bakar", 50000);
                    break;
                case 4:
                    processFoodOrder(scanner, customerName, "Soto Ayam", 35000);
                    break;
                case 5:
                    processFoodOrder(scanner, customerName, "Sate Ayam", 40000);
                    break;
                case 6:
                    processFoodOrder(scanner, customerName, "Gado-Gado", 20000);
                    break;
                case 7:
                    processFoodOrder(scanner, customerName, "Bakso", 30000);
                    break;
                case 8:
                    displayCustomerFoodOrders(customerName);
                    break;
                case 9:
                    ordering = false;
                    System.out.println("Kembali ke menu sebelumnya.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void processFoodOrder(Scanner scanner, String customerName, String foodItem, double price) {
        System.out.print("Masukkan jumlah: ");
        int quantity = scanner.nextInt();
        FoodOrder order = new FoodOrder(customerName, foodItem, quantity, price);
        foodOrders.add(order);
        System.out.println("Pesanan berhasil ditambahkan.");
    }

    private void displayCustomerFoodOrders(String customerName) {
        System.out.println("Detail Pemesanan Makanan untuk " + customerName + ":");
        boolean found = false;
        for (FoodOrder order : foodOrders) {
            if (order.getCustomerName().equals(customerName)) {
                System.out.println(order);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Tidak ada pesanan makanan.");
        }
    }

    public void adminMenu() {
        System.out.println("\nLaporan Pesanan Makanan:");
        if (foodOrders.isEmpty()) {
            System.out.println("Tidak ada pesanan makanan.");
        } else {
            for (FoodOrder order : foodOrders) {
                System.out.println(order);
            }
        }
    }
}
