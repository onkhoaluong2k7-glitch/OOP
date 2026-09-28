1. Khởi tạo cấu trúc dữ liệu nền tảng (Theo sơ đồ UML):
Dựa vào sơ đồ cấu trúc trong file image_4d4534.png, 
bước đầu tiên là bạn cần tạo bộ khung các Class cơ bản nhất bằng Java:   

- Tạo class DigitalVideoDisc: 
    + Khai báo đầy đủ các thuộc tính như title (tiêu đề), category (thể loại), director (đạo diễn), 
    length (thời lượng) và cost (giá tiền). 
    Đừng quên tạo hàm khởi tạo DigitalVideoDisc() và các hàm getter (như getTitle()).   

- Tạo class Cart (Giỏ hàng): Lớp này sẽ chứa thuộc tính qtyOrdered để đếm số lượng đĩa đã đặt và 
  phương thức addDigitalVideoDisc() để thêm đĩa vào giỏ.   

- Tạo class Aims: Đây là lớp chứa hàm main() để chạy thử nghiệm các tính năng của chương trình.   

-----------------------------------------------------------------------------------------------------------------------------------

2. Xây dựng logic Tìm kiếm và Quản lý Giỏ hàng
Sau khi có khung cơ bản, bạn bắt đầu viết các phương thức xử lý logic phức tạp hơn cho người dùng:   

- Tính năng tìm kiếm: 
    + Viết các hàm cho phép lọc danh sách DVD theo 3 tiêu chí: 
    từ khóa trong tiêu đề (không phân biệt hoa thường), theo thể loại, hoặc theo khoảng giá/giá tối đa.   

- Tính năng xem thử (Play): Viết hàm kiểm tra nếu length > 0 thì cho phép "phát" (in ra màn hình thông báo đang phát), ngược lại phải báo lỗi không thể phát.   

- Nâng cấp Giỏ hàng (Cart): Bổ sung hàm sắp xếp danh sách đĩa trong giỏ (theo bảng chữ cái tiêu đề rồi đến giá giảm dần, hoặc ngược lại). 
Thêm tính năng cập nhật số lượng, xóa đĩa, và đặc biệt là hàm tự động chọn ngẫu nhiên một sản phẩm trong giỏ để miễn phí cho khách hàng.   

1. Trong class DigitalVideoDisc (Quản lý bản thân chiếc đĩa)

Tính năng xem thử: Một chiếc đĩa sẽ tự biết cách "phát" chính nó. Bạn hãy viết phương thức public void play() ngay tại class này.

Cách làm: Dùng câu lệnh if (this.length > 0) để System.out.println thông báo "Đang phát DVD: " + tiêu đề. Ngược lại, in ra lỗi "DVD này không thể phát".

2. Trong class Cart (Quản lý giỏ hàng cá nhân)
Toàn bộ các thao tác làm thay đổi mảng itemsOrdered mà bạn vừa tạo sẽ nằm ở đây:

Xóa đĩa: public void removeDigitalVideoDisc(DigitalVideoDisc disc)

Cách làm: Dùng vòng lặp quét qua mảng. Nếu tìm thấy đĩa trùng khớp, hãy xóa nó, dồn các phần tử phía sau lên trước để lấp chỗ trống, và nhớ trừ biến qtyOrdered đi 1.

Sắp xếp giỏ hàng: Viết 2 hàm public void sortByTitle() và public void sortByCost().

Cách làm: Bạn có thể dùng các thuật toán sắp xếp cơ bản (như Bubble Sort) để đảo vị trí các đối tượng DigitalVideoDisc bên trong mảng itemsOrdered.

Tặng đĩa ngẫu nhiên (Lucky Item): public DigitalVideoDisc getALuckyItem()

Cách làm: Dùng thư viện Math.random() để sinh ra một số nguyên ngẫu nhiên từ 0 đến qtyOrdered - 1. Lấy chiếc đĩa ở vị trí đó ra và coi như đồ tặng (ví dụ: in thông báo tặng và không cộng giá tiền đĩa này vào hàm tính tổng tiền).

3. Trong class Store (Class mới cần tạo - Quản lý kho hàng)
Theo yêu cầu hệ thống, khách hàng phải tìm kiếm DVD trong cửa hàng để thêm vào giỏ. Do đó, bạn cần tạo thêm một class tên 
là Store đóng vai trò là "Nhà kho".

Cấu trúc: Tương tự Cart, class Store cũng sẽ có một mảng (ví dụ: itemsInStore) chứa hàng chục đĩa DVD đang có sẵn để bán.

Tính năng tìm kiếm: Bạn sẽ viết các hàm lọc dữ liệu tại đây:

public void searchByTitle(String keyword)

public void searchByCategory(String category)

public void searchByPrice(float maxCost)

Cách làm: Quét qua mảng itemsInStore, dùng các hàm xử lý chuỗi có sẵn của Java như toLowerCase() và contains() để kiểm tra xem từ khóa
có nằm trong tên hoặc thể loại của đĩa hay không, nếu có thì in thông tin đĩa đó ra.

-----------------------------------------------------------------------------------------------------------------------------------

3. Xử lý Luồng Đặt hàng & Thanh toán

- Đây là giai đoạn mô phỏng lại luồng mua hàng thực tế trên các sàn thương mại điện tử:
Thu thập thông tin: 
    + Viết logic yêu cầu nhập địa chỉ và tính toán phí giao hàng dựa trên khối lượng và vị trí.   
    + Tính tiền & Hóa đơn: Tính tổng tiền trước VAT, sau VAT và cộng thêm phí giao hàng để in ra hóa đơn chi tiết.   

- Mô phỏng Thanh toán: 
    + Khởi tạo tính năng thanh toán bằng thẻ tín dụng (kiểm tra tính hợp lệ) và trả về các thông tin giao dịch (Mã giao dịch, số dư, ngày tháng). 
    Sau đó, chuyển trạng thái đơn hàng sang "Chờ xử lý" (pending).  

-----------------------------------------------------------------------------------------------------------------------------------


4.    Phân quyền Hệ thống (Customer vs Manager)Cuối cùng, bạn cần tách biệt giao diện/chức năng cho hai nhóm người dùng:   

- Người quản lý (Manager): Cần có luồng đăng nhập riêng. Họ có quyền xem danh sách đơn hàng đang chờ xử lý để duyệt (approve) hoặc từ chối (reject). 
Ngoài ra, họ có quyền thêm các đĩa DVD mới (nhập đủ thông tin ID, tiêu đề, đạo diễn...) hoặc xóa đĩa khỏi hệ thống.   

- Khách hàng (Customer): Mặc định khi vào hệ thống sẽ thấy danh sách DVD sắp xếp từ mới nhất đến cũ nhất. Có thể mua hàng mà không cần đăng nhập.  