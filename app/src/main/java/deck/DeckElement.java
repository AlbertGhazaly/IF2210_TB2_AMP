package deck;
import card.*;

public class DeckElement extends Card {
    // Atribut private untuk lokasi (m dan n) dan nama untuk elemen deck
    private int m;
    private int n;
    private String nama;

    public DeckElement(){
        this.m = -1;
        this.n = -1;
        this.nama = "";
    }

    // Konstruktor untuk menginisialisasi DeckElement dengan lokasi (m, n) dan nama
    public DeckElement(int m, int n, String nama) {
        this.m = m;
        this.n = n;
        this.nama = nama;
    }

    // Getter untuk mendapatkan nilai m
    public int getM() {
        return m;
    }

    // Setter untuk m
    public void setM(int m) {
        this.m = m;
    }

    // Getter untuk mendapatkan nilai n
    public int getN() {
        return n;
    }

    // Setter untuk n
    public void setN(int n) {
        this.n = n;
    }

    // Getter untuk mendapatkan nama
    public String getNama() {
        return nama;
    }

    // Setter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }
}