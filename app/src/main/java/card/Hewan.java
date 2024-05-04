package card;

public class Hewan extends Card{
    private String kategori;
    private int berat;
    private int beratPanen;

    public Hewan(){
        super();
        this.kategori = "";
        this.berat = 0;
        this.beratPanen = 0;
    }

    public Hewan(String nama, String imgPath,String kategori, int berat, int beratPanen){
        super(nama,imgPath);
        this.kategori = kategori;
        this.berat = berat;
        this.beratPanen = beratPanen;
    }

    public Hewan(final Hewan other){
        this(other.getName(),
            other.getImgPath(),
            other.getKategori(),
            other.getBerat(),
            other.getBeratPanen()
        );
    }
    public String getKategori(){
        return this.kategori;
    }
    public int getBerat(){
        return this.berat;
    }
    public int getBeratPanen(){
        return this.beratPanen;
    }
    public void addBerat(int addedBerat){
        this.berat += addedBerat;
    }
}
