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

    public List<int []> getPetakDiserang(){
        return petakDiserang;
    }

    public int getLamaWaktuMenyerang() {
        return lamaWaktuMenyerang;
    }

    public void setPetakDiserang(Random random, int jumlahPetakDiserang){
        int minRow = 0;
        int minCol = 0;
        int maxRow = 5;
        int maxCol = 4;

        int tempDiserangRow = random.nextInt(maxRow - minRow);
        int tempDiserangCol = random.nextInt(maxCol - minCol);

        petakDiserang.add(new int[]{tempDiserangRow, tempDiserangCol});
        int i = 0;

        while (petakDiserang.size() < jumlahPetakDiserang) {
            tempDiserangRow = random.nextInt(3) - 1 + petakDiserang.get(i)[0];
            tempDiserangCol = random.nextInt(3) - 1 + petakDiserang.get(i)[1];

            if (tempDiserangRow < 0 || tempDiserangRow > 5 || tempDiserangCol < 0 || tempDiserangCol > 4){
                continue;
            }
            petakDiserang.add(new int[]{tempDiserangRow, tempDiserangCol});
            i++;
        }
    }

    public void HapusElementPetakDiserang(PetakLadang ladang){
        for (int i = 0; i < petakDiserang.size(); i++) {
            ladang.removeElement(petakDiserang.get(i)[0], petakDiserang.get(i)[1]);
        }
    }

    @Override
    public void execute(GameObject objek) {
        Random random = new Random();
        PetakLadang petakLadang = objek.getCurrentPlayer().getPetakLadang();

        int minWaktu = 30;
        int maxWaktu = 61;
        lamaWaktuMenyerang = random.nextInt(maxWaktu - minWaktu) + minWaktu;

        int minPetak = 2;
        int maxPetak = 7;
        int jumlahPetakDiserang = random.nextInt(maxPetak - minPetak) + minPetak;

        setPetakDiserang(random, jumlahPetakDiserang);

        try {
            Thread.sleep(lamaWaktuMenyerang);
        } catch (InterruptedException e) {
            System.err.println("Sleep was interrupted!");
        }

        HapusElementPetakDiserang(petakLadang);
    }
}
