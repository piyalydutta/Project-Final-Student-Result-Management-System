 public class Payment {
    public boolean processRecheckPayment(int studentId, double amount) {
        System.out.println("Processing payment of $" + amount + " for Student ID: " + studentId);
        System.out.println("Payment successful.");
        return true;
    }
}
