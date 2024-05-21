package card;


public abstract class Card {

    private String name;
    private String imgPath;
    private String position;
    public static String convertPositionToString(int row, int col){
        String temp = "";
        temp += String.valueOf('A' + col);
        temp += "0";
        temp += String.valueOf(row + 1);
        return temp;
    }
    public static int convertStringtoCol(String pos){
        return (int) (pos.charAt(0)-'A');
    }
    public static int convertStringtoRow(String pos){
        return (int) (pos.charAt(2)-'1');
    }
    public Card(){
        this.name = null;
        this.imgPath = null;
        this.position = null;
    }
    public Card(String name, String imgPath){
        this.name = name;
        this.imgPath = imgPath;
        this.position = null;
    }
    public Card(String name, String imgPath, String position){
        this.name = name;
        this.imgPath = imgPath;
        this.position = null;
        this.position = position;
    }
    public Card(final Card other){
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
