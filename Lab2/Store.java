public class Store {
    public static final int MAX_ITEMS_IN_STORE = 1000;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore;

    public Store(){
        this.qtyInStore = 0;
    }

    public void addDVD(DigitalVideoDisc disc){
        if (qtyInStore < MAX_ITEMS_IN_STORE){
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("Them thanh cong DVD vao kho!!");
        } else {
            System.out.println("Kho da day, khong the them vao kho!!");
        }
    }
}
