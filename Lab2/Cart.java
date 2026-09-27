
public class Cart {
    private static final int MAX_CAP = 20; 
    private int qtyOrdered;
    private DigitalVideoDisc[] itemsCap = new DigitalVideoDisc[MAX_CAP];
    
    public Cart(){
        this.qtyOrdered = 0;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered < MAX_CAP){
            itemsCap[qtyOrdered] = disc;
            qtyOrdered += 1;
            System.out.println("Them dia vao gio hang thanh cong!!");
        } else {
            System.out.println("Them gio hang that bai!!");
        }

    }

    public void cmpTitle(){
        for (int i = 0; i < qtyOrdered; i++){
            for (int j = i+1; j < qtyOrdered; j++){
                if (itemsCap[i].getTitle().compareToIgnoreCase(itemsCap[j].getTitle()) > 0){
                    DigitalVideoDisc tmp;
                    tmp = itemsCap[i];
                    itemsCap[i] = itemsCap[j];
                    itemsCap[j] = tmp;
                }
            }
        }
    }

    public void cmpCost(){
        for (int i = 0; i < qtyOrdered; i++){
            for (int j = i+1; j < qtyOrdered; j++){
                if (itemsCap[i].getCost() > itemsCap[j].getCost()){
                    DigitalVideoDisc tmp;
                    tmp = itemsCap[i];
                    itemsCap[i] = itemsCap[j];
                    itemsCap[j] = tmp;
                }
            }
        }
    }

    public void remove(DigitalVideoDisc disc){
        int idx = -1;
        for (int i = 0 ; i < qtyOrdered; i++){
            if (itemsCap[i].getTitle().equals(disc.getTitle())){
                idx = i;
                break;
            }
        }

        if (idx != -1){
            for (int i = idx; i < qtyOrdered - 1; i++){
                itemsCap[i] = itemsCap[i+1];
            }
            qtyOrdered -= 1;
            System.out.println("Xoa thanh cong!!!");
        } else {
            System.out.println("Xoa khong thanh cong: Khong ton tai dia!!");
        }

    }
}
