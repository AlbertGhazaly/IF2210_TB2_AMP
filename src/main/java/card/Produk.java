package card;

public class Produk extends Item{
    private int addedBerat;

    public Produk() {
        super();
        this.addedBerat = 0;
    }
    public Produk(String name, String imgpath, int Harga, int addedBerat) {
        super(name, imgpath, Harga);
        this.addedBerat = addedBerat;
    }
    public Produk(final Produk other) {
        this(other.getName(), other.getImgPath(), other.getHarga(), other.getAddedBerat());
    }

    public int getAddedBerat(){
        return this.addedBerat;
    }
}
