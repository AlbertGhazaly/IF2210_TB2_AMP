package card;

public class Tanaman extends Card{
    private int durasiPanen;
    private int umur;

    public Tanaman(){
        super();
        this.durasiPanen = 0;
        this.umur = 0;
    }
    public Tanaman(String nama, String imgpath, int durasiPanen,int umur){
        super(nama, imgpath);
        this.durasiPanen = durasiPanen;
        this.umur = umur;
    }
    public void addUmur(int addedUmur){
        this.umur+= addedUmur;
    }
    public int getUmur(){
        return this.umur;
    }
    public Tanaman(final Tanaman other) {
        this(other.getName(), other.getImgPath(), other.getdurasiPanen(),other.getUmur());
    }
    public int getdurasiPanen(){return this.durasiPanen;}
    public void setdurasiPanen(int durasiPanen) {
        this.durasiPanen = durasiPanen;
    }
}