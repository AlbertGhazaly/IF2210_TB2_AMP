package state;

import gameobject.GameObject;
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

    public void setPetakDiserang(Random random, int jumlahPetakDiserang) {
        int minRow = 0;
        int minCol = 0;
        int maxRow = 3;
        int maxCol = 4;

        int tempDiserangRow = random.nextInt(maxRow - minRow + 1) + minRow;
        int tempDiserangCol = random.nextInt(maxCol - minCol + 1) + minCol;

        petakDiserang.add(new int[]{tempDiserangRow, tempDiserangCol});
        int count = 1;

        while (count < jumlahPetakDiserang) {
            int[] current = petakDiserang.get(random.nextInt(count)); // Randomly pick an existing cell
            int newRow = current[0];
            int newCol = current[1];

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


    public void HapusElementPetakDiserang(PetakLadang ladang) {
        for (int[] petak : petakDiserang) {
            ladang.removeElement(petak[0], petak[1]);
        }
    }

    @Override
    public void execute(GameObject objek) {
        Random random = new Random();
        PetakLadang petakLadang = objek.getCurrentPlayer().getPetakLadang();

        setLamaWaktuMenyerang(random);

        int minPetak = 2;
        int maxPetak = 7;
        int jumlahPetakDiserang = random.nextInt(maxPetak - minPetak + 1) + minPetak;

        setPetakDiserang(random, jumlahPetakDiserang);

        try {
            Thread.sleep(lamaWaktuMenyerang);
        } catch (InterruptedException e) {
            System.err.println("Sleep was interrupted!");
        }

        HapusElementPetakDiserang(petakLadang);
    }
}
