package card;

public class Produk extends Card{
    private int addedBerat;
    private int harga;
    public Produk() {
        super();
        this.addedBerat = 0;
        this.harga = 0;
    }
    public Produk(String name, String imgpath, int harga, int addedBerat) {
        super(name, imgpath, "produk");
        this.addedBerat = addedBerat;
        this.harga = harga;
    }
    public Produk(final Produk other) {
        this(other.getName(), other.getImgPath(), other.getHarga(), other.getAddedBerat());
    }
    public int getHarga(){return this.harga;}
    public int getAddedBerat(){
        return this.addedBerat;
    }
}
