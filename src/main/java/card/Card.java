package card;


public abstract class Card {
    private String name;
    private String imgPath;

    public Card(){
        this.name = "";
        this.imgPath = "";
    }
    public Card(String name, String imgPath){
        this.name = name;
        this.imgPath = imgPath;
    }
    public String getName(){
        return this.name;
    }
    public String getImgPath(){
        return this.imgPath;
    }
} 
