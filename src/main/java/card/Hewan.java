package card;

public class Hewan extends Card {
    private String kategori;
    private int beratPanen;


    public Hewan() {
        super();
        this.kategori = "";
        this.beratPanen = 0;
    }

    public Hewan(String nama, String imgPath, String kategori, int beratPanen) {
        super(nama, imgPath);
        this.kategori = kategori;
        this.beratPanen = beratPanen;
    }

    public Hewan(final Hewan other) {
        this(other.getName(), other.getImgPath(), other.getKategori(), other.getBeratPanen());
    }

    public String getKategori() {
        return this.kategori;
    }

    public int getBeratPanen() {
        return this.beratPanen;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setBeratPanen(int beratPanen) {
        this.beratPanen = beratPanen;
    }
}