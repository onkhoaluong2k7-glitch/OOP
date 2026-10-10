import java.util.Scanner;


public class Aims {
    // Dữ liệu dùng chung cho toàn hệ thống
    private static Store store = new Store();
    private static Cart customerCart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    
    // Mảng lưu trữ các đơn hàng chờ duyệt (Trong thực tế nên dùng ArrayList)
    private static Order[] pendingOrders = new Order[100];
    private static int orderCount = 0;

    private static void customerFlow() {
        int choice;
        do {
            System.out.println("\n--- GIAO DIEN KHACH HANG ---");
            // Hiển thị danh sách DVD từ mới nhất đến cũ nhất
            System.out.println("Danh sach san pham moi nhat:");
            store.printStoreReversed(); // Bạn cần viết hàm này trong class Store, duyệt mảng từ cuối lên đầu
            
            System.out.println("\n1. Them DVD vao gio hang");
            System.out.println("2. Xem gio hang va thanh toan");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Chon chuc nang: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap ten DVD ban muon mua: ");
                    String title = scanner.nextLine();
                    // Giả lập tìm đĩa trong kho và thêm vào giỏ
                    DigitalVideoDisc foundDisc = store.searchByTitle(title);
                    if (foundDisc != null) {
                        customerCart.addDigitalVideoDisc(foundDisc);
                    } else {
                        System.out.println("Khong tim thay dia!");
                    }
                    break;
                case 2:
                    // Thực thi luồng thanh toán CreditCard mà chúng ta đã xây dựng ở các bước trước
                    System.out.println("Dang chuyen toi cong thanh toan...");
                    // Giả lập tạo Order thành công và đẩy vào danh sách chờ duyệt của Manager
                    // pendingOrders[orderCount] = newOrder;
                    // orderCount++;
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
    }

    private static void managerLoginFlow() {
        System.out.print("Nhập mật khẩu quản trị: ");
        String password = scanner.nextLine();
        
        // Cài đặt mật khẩu mặc định là "admin123"
        if (!password.equals("admin123")) {
            System.out.println("Sai mat khau! Vui long nhap lai.");
            return;
        }

        int choice;
        do {
            System.out.println("\n--- BANG DIEU KHIEN MANAGER ---");
            System.out.println("1. Xem va duyet don hang (Pending Orders)");
            System.out.println("2. Nhap them DVD vao kho");
            System.out.println("3. Xoa DVD khoi kho");
            System.out.println("0. Đang xuat");
            System.out.print("Chon chuc nang: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    approveOrdersFlow();
                    break;
                case 2:
                    // Thực thi code yêu cầu nhập title, category, price... rồi gọi store.addDVD()
                    System.out.println("Dang mo giao dien nhap DVD...");
                    break;
                case 3:
                    // Thực thi code yêu cầu nhập tên DVD rồi gọi store.removeDVD()
                    System.out.println("Dang mo giao dien xoa DVD...");
                    break;
                case 0:
                    System.out.println("Đa dang xuat tai khoan Manager.");
                    break;
            }
        } while (choice != 0);
    }

    // Logic duyệt đơn hàng
    private static void approveOrdersFlow() {
        System.out.println("\n-- DANH SACH DON CHO DUYET --");
        if (orderCount == 0) {
            System.out.println("Khong co don hang nao can xa ly.");
            return;
        }
        
        for (int i = 0; i < orderCount; i++) {
            if (pendingOrders[i].getStatus().equals("PENDING")) {
                System.out.println("Don hang #" + i + " | Trang thai: PENDING");
                System.out.print("Ban muon (1) Duyet - Approve hay (2) Tu choi - Reject? (Nhap so khac đe bo qua): ");
                int action = scanner.nextInt();
                
                if (action == 1) {
                    pendingOrders[i].setStatus("APPROVED");
                    System.out.println("Da duyet don hang #" + i);
                } else if (action == 2) {
                    pendingOrders[i].setStatus("REJECTED");
                    System.out.println("Da tu choi don hang #" + i);
                }
            }
        }
    }
    public static void main(String[] args) {
        // Nạp sẵn một vài đĩa DVD vào kho để test
        // 1. Thêm sẵn đĩa vào kho
        store.addDVD(new DigitalVideoDisc("Avatar", "Action", "James Cameron", 162, 50000));
        store.addDVD(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 60000));
        store.addDVD(new DigitalVideoDisc("Tom and Jerry", "Animation", "William Hanna", 90, 20000));

        // 2. Khởi tạo sẵn một thẻ tín dụng của khách để test thanh toán
        CreditCard testCard = new CreditCard("1234567812345678", "ON KHOA LUONG", 500000);
        
        
        
        int roleChoice;
        do {
            System.out.println("\n=== HE THONG CUA HAM AIMS ===");
            System.out.println("1. Dang nhap Quan Ly (Manager)");
            System.out.println("2. Mua sam (Customer) ");
            System.out.println("0. Thoat he thong");
            System.out.print("Vui long lua chon vai tro (0-2): ");
            roleChoice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm phím Enter

            switch (roleChoice) {
                case 1:
                    managerLoginFlow();
                    break;
                case 2:
                    customerFlow();
                    break;
                case 0:
                    System.out.println("Hệ thống đã đóng. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (roleChoice != 0);
    }
}