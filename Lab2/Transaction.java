import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Transaction {
    private String transactionId;
    private String cardOwner;
    private double amount;     // Đổi sang double để khớp với tiền trong thẻ
    private String message;
    private double balance;    // Đổi sang double
    private String transactionDate;

    // Đã bỏ tham số transactionDate ở cuối
    public Transaction(String cardOwner, double amount, String message, double balance) {
        this.transactionId = UUID.randomUUID().toString();
        this.cardOwner = cardOwner;
        this.amount = amount;
        this.message = message;
        this.balance = balance;

        // Tự động chốt thời gian ngay khoảnh khắc giao dịch diễn ra
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