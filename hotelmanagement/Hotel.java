package hotelmanagement;

import java.util.Scanner;
import hotelmanagement.rooms.DeluxeRoom;
import hotelmanagement.rooms.StandardRoom;
import hotelmanagement.rooms.SuiteRoom;
import hotelmanagement.rooms.Room;
import hotelmanagement.users.Admin;
import hotelmanagement.reservations.Reservation;

public class Hotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Admin", "", "", "admin123");

        Room deluxe = new DeluxeRoom(101, 2250000);
        Room standard = new StandardRoom(111, 1000000);
        Room suite = new SuiteRoom(121, 3500000);

        deluxe.addAvailableRooms(101, 10);
        standard.addAvailableRooms(111, 10);
        suite.addAvailableRooms(121, 5);

        Reservation reservation = new Reservation();

        boolean running = true;

        while (running) {
            boolean isAdmin = false;
            boolean isCustomer = false;

            // Proses login
            while (!isAdmin && !isCustomer) {
                System.out.println("Login sebagai:");
                System.out.println("1. Admin");
                System.out.println("2. Customer");
                System.out.println("3. Keluar");
                System.out.print("Pilih (1-3): ");
                int loginChoice = scanner.nextInt();

                if (loginChoice == 1) {
                    System.out.print("Masukkan password admin: ");
                    String inputPassword = scanner.next();

                    if (admin.validatePassword(inputPassword)) {
                        isAdmin = true;
                        System.out.println("Login sebagai Admin berhasil.");
                    } else {
                        System.out.println("Password salah.");
                    }
                } else if (loginChoice == 2) {
                    isCustomer = true;
                    System.out.println("Login sebagai Customer berhasil.");
                } else if (loginChoice == 3) {
                    System.out.println("Terima kasih, sampai jumpa lagi.");
                    running = false;
                    break;
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            }

            while (isAdmin || isCustomer) {
                if (isAdmin) {
                    boolean adminMenu = true;
                    while (adminMenu) {
                        System.out.println("\nMenu Admin:");
                        System.out.println("1. Lihat Semua Kamar Kosong");
                        System.out.println("2. Lihat Semua Detail Pemesanan");
                        System.out.println("3. Lihat Laporan Makanan");
                        System.out.println("4. Pesan Kamar");
                        System.out.println("5. Cancel Kamar");
                        System.out.println("6. Beralih Akun");
                        System.out.println("7. Keluar");
                        System.out.print("Masukkan pilihan (1-8): ");
                        int choice = scanner.nextInt();

                        switch (choice) {
                            case 1:
                                deluxe.checkAvailability();
                                standard.checkAvailability();
                                suite.checkAvailability();
                                break;
                            case 2:
                                deluxe.displayAllBookings();
                                standard.displayAllBookings();
                                suite.displayAllBookings();
                                break;
                            case 3:
                                reservation.adminMenu();
                                break;
                            case 4:
                                boolean bookingRoom = true;
                                while (bookingRoom) {
                                    System.out.println("\nPilih tipe kamar:");
                                    System.out.println("1. Deluxe");
                                    System.out.println("2. Standard");
                                    System.out.println("3. Suite");
                                    System.out.println("4. Kembali");  // Opsi kembali
                                    System.out.print("Masukkan pilihan (1-4): ");
                                    int roomTypeChoice = scanner.nextInt();

                                    Room selectedRoom = null;
                                    switch (roomTypeChoice) {
                                        case 1:
                                            selectedRoom = deluxe;
                                            deluxe.displayRoomFacilities();
                                            deluxe.displayAvailableRooms();
                                            deluxe.hargaPerMalam();
                                            break;
                                        case 2:
                                            selectedRoom = standard;
                                            standard.displayRoomFacilities();
                                            standard.displayAvailableRooms();
                                            standard.hargaPerMalam();
                                            break;
                                        case 3:
                                            selectedRoom = suite;
                                            suite.displayRoomFacilities();
                                            suite.displayAvailableRooms();
                                            suite.hargaPerMalam();
                                            break;
                                        case 4:
                                            bookingRoom = false;  // Kembali ke menu admin
                                            break;
                                        default:
                                            System.out.println("Pilihan tidak valid.");
                                    }

                                    if (selectedRoom != null && selectedRoom.bookRoom()) {
                                        System.out.print("Masukkan nomor kamar: ");
                                        int roomNumber = scanner.nextInt();
                                        System.out.print("Masukkan nama customer: ");
                                        String name = scanner.next();
                                        System.out.print("Masukkan alamat customer: ");
                                        String address = scanner.next();
                                        System.out.print("Masukkan nomor telepon customer: ");
                                        String phone = scanner.next();

                                        if (selectedRoom.reserve(roomNumber, name, address, phone)) {
                                            System.out.println("Pemesanan berhasil.");
                                        } else {
                                            System.out.println("Pemesanan gagal.");
                                        }
                                    } else if (roomTypeChoice != 4) {
                                        System.out.println("Pemesanan dibatalkan.");
                                    }
                                }
                                break;
                            case 5:
                                System.out.print("Masukkan nomor kamar: ");
                                int roomToCancel = scanner.nextInt();
                                System.out.print("Masukkan nama customer: ");
                                String cancelName = scanner.next();
                                System.out.print("Masukkan nomor telepon customer: ");
                                String cancelPhone = scanner.next();

                                if (deluxe.cancel(roomToCancel, cancelName, cancelPhone) ||
                                    standard.cancel(roomToCancel, cancelName, cancelPhone) ||
                                    suite.cancel(roomToCancel, cancelName, cancelPhone)) {
                                    System.out.println("Pemesanan berhasil dibatalkan.");
                                } else {
                                    System.out.println("Pembatalan gagal.");
                                }
                                break;
                            case 6:
                                isAdmin = false;
                                adminMenu = false;
                                System.out.println("Beralih akun...");
                                break;
                            case 7:
                                running = false;
                                isAdmin = false;
                                adminMenu = false;
                                System.out.println("Terima kasih, Admin.");
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                        }
                    }
                } else if (isCustomer) {
                    boolean customerMenu = true;
                    while (customerMenu) {
                        System.out.println("\nMenu Customer:");
                        System.out.println("1. Pesan Kamar");
                        System.out.println("2. Lihat Kamar Kosong");
                        System.out.println("3. Pesan Makanan");
                        System.out.println("4. Cancel Kamar");
                        System.out.println("5. Lihat Detail Pemesanan Anda");
                        System.out.println("6. Beralih Akun");
                        System.out.println("7. Keluar");
                        System.out.print("Masukkan pilihan (1-8): ");
                        int choice = scanner.nextInt();

                        switch (choice) {
                            case 1:
                                boolean bookingCustomerRoom = true;
                                while (bookingCustomerRoom) {
                                    System.out.println("\nPilih tipe kamar:");
                                    System.out.println("1. Deluxe");
                                    System.out.println("2. Standard");
                                    System.out.println("3. Suite");
                                    System.out.println("4. Kembali");
                                    System.out.print("Masukkan pilihan (1-4): ");
                                    int roomTypeChoice = scanner.nextInt();

                                    Room selectedRoom = null;
                                    switch (roomTypeChoice) {
                                        case 1:
                                            selectedRoom = deluxe;
                                            deluxe.displayRoomFacilities();
                                            deluxe.displayAvailableRooms();
                                            deluxe.hargaPerMalam();
                                            break;
                                        case 2:
                                            selectedRoom = standard;
                                            standard.displayRoomFacilities();
                                            standard.displayAvailableRooms();
                                            standard.hargaPerMalam();
                                            break;
                                        case 3:
                                            selectedRoom = suite;
                                            suite.displayRoomFacilities();
                                            suite.displayAvailableRooms();
                                            suite.hargaPerMalam();
                                            break;
                                        case 4:
                                            bookingCustomerRoom = false;
                                            break;
                                        default:
                                            System.out.println("Pilihan tidak valid.");
                                    }

                                    if (selectedRoom != null && selectedRoom.bookRoom()) {
                                        System.out.print("Masukkan nomor kamar: ");
                                        int roomNumber = scanner.nextInt();
                                        System.out.print("Masukkan nama Anda: ");
                                        String name = scanner.next();
                                        System.out.print("Masukkan alamat Anda: ");
                                        String address = scanner.next();
                                        System.out.print("Masukkan nomor telepon Anda: ");
                                        String phone = scanner.next();

                                        if (selectedRoom.reserve(roomNumber, name, address, phone)) {
                                            System.out.println("Pemesanan berhasil.");
                                        } else {
                                            System.out.println("Pemesanan gagal.");
                                        }
                                    } else if (roomTypeChoice != 4) {
                                        System.out.println("Pemesanan dibatalkan.");
                                    }
                                }
                                break;
                            case 2:
                                deluxe.displayAvailableRooms();
                                standard.displayAvailableRooms();
                                suite.displayAvailableRooms();
                                break;
                            case 3:
                                System.out.print("Masukkan nama Anda: ");
                                String customerName = scanner.next();
                                reservation.customerMenu(scanner, customerName);
                                break;
                            case 4:
                                System.out.print("Masukkan nomor kamar: ");
                                int roomToCancel = scanner.nextInt();
                                System.out.print("Masukkan nama Anda: ");
                                String cancelName = scanner.next();
                                System.out.print("Masukkan nomor telepon Anda: ");
                                String cancelPhone = scanner.next();

                                if (deluxe.cancel(roomToCancel, cancelName, cancelPhone) ||
                                    standard.cancel(roomToCancel, cancelName, cancelPhone) ||
                                    suite.cancel(roomToCancel, cancelName, cancelPhone)) {
                                    System.out.println("Pemesanan berhasil dibatalkan.");
                                } else {
                                    System.out.println("Pembatalan gagal.");
                                }
                                break;
                            case 5:
                            System.out.print("Masukkan nama Anda: ");
                            String customerNameDetail = scanner.next();
                            System.out.print("Masukkan nomor kamar Anda: ");
                            int roomNumberDetail = scanner.nextInt();
                            System.out.print("Masukkan nomor telepon Anda: ");
                            String phoneDetail = scanner.next();

                            boolean isBookingFound = deluxe.getRoomDetails(customerNameDetail, phoneDetail) ||
                             standard.getRoomDetails(customerNameDetail, phoneDetail) ||
                             suite.getRoomDetails(customerNameDetail, phoneDetail);

                            if (!isBookingFound) {
                            System.out.println("Tidak ditemukan pemesanan dengan nama, nomor kamar, dan nomor telepon tersebut.");
                            }
                            break;
                            case 6:
                                isCustomer = false;
                                customerMenu = false;
                                System.out.println("Beralih akun...");
                                break;
                            case 7:
                                running = false;
                                isCustomer = false;
                                customerMenu = false;
                                System.out.println("Terima kasih, Customer.");
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                        }
                    }
                }
            }
        }

        scanner.close();
    }
}
