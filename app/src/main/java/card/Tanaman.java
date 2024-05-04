package card;

public class Tanaman extends Card{
    private int durasiPanen;

    public Tanaman(){
        super();
        this.durasiPanen = 0;
    }
    public Tanaman(String nama, String imgpath, int durasiPanen) {
        super(nama, imgpath);
        this.durasiPanen = durasiPanen;
    }
    public Tanaman(final Tanaman other) {
        this(other.getName(), other.getImgPath(), other.getdurasiPanen());
    }
    public int getdurasiPanen() {
        return durasiPanen;
    }
}
