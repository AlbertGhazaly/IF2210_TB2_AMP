package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import deck.DeckElement;
import deck.KartuLadang;
import player.*;
import card.*;

public class GameObject {
    private Player player1;
    private Player player2;

    public GameObject() {
        player1 = new Player();
        player2 = new Player();
    }

    public void muatPlayer(String pathPlayer1, String pathPlayer2){
        try {
            File file = new File(pathPlayer1);
            Scanner scanner = new Scanner(file);

            // Baca jumlah gulden
            int gulden = Integer.parseInt(scanner.nextLine().trim());
            player1.setGulden(gulden);

            // Baca jumlah deck
            int jumlahDeck = Integer.parseInt(scanner.nextLine().trim());
            player1.setJumlahDeck(jumlahDeck);

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
                player1.getDeck().addElement(new DeckElement(firstInt, secondInt, kartuDeckAktif));
            }

            // Baca jumlah kartu ladang (L)
            int jumlahKartuLadang = Integer.parseInt(scanner.nextLine().trim());

            // Baca kartu ladang
            for (int i = 0; i < jumlahKartuLadang; i++) {
                KartuLadang temp = new KartuLadang();
                String[] data = scanner.nextLine().split(" ");
                String lokasiKartu = data[0];
                String firstChar = lokasiKartu.substring(0, 1);
                String remainingDigits = lokasiKartu.substring(1);
                int firstInt = (int) firstChar.charAt(0) - 'A' + 1;
                int secondInt = Integer.parseInt(remainingDigits);
                temp.setM(firstInt);
                temp.setN(secondInt);
                String namaKartuLadang = data[1];
                temp.setNama(namaKartuLadang);
                int umurBerat = Integer.parseInt(data[2]);
                temp.setBeratUmur(umurBerat);
                int jumlahItem = Integer.parseInt(data[3]);
                for(int j = 0; j < jumlahItem; j++){
                    // To Do : Implementasikan Find berdasarkan nama item
                    String item = data[4+j];
                    temp.addItem(item);
                }
                player1.addKartuLadang(temp);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            File file = new File(pathPlayer2);
            Scanner scanner = new Scanner(file);

            // Baca jumlah gulden
            int gulden = Integer.parseInt(scanner.nextLine().trim());
            player2.setGulden(gulden);

            // Baca jumlah deck
            int jumlahDeck = Integer.parseInt(scanner.nextLine().trim());
            player2.setJumlahDeck(jumlahDeck);

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
                player2.getDeck().addElement(new DeckElement(firstInt, secondInt, kartuDeckAktif));
            }

            // Baca jumlah kartu ladang (L)
            int jumlahKartuLadang = Integer.parseInt(scanner.nextLine().trim());

            // Baca kartu ladang
            for (int i = 0; i < jumlahKartuLadang; i++) {
                KartuLadang temp = new KartuLadang();
                String[] data = scanner.nextLine().split(" ");
                String lokasiKartu = data[0];
                String firstChar = lokasiKartu.substring(0, 1);
                String remainingDigits = lokasiKartu.substring(1);
                int firstInt = (int) firstChar.charAt(0) - 'A' + 1;
                int secondInt = Integer.parseInt(remainingDigits);
                temp.setM(firstInt);
                temp.setN(secondInt);
                String namaKartuLadang = data[1];
                temp.setNama(namaKartuLadang);
                int umurBerat = Integer.parseInt(data[2]);
                temp.setBeratUmur(umurBerat);
                int jumlahItem = Integer.parseInt(data[3]);
                for(int j = 0; j < jumlahItem; j++){
                    // To Do : Implementasikan Find berdasarkan nama item
                    String item = data[4+j];
                    temp.addItem(item);
                }
                player2.addKartuLadang(temp);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printInfoPlayer1() {
        System.out.println("===== INFO PLAYER 1 =====");
        System.out.println("Gulden Player 1 : " + player1.getGulden());
        System.out.println("Jumlah Deck Player 1 : " + player1.getJumlahDeck());
        System.out.println("Deck Player 1 : ");
        for (int i = 0; i < player1.getDeck().getSize(); i++) {
            System.out.print(player1.getDeck().getElement(i).getM() + " " + player1.getDeck().getElement(i).getN() + " ");
            System.out.println(player1.getDeck().getElement(i).getNama());
        }
        System.out.println("Kartu Ladang Player 1 : ");
        for (int i = 0; i < player1.getKartuLadang().size(); i++) {
            System.out.println(player1.getKartuLadang().get(i).getNama());
            System.out.println("Item : ");
            for (int j = 0; j < player1.getKartuLadang().get(i).getItems().size(); j++) {
                System.out.println(player1.getKartuLadang().get(i).getItems().get(j));
            }
        }
    }
    public void printInfoPlayer2(){
        System.out.println("===== INFO PLAYER 2 =====");
        System.out.println("Gulden Player 2 : " + player2.getGulden());
        System.out.println("Jumlah Deck Player 2 : " + player2.getJumlahDeck());
        System.out.println("Deck Player 2 : ");
        for(int i = 0; i < player2.getDeck().getSize(); i++){
            System.out.print(player2.getDeck().getElement(i).getM()+ " " + player2.getDeck().getElement(i).getN() + " ");
            System.out.println(player2.getDeck().getElement(i).getNama());
        }
        System.out.println("Kartu Ladang Player 2 : ");
        for(int i = 0; i < player2.getKartuLadang().size(); i++){
            System.out.println(player2.getKartuLadang().get(i).getNama());
            System.out.println("Item : ");
            for(int j = 0; j < player2.getKartuLadang().get(i).getItems().size(); j++){
                System.out.println(player2.getKartuLadang().get(i).getItems().get(j));
            }
        }
    }
}
