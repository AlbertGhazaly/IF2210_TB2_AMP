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

        // Tentukan jumlah petak yang diserang secara acak antara 2 hingga 6
        int jumlahPetakDiserang = random.nextInt(5) + 2; // menghasilkan angka antara 2 dan 6

        // Bersihkan daftar petak yang diserang sebelum mengisinya
        petakDiserang.clear();

        // Pilih petak awal secara acak
        int tempDiserangRow = random.nextInt(maxRow - minRow + 1) + minRow;
        int tempDiserangCol = random.nextInt(maxCol - minCol + 1) + minCol;
        petakDiserang.add(new int[]{tempDiserangRow, tempDiserangCol});

        int count = 1;

        // Tambahkan petak lainnya
        while (count < jumlahPetakDiserang) {
            int[] current = petakDiserang.get(random.nextInt(count)); // Pilih sel yang ada secara acak
            int newRow = current[0];
            int newCol = current[1];

            // Pilih arah secara acak
            int direction = random.nextInt(4);
            switch (direction) {
                case 0: // Up
                    newRow -= 1;
                    break;
                case 1: // Down
                    newRow += 1;
                    break;
                case 2: // Left
                    newCol -= 1;
                    break;
                case 3: // Right
                    newCol += 1;
                    break;
            }

            // Pastikan petak baru berada dalam batasan dan belum ada dalam daftar
            if (newRow >= minRow && newRow <= maxRow && newCol >= minCol && newCol <= maxCol && !containsCell(newRow, newCol)) {
                petakDiserang.add(new int[]{newRow, newCol});
                count++;
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
                paneToReset.setStyle("");
            } else {
                paneToReset.setStyle("");
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
