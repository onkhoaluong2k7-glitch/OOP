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
    
    public void printStoreReversed(){
        for (int i = 0; i < qtyInStore; i++){
            System.out.println(i+". "+itemsInStore[i].getTitle());
        }
    }

    public DigitalVideoDisc searchByTitle (String title){
        for (int i  = 0; i < qtyInStore; i++){
            if (title.equals(itemsInStore[i].getTitle())){
                return itemsInStore[i];
            }
        }
        return null;
    }
}
