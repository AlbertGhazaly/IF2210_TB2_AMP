package deck;

import card.*;

import java.util.ArrayList;
import java.util.List;

public class KartuLadang extends Card {
    private int beratUmur;
    private List<String> items;

    // Konstruktor tanpa parameter yang memanggil super dengan parameter default
    public KartuLadang() {
        super();
        this.beratUmur = 0;
        this.items = new ArrayList<String>();
    }

    // Getter untuk beratUmur
    public int getBeratUmur() {
        return beratUmur;
    }

    // Setter untuk beratUmur
    public void setBeratUmur(int beratUmur) {
        this.beratUmur = beratUmur;
    }

    // Getter untuk list items
    public List<String> getItems() {
        return items;
    }

    // Setter untuk list items
    public void setItems(List<String> items) {
        this.items = items;
    }

    // Metode untuk menambahkan sebuah item ke dalam list items
    public void addItem(String item) {
        this.items.add(item);
    }
}