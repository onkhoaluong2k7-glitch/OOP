public class CreditCard {
    private String cardNumber;
    private String cardOwner; // Bổ sung thuộc tính tên chủ thẻ
    private double balance;

    // Yêu cầu truyền thêm cardOwner vào hàm khởi tạo
    public CreditCard(String cardNumber, String cardOwner, double initialBalance) {
        this.cardNumber = cardNumber;
        this.cardOwner = cardOwner;
        this.balance = initialBalance;
    }

    // Kiểm tra tính hợp lệ: Thẻ phải có đúng 16 chữ số
    private boolean isValid() {
        return cardNumber != null && cardNumber.matches("\\d{16}");
    }

    public Transaction pay(double amount) {
        if (!isValid()) {
            System.out.println("LỖI: Số thẻ không hợp lệ!");
            return null;
        }
        if (balance < amount) {
            System.out.println("LỖI: Số dư trong thẻ không đủ!");
            return null;
        }
        
        this.balance -= amount;
        
        // Lúc này this.cardOwner đã tồn tại và hợp lệ
        return new Transaction(this.cardOwner, amount, "Thanh toán thành công", this.balance);
    }
}