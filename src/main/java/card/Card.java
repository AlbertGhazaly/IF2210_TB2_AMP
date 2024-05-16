package card;


public abstract class Card {

    private String name;
    private String imgPath;
    private String position;
    public static String convertPositionToString(int row, int col){
        String temp = "";
        temp += String.valueOf('A' + row);
        temp += " ";
        temp += String.valueOf(col);
        return temp;
    }
    public Card(){
        this.name = "";
        this.imgPath = "";
        this.position = null;
    }
    public Card(String name, String imgPath){
        this.name = name;
        this.imgPath = imgPath;
        this.position = null;
    }
    public Card(Card other){
        this.name = other.getName();
        this.imgPath = other.getImgPath();
        this.position = other.getPosition();
    }
    public void setPosition(int row, int col){
        this.position = convertPositionToString(row,col);
    }
    public String getName(){
        return this.name;
    }
    public String getImgPath(){
        return this.imgPath;
    }
    public String getPosition(){
        return this.position;
    }
} 
