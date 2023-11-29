import java.util.Scanner;

public class ATM {
    private ATMSystem atmSystem;
    private Scanner scanner;

    public ATM(ATMSystem atmSystem) {
        this.atmSystem = atmSystem;
        this.scanner = new Scanner(System.in);
    }

    public void insertCard(Card card) {
        atmSystem.insertCard(card);
    }

    public void ejectCard() {
        atmSystem.ejectCard();
    }

    public void startSession(String pin) {
        atmSystem.startSession(pin);
    }

    public void showMainMenu() {
        atmSystem.showMainMenu();
    }

    public void closeScanner() {
        scanner.close();
    }
}
