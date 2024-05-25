package state;

import card.Card;
import card.Item;
import com.tubesoop.tubes2oop.Main;
import gameobject.GameObject;
import javafx.scene.layout.Pane;
import petakladang.KartuLadang;
import petakladang.PetakLadang;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SeranganBeruang implements State {
    private List<int[]> petakDiserang;
    private int lamaWaktuMenyerang;

    public SeranganBeruang() {
        petakDiserang = new ArrayList<>();
    }

    public List<int[]> getPetakDiserang() {
        return petakDiserang;
    }

    public int getLamaWaktuMenyerang() {
        return lamaWaktuMenyerang;
    }

    public void setPetakDiserang(Random random) {
        int minRow = 0;
        int minCol = 0;
        int maxRow = 3;
        int maxCol = 4;

        // Bersihkan daftar petak yang diserang sebelum mengisinya
        petakDiserang.clear();

        // Tentukan jumlah petak yang diserang secara acak antara 2, 4, atau 6
        int[] possibleValues = {2, 4, 6};
        int jumlahPetakDiserang = possibleValues[random.nextInt(possibleValues.length)];

        // Tentukan lebar dan tinggi bidang datar berdasarkan jumlah petak yang diserang
        int width, height;
        if (jumlahPetakDiserang == 2) {
            width = 2;
            height = 1;
        } else if (jumlahPetakDiserang == 4) {
            width = 2;
            height = 2;
        } else { // jumlahPetakDiserang == 6
            width = 3;
            height = 2;
        }

        // Pilih titik awal bidang datar secara acak
        int startRow = random.nextInt(maxRow - height + 1);
        int startCol = random.nextInt(maxCol - width + 1);

        // Tambahkan semua petak dalam bidang datar ke dalam daftar petak yang diserang
        for (int row = startRow; row < startRow + height; row++) {
            for (int col = startCol; col < startCol + width; col++) {
                petakDiserang.add(new int[]{row, col});
            }
        }
    }



    public void setLamaWaktuMenyerang(Random random){
        int minWaktu = 30;
        int maxWaktu = 61;
        lamaWaktuMenyerang = random.nextInt(maxWaktu - minWaktu) + minWaktu;
    }

    private boolean containsCell(int row, int col) {
        for (int[] cell : petakDiserang) {
            if (cell[0] == row && cell[1] == col) {
                return true;
            }
        }
        return false;
    }


    public void HapusElementPetakDiserang(PetakLadang ladang, GameObject objek, ArrayList<Integer> indexToAttack) {
        for (int[] petak : petakDiserang) {
            boolean protect = false;
            int row = petak[0];
            int col = petak[1];
            KartuLadang<Card> kartuLadang = objek.getCurrentPlayer().getPetakLadang().getElement(row, col);
            if (kartuLadang != null) {
                for (Item item : kartuLadang.getItems()) {
                    if (item.getName().equalsIgnoreCase("PROTECT")) {
                        protect = true;
                        break;
                    }
                }
            }
            if (!protect) {
                ladang.removeElement(row, col);
            }
        }
        for (int index : indexToAttack) {
            Pane paneToReset = (Pane) Main.fieldPane.getChildren().get(index);
            if (ladang.getElement(index / 5, index % 5) != null) {
                // Set style to default without clearing the children
                paneToReset.setStyle("-fx-border-radius: 25; -fx-background-radius: 10");
            } else {
                paneToReset.setStyle("-fx-border-radius: 25; -fx-background-radius: 10");
                paneToReset.getChildren().clear();
            }
        }
    }


    @Override
    public void execute(GameObject objek) {
        Random random = new Random();

        setLamaWaktuMenyerang(random);
        setPetakDiserang(random);
    }
}
