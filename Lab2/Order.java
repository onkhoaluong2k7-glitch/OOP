public class Order {
    private Cart cart;
    private float finalTotal;
    private String status; // INITIALIZED, PENDING, APPROVED, REJECTED

    public Order(Cart cart, float finalTotal){
        this.cart = cart;
        this.finalTotal = finalTotal;
        this.status ="INITIALIZED";
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus (){
        return this.status;
    }
    
    // Bổ sung luồng thanh toán tích hợp thẻ tín dụng
    public void processCheckout(CreditCard card) {
        System.out.println("Đang kết nối cổng thanh toán thẻ tín dụng...");
        
        // Gọi hàm trừ tiền từ đối tượng thẻ và nhận về biên lai (Transaction)
        Transaction receipt = card.pay(this.finalTotal);
        
        if (receipt != null) {
            // Đổi trạng thái sang Chờ xử lý nếu thẻ hợp lệ và đủ tiền
            this.status = "PENDING";
            System.out.println("=> Thanh toán thành công! Trạng thái đơn hàng: " + this.status);
            receipt.printReceipt();
        } else {
            // Thanh toán lỗi (sai số thẻ, thiếu tiền)
            this.status = "REJECTED"; 
            System.out.println("=> Thanh toán thất bại. Đơn hàng đã bị hủy.");
        }
    }
}