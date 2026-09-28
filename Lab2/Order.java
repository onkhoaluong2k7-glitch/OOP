public class Order {
    private Cart cart;
    private float finalTotal;
    private String status; // Initialized / pending, approved, rejected

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
    
}
