package card;

public class Produk extends Card{
    private int addedBerat;
    private int harga;
    private String orisinil;
    public Produk() {
        super();
        this.addedBerat = 0;
        this.harga = 0;
    }
    public Produk(String name, String imgpath, int harga, int addedBerat, String orisinil) {
        super(name, imgpath);
        this.addedBerat = addedBerat;
        this.harga = harga;
        this.orisinil = orisinil;
    }
    public Produk(final Produk other) {
        this(other.getName(), other.getImgPath(), other.getHarga(), other.getAddedBerat(),other.getOrisinil());
    }
    public int getHarga(){return this.harga;}
    public int getAddedBerat(){
        return this.addedBerat;
    }
    public String getOrisinil(){return this.orisinil;}
}
