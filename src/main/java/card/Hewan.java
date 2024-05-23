package card;

import java.util.ArrayList;
import java.util.List;

public class Hewan extends Card{
    private String kategori;
    private int beratPanen;
    private int berat;
    public Hewan() {
        super();
        this.kategori = null;
        this.berat = 0;
        this.beratPanen = 0;
    }
    public Hewan(String nama, String imgPath,String kategori, int berat, int beratPanen){
        super(nama,imgPath);
        this.kategori = kategori;
        this.beratPanen = beratPanen;
    }

    public Hewan(final Hewan other){
        this(other.getName(),
            other.getImgPath(),
            other.getKategori(),
            other.getBerat(),
            other.getBeratPanen()
        );
        ;
    }

    public String getKategori() {
        return this.kategori;
    }
    public int getBerat(){return this.berat;}
    public int getBeratPanen() {
        return this.beratPanen;
    }
    public void addBerat(int addedBerat){
        this.berat += addedBerat;
    }
    public void setBerat(int berat){
        this.berat = berat;
    }
    public void addBeratPanen(int addedBeratPanen){
        this.beratPanen += addedBeratPanen;
    }
    public void setKategori(String kategori){
        this.kategori = kategori;
    }

    public void setBeratPanen(int beratPanen) {
        this.beratPanen = beratPanen;
    }
}
