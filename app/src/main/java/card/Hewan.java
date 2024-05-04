package card;

public class Hewan extends Card{
    private String kategori;
    private int berat;
    private int beratPanen;

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
