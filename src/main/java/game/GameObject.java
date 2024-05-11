package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import player.*;
import card.*;

public class GameObject {
    private Player player1;
    private Player player2;

    public GameObject() {
        player1 = new Player();
        player2 = new Player();
    }

    public void muatPlayer1(String pathPlayer1){
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
                player1.getDeck().addElement(new Hewan(firstInt, secondInt, kartuDeckAktif, "imgpath", "kategori", 0, 0, null));
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
                player1.getKartuLadang().add(hewan);
                int jumlahItem = Integer.parseInt(data[3]);
                for(int j = 0; j < jumlahItem; j++){
                    // To Do : Implementasikan Find berdasarkan nama item
                    Item item = new Item(data[4+j],"imgpath",0);
                    player1.setItemKartuHewan(item, hewan);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printInfoPlayer1(){
        System.out.println("Gulden Player 1 : " + player1.getGulden());
        System.out.println("Jumlah Deck Player 1 : " + player1.getJumlahDeck());
        System.out.println("Deck Player 1 : ");
        for(int i = 0; i < player1.getDeck().getSize(); i++){
            System.out.println(player1.getDeck().getElement(i).getName());
        }
        System.out.println("Kartu Ladang Player 1 : ");
        for(int i = 0; i < player1.getKartuLadang().size(); i++){
            System.out.println(player1.getKartuLadang().get(i).getName());
            System.out.println("Item : ");
            // for(int j = 0; j < player1.getKartuLadang().get(i); j++){
            //     System.out.println(player1.getKartuLadang().get(i).getItems().get(j).getName());
            // }
        }
    }

}
