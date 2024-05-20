package player;
import deck.*;
import java.util.*;
import card.*;

public class Player extends Card{
    private int gulden;
    private int jumlah_deck;
    private Deck<Card> deck;
    private List<Card> kartu_ladang;
    public Player(){
        this(0, 0, new Deck<Card>(), new ArrayList<Card>());
    }
    public Player(int gulden, int jumlah_deck, Deck<Card> deck, List<Card> kartu_ladang){
        this.gulden = gulden;
        this.jumlah_deck = jumlah_deck;
        this.deck = new Deck<>(deck);
        this.kartu_ladang = new ArrayList<Card>(kartu_ladang);
    }
    public Player(final Player other){
        this(other.getGulden(), other.getJumlahDeck(), other.getDeck(), other.getKartuLadang());
    }
    public int getGulden(){
        return gulden;
    }
    public void setGulden(int gulden){
        this.gulden = gulden;
    }
    public int getJumlahDeck(){
        return jumlah_deck;
    }
    public void setJumlahDeck(int jumlah_deck){
        this.jumlah_deck = jumlah_deck;
    }
    public Deck<Card> getDeck(){
        return deck;
    }
    public void setDeck(Deck<Card> deck){
        this.deck = deck;
    }


    public void addDeck(Card card){
        this.deck.addElement(card);
    }

    public List<Card> getKartuLadang(){
        return kartu_ladang;
    }
    public void setKartuLadang(List<Card> kartu_ladang){
        this.kartu_ladang = kartu_ladang;
    }
    public void setItemKartuHewan(Item item, Hewan hewan){
        for (Card card : kartu_ladang){
            if (card.getName().equals(hewan.getName())){
                Hewan h = (Hewan) card;
                h.addItem(item);
            }
        }
    }
    public void setItemKartuTanaman(Item item, Tanaman tanaman){
        for (Card card : kartu_ladang){
            if (card.getName().equals(tanaman.getName())){
                Tanaman t = (Tanaman) card;
                t.addItem(item);
            }
        }
    }
}
