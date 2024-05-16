package card;

import java.util.ArrayList;
import java.util.List;

public class Tanaman extends Card{
    private int durasiPanen;
    private List<Item> items;
    private int umur;

    public Tanaman(){
        super();
        this.durasiPanen = 0;
        this.items = new ArrayList<Item>();
        this.umur = 0;
    }
    public Tanaman(String nama, String imgpath, int durasiPanen, List<Item> items,int umur){
        super(nama, imgpath);
        this.durasiPanen = durasiPanen;
        this.items = new ArrayList<Item>(items);
        this.umur = umur;
    }
    public void addUmur(){
        this.umur++;
    }
    public int getUmur(){
        return this.umur;
    }
    public Tanaman(final Tanaman other) {
        this(other.getName(), other.getImgPath(), other.getdurasiPanen(), other.items,other.umur);
    }
    public int getdurasiPanen() {
        return durasiPanen;
    }
    public List<Item> getItems() {
        return items;
    }
    public void addItem(Item item) {
        this.items.add(item);
    }
    public void removeItem(Item item) {
        this.items.remove(item);
    }
    public void setdurasiPanen(int durasiPanen) {
        this.durasiPanen = durasiPanen;
    }
    public void adddurasiPanen(int addedDurasiPanen) {
        this.durasiPanen += addedDurasiPanen;
    }
}
