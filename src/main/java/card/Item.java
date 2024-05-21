package card;

public class Item extends Card{
    private int harga;

    public Item(){
        super();
        this.harga = 0;
    }

    public Item(String nama, String imgpath, int harga){
        super(nama, imgpath,"item");
        this.harga = harga;
    }

    public Item(final Item other){
        this(other.getName(), other.getImgPath(), other.getHarga());
    }

    public int getHarga(){
        return this.harga;
    }
}
