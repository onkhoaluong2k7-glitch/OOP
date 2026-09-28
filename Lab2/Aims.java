import java.util.Scanner;
public class Aims {
  
    
    public static float calculateDeliveryFee(String address, float totalWeight){
        float baseCost = 0;
        if (address.toLowerCase().contains("Hanoi")){
            baseCost = 15000f;
        } else{
            baseCost = 35000f;
        }

        return baseCost + totalWeight*5000;
    }

    public static void placeOrder(Cart current){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n----- THONG TIN GIAO HANG -----\n");
        System.out.print("Nhap dia chi giao hang: ");
        String address =  scanner.nextLine();

        System.out.print("Nhap ghi chu giao hang (neu co): ");
        String instructions = scanner.nextLine();

        float totalWeight = current.getQtyOrdered() * 0.2f;
        
        float deliveryFee = calculateDeliveryFee(address, totalWeight);
        float subTotal = current.totalCost(); // Tổng trước VAT
        float vat = subTotal * 0.10f;             // Tính VAT 10%
        float finalTotal = subTotal + vat + deliveryFee;
        
        System.out.println("\n================ HÓA ĐƠN ================");
        System.out.println("Địa chỉ nhận: " + address);
        System.out.println("Ghi chú:      " + instructions);
        System.out.println("-----------------------------------------");
        System.out.println("Tạm tính (trước VAT):   " + subTotal + " VNĐ");
        System.out.println("Thuế VAT (10%):         " + vat + " VNĐ");
        System.out.println("Phí giao hàng:          " + deliveryFee + " VNĐ");
        System.out.println("-----------------------------------------");
        System.out.println("TỔNG THANH TOÁN:        " + finalTotal + " VNĐ");
        System.out.println("=========================================");
        
        scanner.close();
    }

    public static void main(String[] args) {
        // Khởi tạo giỏ hàng và chạy thử luồng đặt hàng
        Cart myCart = new Cart();
        myCart.addDigitalVideoDisc(new DigitalVideoDisc("Avatar", "Action", "James Cameron", 162, 50000f));
        myCart.addDigitalVideoDisc(new DigitalVideoDisc("Iron Man", "Action", "Jon Favreau", 126, 45000f));
        
        // Chạy luồng thanh toán
        placeOrder(myCart);
    }
}