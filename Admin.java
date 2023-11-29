// Class untuk merepresentasikan admin
public class Admin {
    private ATMSystem atmSystem;

    public Admin(ATMSystem atmSystem) {
        this.atmSystem = atmSystem;
    }

    public void showAllCustomerInfo() {
        atmSystem.showAllCustomerInfo();
    }
}
