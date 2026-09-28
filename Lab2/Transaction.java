import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


public class Transaction {
    private String transactionId;
    private String cardOwner;
    private float amount;
    private String message;
    private float balance;
    private String transactionDate;

    public Transaction(String cardOwner, float amount, String message, float balance, String transactionDate) {
        this.transactionId = UUID.randomUUID().toString();
        this.cardOwner = cardOwner;
        this.amount = amount;
        this.message = message;
        this.balance = balance;
        this.transactionDate = transactionDate;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.transactionDate = dtf.format(LocalDateTime.now());

    }

    public void printReceipt() {
        System.out.println("\n--- BIÊN LAI GIAO DỊCH ---");
        System.out.println("Mã GD:       " + this.transactionId);
        System.out.println("Chủ thẻ:     " + this.cardOwner.toUpperCase());
        System.out.println("Số tiền:     " + this.amount + " VNĐ");
        System.out.println("Trạng thái:  " + this.message);
        System.out.println("Số dư ví:    " + this.balance + " VNĐ");
        System.out.println("Thời gian:   " + this.transactionDate);
        System.out.println("--------------------------");
    }
}
