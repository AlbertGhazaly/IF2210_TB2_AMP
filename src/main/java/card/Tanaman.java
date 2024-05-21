package card;

public class Tanaman extends Card{
    private int umurPanen;


    public Tanaman(){
        super();
        this.umurPanen = 0;
    }
    public Tanaman(String nama, String imgpath, int umurPanen){
        super(nama, imgpath);
        setdurasiPanen(umurPanen);
    }
    public Tanaman(final Tanaman other) {
        this(other.getName(), other.getImgPath(), other.getUmurPanen());
    }
    public int getUmurPanen() {
        return umurPanen;
    }

    public void setdurasiPanen(int umurPanen) {
        this.umurPanen = umurPanen;
    }
}