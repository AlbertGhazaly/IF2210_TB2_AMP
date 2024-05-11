package card;

import java.util.ArrayList;
import java.util.List;

public class Hewan extends Card{
    private int m;
    private int n;
    private String kategori;
    private int berat;
    private int beratPanen;
    private List<Item> items;

    public Hewan(){
        super();
        this.kategori = "";
        this.berat = 0;
        this.beratPanen = 0;
        this.items = new ArrayList<Item>();
    }
    public Hewan(int m, int n, String nama, String imgPath,String kategori, int berat, int beratPanen, List<Item> items){
        super(nama,imgPath);
        this.m = m;
        this.n = n;
        this.kategori = kategori;
        this.berat = berat;
        this.beratPanen = beratPanen;
        this.items = new ArrayList<Item>(items);
    }

    public Hewan(final Hewan other){
        this(other.getM(),other.getN(),other.getName(),
            other.getImgPath(),
            other.getKategori(),
            other.getBerat(),
            other.getBeratPanen()
            ,other.items);
        ;
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
    public void addBeratPanen(int addedBeratPanen){
        this.beratPanen += addedBeratPanen;
    }
    public List<Item> getItems(){
        return this.items;
    }
    public void addItem(Item item){
        this.items.add(item);
    }
    public void removeItem(Item item){
        this.items.remove(item);
    }
    public void setKategori(String kategori){
        this.kategori = kategori;
    }
    public void setBerat(int berat){
        this.berat = berat;
    }
    public void setBeratPanen(int beratPanen){
        this.beratPanen = beratPanen;
    }
    public void setItems(List<Item> items){
        this.items = items;
    }
    public void setM(int m){
        this.m = m;
    }
    public void setN(int n){
        this.n = n;
    }
    public int getM(){
        return this.m;
    }
    public int getN(){
        return this.n;
    }
}
