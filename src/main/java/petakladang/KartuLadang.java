package petakladang;
import card.*;
import java.util.*;

public class KartuLadang <T extends Card> {
    private Card kartu;
    private List< Item>  items;
    public KartuLadang(){
        this.kartu = null;
        this.items = null;
    }
    public KartuLadang(final T kartu) {
        this.kartu = kartu;
        this.items = new ArrayList<>();
    }
    public KartuLadang(final T kartu, List<Item> items) {
        if (kartu instanceof Hewan){
            Hewan temp = (Hewan) kartu;
            this.kartu =  new Hewan(temp);
        }else if (kartu instanceof Tanaman){
            Tanaman temp = (Tanaman) kartu;
            this.kartu =  new Tanaman(temp);
        }
        this.items = items;
    }
    public Item getElementItem(int idx){
        return items.get(idx);
    }
    public List<Item> getItems(){
        return (List<Item>) this.items;
    }
    public Item getItemElement(int idx){
        return this.items.get(idx);
    }
    public void addItems(Item addition){
        this.items.add(addition);
    }
    public Card getKartu(){
        return this.kartu;
    }

    public KartuLadang getInstance() {

        ArrayList<Item> copy = new ArrayList<>();
        for (Item item : this.items){
            copy.add(item.copy());
        }
        return new KartuLadang(this.kartu,copy);
    }

}
