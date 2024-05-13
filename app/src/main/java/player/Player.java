package player;

import deck.*;
import java.util.*;
import card.*;

public class Player extends Card{
    private int gulden;
    private int jumlah_deck;
    private Deck<DeckElement> deck;
    private List<KartuLadang> kartu_ladang;

    public Player(){
        this(0, 0, new Deck<DeckElement>(), new ArrayList<KartuLadang>());
    }

    public Player(int gulden, int jumlah_deck, Deck<DeckElement> deck, List<KartuLadang> kartu_ladang){
        this.gulden = gulden;
        this.jumlah_deck = jumlah_deck;
        this.deck = new Deck<>(deck);
        this.kartu_ladang = new ArrayList<KartuLadang>(kartu_ladang);
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

    public Deck<DeckElement> getDeck(){
        return deck;
    }

    public void setDeck(Deck<DeckElement> deck){
        this.deck = deck;
    }
    
    public void addDeck(DeckElement deckElement){
        this.deck.addElement(deckElement);
    }
    
    public List<KartuLadang> getKartuLadang(){
        return kartu_ladang;
    }

    public void setKartuLadang(List<KartuLadang> kartu_ladang){
        this.kartu_ladang = kartu_ladang;
    }

    public void addKartuLadang(KartuLadang kartuLadang){
        this.kartu_ladang.add(kartuLadang);
    }

}


