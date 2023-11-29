import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ATMSystem atmSystem = new ATMSystem(bank);

        // Dummy data untuk pengujian
        Account account1 = new Account("123456", "1234", UserType.USER);
        account1.deposit(1000.0);
        Card card1 = new Card("1111222233334444", "12/25", "123");
        account1.setCard(card1);

        Account account2 = new Account("789012", "5678", UserType.ADMIN);
        account2.deposit(500.0);
        Card card2 = new Card("5555666677778888", "06/23", "456");
        account2.setCard(card2);

        bank.addAccount(account1);
        bank.addAccount(account2);

        ATM atm = new ATM(atmSystem);

        // Pilih akun yang akan digunakan
        System.out.println("Pilih akun:");
        System.out.println("1. Akun 1 (USER)");
        System.out.println("2. Akun 2 (ADMIN)");
        System.out.print("Masukkan pilihan Anda: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Uji coba penggunaan ATM untuk akun USER
                atm.insertCard(card1); // Contoh log masuk
                break;
            case 2:
                // Uji coba penggunaan ATM untuk akun ADMIN
                atm.insertCard(card2); // Contoh log masuk
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }

        // Tutup scanner setelah digunakan
        scanner.close();
    }
}
