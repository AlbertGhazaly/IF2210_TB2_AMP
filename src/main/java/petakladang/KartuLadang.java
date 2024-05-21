package petakladang;
import card.*;
import java.util.*;

public class KartuLadang <T extends Card> {
    private T kartu;
    private List<Item>  items;
    KartuLadang(){
        this.kartu = null;
        this.items = null;
    }
    KartuLadang(final T kartu) {
        this.kartu = kartu;
        this.items = new ArrayList<>();
    }
    KartuLadang(final T kartu, List<Item> items) {
        if (kartu instanceof Hewan){
            Hewan temp = (Hewan) kartu;
            this.kartu = (T) new Hewan(temp);
        }else if (kartu instanceof Tanaman){
            Tanaman temp = (Tanaman) kartu;
            this.kartu = (T) new Tanaman(temp);
        }
        this.items = items;
    }
    public List<Item> getItems(){
        return this.items;
    }
    public KartuLadang<T> getInstance() {

        ArrayList<Item> copy = new ArrayList<>();
        for (Item item : this.items){
            copy.add(item.copy());
        }
        return  new KartuLadang<>(this.kartu,copy);
    }

}
