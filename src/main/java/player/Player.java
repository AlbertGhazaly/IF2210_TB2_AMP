package player;

import deck.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import card.*;
import entity.Entity;

public class Player implements Entity {
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
    @Override
    public void load(String path) throws IOException {

            File file = new File(path);
            Scanner scanner = new Scanner(file);

            // Baca jumlah gulden
            int gulden = Integer.parseInt(scanner.nextLine().trim());
            this.setGulden(gulden);

            // Baca jumlah deck
            int jumlahDeck = Integer.parseInt(scanner.nextLine().trim());
            this.setJumlahDeck(jumlahDeck);

            // Baca jumlah deck aktif (M)
            int jumlahDeckAktif = Integer.parseInt(scanner.nextLine().trim());

            // Baca kartu deck aktif
            for (int i = 0; i < jumlahDeckAktif; i++) {
                String[] data = scanner.nextLine().split(" ");
                String lokasi = data[0];
                String kartuDeckAktif = data[1];
                String firstChar = lokasi.substring(0, 1);
                // Mendapatkan sisa string sebagai string
                String remainingDigits = lokasi.substring(1);

                // Konversi karakter pertama menjadi integer
                int firstInt = (int) firstChar.charAt(0) - 'A' + 1;

                // Konversi sisa string menjadi integer
                int secondInt = Integer.parseInt(remainingDigits);
                // To Do : Implementasikan Find pada data Hewan, Tanaman berdasarkan nama kartu

                // Implementasikan cara untuk menambahkan kartu deck aktif ke deck player1
                this.getDeck().addElement(new Hewan(firstInt, secondInt, kartuDeckAktif, "imgpath", "kategori", 0, 0, null));
            }

            // Baca jumlah kartu ladang (L)
            int jumlahKartuLadang = Integer.parseInt(scanner.nextLine().trim());

            // Baca kartu ladang
            for (int i = 0; i < jumlahKartuLadang; i++) {
                String[] data = scanner.nextLine().split(" ");
                String lokasiKartu = data[0];
                String firstChar = lokasiKartu.substring(0, 1);
                String remainingDigits = lokasiKartu.substring(1);
                int firstInt = (int) firstChar.charAt(0) - 'A' + 1;
                int secondInt = Integer.parseInt(remainingDigits);
                String kartuLadang = data[1];
                int umurBerat = Integer.parseInt(data[2]);
                Hewan hewan = new Hewan(firstInt, secondInt, kartuLadang, "imgpath", "kategori", umurBerat, 0, null);
                this.getKartuLadang().add(hewan);
                int jumlahItem = Integer.parseInt(data[3]);
                for(int j = 0; j < jumlahItem; j++){
                    // To Do : Implementasikan Find berdasarkan nama item
                    Item item = new Item(data[4+j],"imgpath",0);
                    this.setItemKartuHewan(item, hewan);
                }
            }

            scanner.close();
    }
    @Override
    public void save(String path) throws  IOException{

    }
    public void printInfoPlayer(){
        System.out.println("Gulden Player 1 : " + this.getGulden());
        System.out.println("Jumlah Deck Player 1 : " + this.getJumlahDeck());
        System.out.println("Deck Player 1 : ");
        for(int i = 0; i < this.getDeck().getSize(); i++){
            System.out.println(this.getDeck().getElement(i).getName());
        }
        System.out.println("Kartu Ladang Player 1 : ");
        for(int i = 0; i < this.getKartuLadang().size(); i++){
            System.out.println(this.getKartuLadang().get(i).getName());
            System.out.println("Item : ");
            // for(int j = 0; j < player1.getKartuLadang().get(i); j++){
            //     System.out.println(player1.getKartuLadang().get(i).getItems().get(j).getName());
            // }
        }
    }
}


