package player;

import deck.*;

import java.io.*;
import java.util.*;
import java.net.URL;

import card.*;
import entity.*;
import gameobject.GameObject;
import gamestatus.GameStatus;
import petakladang.*;
public class Player implements Entity{
    private int gulden;
    private Deck<Card> deck;
    private PetakLadang petak_ladang;
    public Player(){
        this.gulden = 0;
        this.deck = new Deck<>();
        this.petak_ladang = new PetakLadang();
    }

    public Player(int gulden, Deck<Card> deck, PetakLadang petak_ladang){
        this.gulden = gulden;
        this.deck = deck;
        this.petak_ladang = petak_ladang;
    }

    public Player(final Player other){
        this(other.getGulden(), other.getDeck(), other.getPetakLadang());
    }

    public int getGulden(){
        return gulden;
    }

    public void setGulden(int gulden){
        this.gulden = gulden;
    }

    public Deck<Card> getDeck(){
        return this.deck;
    }

    public void setDeck(Deck<Card> deck){
        this.deck = deck;
    }

    public PetakLadang getPetakLadang(){
        return this.petak_ladang;
    }

//    public void setKartuLadang(List<Card> kartu_ladang){
//        this.kartu_ladang = kartu_ladang;
//    }
//
//    public void setItemKartuHewan(Item item, Hewan hewan){
//        for (Card card : kartu_ladang){
//            if (card.getName().equals(hewan.getName())){
//                Hewan h = (Hewan) card;
//                h.addItem(item);
//            }
//        }
//    }
//
//    public void setItemKartuTanaman(Item item, Tanaman tanaman){
//        for (Card card : kartu_ladang){
//            if (card.getName().equals(tanaman.getName())){
//                Tanaman t = (Tanaman) card;
//                t.addItem(item);
//            }
//        }
//    }
//    @TODO ubah loading nya karena ada atribut position di card
    public boolean isIn(List<? extends  Card> listCard, String name){
        for (int i=0;i<listCard.size();i++){
            if (listCard.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void load(String path) throws IOException {

        // Obtain the InputStream of the resource
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);

        if (inputStream == null) {
            throw new IOException("Resource not found: " + path);
        }

        // Wrap InputStream in BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        // Parse current turn
        line = bufferedReader.readLine();
        // Baca jumlah gulden
        int gulden = Integer.parseInt(line);
        this.setGulden(gulden);

            // Baca jumlah deck
        line = bufferedReader.readLine();
            int jumlahDeck = Integer.parseInt(line);
            this.deck.insertPassiveDeck(jumlahDeck);

            // Baca jumlah deck aktif (M)
        line = bufferedReader.readLine();
        int jumlahDeckAktif = Integer.parseInt(line);

            // Baca kartu deck aktif
            for (int i = 0; i < jumlahDeckAktif; i++) {
                line = bufferedReader.readLine();
                String[] data = line.split(" ");
                String lokasi = data[0];
                String kartuDeckAktif = data[1];
//                String firstChar = lokasi.substring(0, 1);
                // Mendapatkan sisa string sebagai string


//                String remainingDigits = lokasi.substring(1);

                // Konversi karakter pertama menjadi integer
//                int firstInt = (int) firstChar.charAt(0) - 'A' + 1;

                // Konversi sisa string menjadi integer
//                int secondInt = Integer.parseInt(remainingDigits);
                // To Do : Implementasikan Find pada data Hewan, Tanaman berdasarkan nama kartu


                // Implementasikan cara untuk menambahkan kartu deck aktif ke deck player1
                if (isIn(GameObject.hewanList,kartuDeckAktif)){
                    for (int j=0;j<GameObject.hewanList.size();j++){
                        if (GameObject.hewanList.get(j).getName().equals(kartuDeckAktif)){

                            this.deck.addAktifElement(new Hewan(GameObject.hewanList.get(j)),Card.convertStringtoRow(lokasi),Card.convertStringtoCol(lokasi));
                        }
                    }
                }else if (isIn(GameObject.tanamanList,kartuDeckAktif)){
                    for (int j=0;j<GameObject.tanamanList.size();j++){
                        if (GameObject.tanamanList.get(j).getName().equals(kartuDeckAktif)){
                            this.deck.addAktifElement(new Tanaman(GameObject.tanamanList.get(j)),Card.convertStringtoRow(lokasi),Card.convertStringtoCol(lokasi));
                        }
                    }
                }else if (isIn(GameObject.produkList,kartuDeckAktif)) {
                    for (int j = 0; j < GameObject.produkList.size(); j++) {
                        if (GameObject.produkList.get(j).getName().equals(kartuDeckAktif)) {
                            this.deck.addAktifElement(new Produk(GameObject.produkList.get(j)), Card.convertStringtoRow(lokasi), Card.convertStringtoCol(lokasi));
                        }
                    }
                }else if (isIn(GameObject.itemList,kartuDeckAktif)) {
                    for (int j = 0; j < GameObject.itemList.size(); j++) {
                        if (GameObject.itemList.get(j).getName().equals(kartuDeckAktif)) {
                            this.deck.addAktifElement(new Item(GameObject.itemList.get(j)), Card.convertStringtoRow(lokasi), Card.convertStringtoCol(lokasi));
                        }
                    }
                }
//                this.getDeck().addElement(new Hewan(firstInt, secondInt, kartuDeckAktif, "imgpath", "kategori", 0, 0, null));
            }

            // Baca jumlah kartu ladang (L)
            line = bufferedReader.readLine();
            int jumlahKartuLadang = Integer.parseInt(line);

            // Baca kartu ladang
            for (int i = 0; i < jumlahKartuLadang; i++) {
                line = bufferedReader.readLine();
                String[] data = line.split(" ");
                String lokasiKartu = data[0];
//                String firstChar = lokasiKartu.substring(0, 1);
//                String remainingDigits = lokasiKartu.substring(1);
//                int firstInt = (int) firstChar.charAt(0) - 'A' + 1;
//                int secondInt = Integer.parseInt(remainingDigits);
                String kartuLadang = data[1];
                int umurBerat = Integer.parseInt(data[2]);
                if (isIn(GameObject.tanamanList,kartuLadang)){
                    for (int j=0;j<GameObject.tanamanList.size();j++){
                        if (GameObject.tanamanList.get(j).getName().equals(kartuLadang)){
                            Tanaman tanamNew = new Tanaman(kartuLadang, GameObject.tanamanList.get(j).getImgPath(), GameObject.tanamanList.get(j).getdurasiPanen(), 0);
                            tanamNew.setPosition(Card.convertStringtoRow(lokasiKartu),Card.convertStringtoCol(lokasiKartu));
                            KartuLadang kartu_ladang=  new KartuLadang<>(tanamNew);

                            int jumlahItem = Integer.parseInt(data[3]);
                            for(int k = 0; k < jumlahItem; k++){
                                // To Do : Implementasikan Find berdasarkan nama item
                                for (int l = 0;l<GameObject.itemList.size();l++){
                                    if (GameObject.itemList.get(l).getName().equals(data[4+k])){
                                        Item item = new Item(data[4+k],GameObject.itemList.get(l).getImgPath());
                                        kartu_ladang.addItems(item);
                                    }
                                }
                            }
                            this.petak_ladang.addElement(kartu_ladang,Card.convertStringtoRow(lokasiKartu),Card.convertStringtoCol(lokasiKartu));
                        }
                    }
                }else if (isIn(GameObject.hewanList,kartuLadang)){
                    for (int j=0;j<GameObject.hewanList.size();j++){
                        if (GameObject.hewanList.get(j).getName().equals(kartuLadang)){
                            Hewan hewanNew = new Hewan(kartuLadang, GameObject.hewanList.get(j).getImgPath(),GameObject.hewanList.get(j).getKategori(),GameObject.hewanList.get(j).getBerat() ,GameObject.hewanList.get(j).getBeratPanen());
                            hewanNew.setPosition(Card.convertStringtoRow(lokasiKartu),Card.convertStringtoCol(lokasiKartu));
                            KartuLadang kartu_ladang=  new KartuLadang<>(hewanNew);

                            int jumlahItem = Integer.parseInt(data[3]);
                            for(int k = 0; k < jumlahItem; k++){
                                // To Do : Implementasikan Find berdasarkan nama item
                                for (int l = 0;l<GameObject.itemList.size();l++){
                                    if (GameObject.itemList.get(l).getName().equals(data[4+k])){
                                        Item item = new Item(data[4+k],GameObject.itemList.get(l).getImgPath());
                                        kartu_ladang.addItems(item);
                                    }
                                }
                            }
                            this.petak_ladang.addElement(kartu_ladang,Card.convertStringtoRow(lokasiKartu),Card.convertStringtoCol(lokasiKartu));
                        }
                    }
                }
//                Hewan hewan = new Hewan(firstInt, secondInt, kartuLadang, "imgpath", "kategori", umurBerat, 0, null);
//                this.getKartuLadang().add(hewan);
//                int jumlahItem = Integer.parseInt(data[3]);
//                for(int j = 0; j < jumlahItem; j++){
//                    // To Do : Implementasikan Find berdasarkan nama item
//                    Item item = new Item(data[4+j],"imgpath",0);
//                    this.setItemKartuHewan(item, hewan);
//                }
            }

        bufferedReader.close();
    }
    @Override
    public void save(String filename) throws  IOException, NullPointerException{
        String path = "src/main/resources/" + filename;
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(String.valueOf(getGulden()));
        writer.newLine();
        writer.write(String.valueOf(this.getDeck().getPasifSize()));
        writer.newLine();
        writer.write(String.valueOf(this.getDeck().getAktifSize()));
        writer.newLine();
        for (int i = 0; i < deck.getAktifSize(); i++) {
            writer.write(this.deck.getAktifElement(i).getPosition() + " ");
            writer.write(this.deck.getAktifElement(i).getName());
            writer.newLine();
        }

        writer.write(String.valueOf(petak_ladang.getNEff()));
        writer.newLine();

        for (int i = 0; i < petak_ladang.getPetakLadang().size(); i++) {
            List<KartuLadang> row = petak_ladang.getPetakLadang().get(i);
            for (KartuLadang elm : row) {
                if (elm != null) {
                    writer.write(elm.getKartu().getPosition());
                    writer.write(" " + elm.getKartu().getName());
                    if (elm.getKartu() instanceof Hewan) {
                        Hewan card = (Hewan) elm.getKartu();
                        writer.write(" " + card.getBerat());
                    } else {
                        Tanaman card = (Tanaman) elm.getKartu();
                        writer.write(" " + card.getUmur());
                    }

//
                    writer.write(" " + elm.getItems().size());

                    for (int k = 0; k < elm.getItems().size(); k++) {
                        writer.write(" " + elm.getElementItem(k).getName());
                    }
                    writer.newLine();

                }
            }
        }
        writer.close();
    }
//    public void printInfoPlayer(){
////        System.out.println("Gulden Player 1 : " + this.getGulden());
////        System.out.println("Deck Player 1 : ");
////        for(int i = 0; i < this.getDeck().getAktifSize(); i++){
////            System.out.println(this.getDeck().getAktifElement(i).getName());
////        }
////        for(int i = 0; i < this.getDeck().getPasifSize(); i++){
////            System.out.println(this.getDeck().getPasifElement(i).getName());
////        }
////        System.out.println("Kartu Ladang Player 1 : ");
////        for(int i = 0; i < this.getKartuLadang().size(); i++){
////            System.out.println(this.getKartuLadang().get(i).getName());
////            System.out.println("Item : ");
//            // for(int j = 0; j < player1.getKartuLadang().get(i); j++){
//            //     System.out.println(player1.getKartuLadang().get(i).getItems().get(j).getName());
//            // }
//
//    }
}


