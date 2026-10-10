import java.util.Scanner;


public class Aims {
    
    private static Cart customerCart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    
    private static int orderCount = 0;

     
    public static void main(String[] args) {
        DigitalVideoDisc DVD1 = new DigitalVideoDisc("Avatar", "Action", "James Cameron", 162, 50000);
        DigitalVideoDisc DVD2 = new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 60000);
        DigitalVideoDisc DVD3 = new DigitalVideoDisc("Tom and Jerry", "Animation", "William Hanna", 90, 20000);
        
        customerCart.addDigitalVideoDisc(DVD1);
        customerCart.addDigitalVideoDisc(DVD2);
        customerCart.addDigitalVideoDisc(DVD3);

        System.err.println("Tong tien can tra: " + customerCart.totalCost() + " VND.");
        System.err.println("\nTruoc khi xoa!");
        customerCart.printCart();

        customerCart.removeDigitalVideoDisc(DVD1);
        System.err.println("\nSau khi xoa!");
        customerCart.printCart();

    }
        
        
}