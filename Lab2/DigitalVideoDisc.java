public class DigitalVideoDisc {
    private String title;
    private float cost;
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

    public DigitalVideoDisc(String title,  String category, String director, int length, float cost){
        this.title = title;
        this.cost = cost;
        this.category = category;
        this.director = director;
        this.length = length;
    }
    
    public String getTitle(){
        return this.title;
    }


    public float getCost(){
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
