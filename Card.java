public class Card {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public Card(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public boolean validateCard(String enteredCvv) {
        return cvv.equals(enteredCvv);
    }
}
