public class DigitalVideoDisc {
    private String title;
    private double cost;
    private String category;
    private String director;
    private int length;
    
    public DigitalVideoDisc(){
        this.title = "";
        this.cost = 0;
        this.category = "";
        this.director = "";
        this.length = 0;
    }

    public DigitalVideoDisc(String title){
        this.title = title;
    }
    
    public DigitalVideoDisc(String title, String category, double cost){
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    public DigitalVideoDisc(String director, String title, String category, double cost){
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.director = director;

    }
    public DigitalVideoDisc(String title,  String category, String director, int length, double cost){
        this.title = title;
        this.cost = cost;
        this.category = category;
        this.director = director;
        this.length = length;
    }
    
    public String getTitle(){
        return this.title;
    }

    public double getCost(){
        return this.cost;
    }

    public String getCategory(){
        return this.category;
    }

    public String getDirector(){
        return this.director;
    }

    public int getLength(){
        return this.length;
    }

    public void Play(){
        if (this.length > 0) {
            System.out.println("Dang phat DVD!!");
        } else {
            System.out.println("Khong the phat DVD!!");
        }
    }
}
