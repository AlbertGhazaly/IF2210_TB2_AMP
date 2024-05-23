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
            this.kartu =  (Hewan) kartu;
        }else if (kartu instanceof Tanaman){
            this.kartu =  (Tanaman) kartu;
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
        if (this.kartu instanceof Hewan){
            Hewan temp = (Hewan) this.kartu;
            return new KartuLadang((Hewan)temp,copy);

        }else{
            Tanaman temp = (Tanaman) this.kartu;
            return new KartuLadang((Tanaman)temp,copy);

        }

    }

}
