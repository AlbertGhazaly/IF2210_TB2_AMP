package card;

public class Item extends Card{

    public Item(){
        super();
    }

    public Item(String nama, String imgpath){
        super(nama, imgpath);
    }

    public Item(final Item other){
        this(other.getName(), other.getImgPath());
    }


    public Item copy(){
        return new Item(this);
    }
}
