package petakladang;
import java.util.List;
import java.util.ArrayList;
import card.*;

class PetakLadang <T extends Card>{
  private List<List<T>> petakLadang;
  public static final int MAX_ROW = 4;
  public static final int MAX_COL = 5;

  public PetakLadang() {
    petakLadang = new ArrayList<>(MAX_ROW*MAX_COL);
  }

  public void addElement(T element, int row, int col) {
    if (petakLadang.get(row)==null){
        petakLadang.set(row,new ArrayList<>());
    }

    petakLadang.get(row).add(col, element);
  }
  public  List<List<T>> getPetakLadang() {
    return this.petakLadang;
  }
  public void removeElement(int row, int col) {
    if (petakLadang.get(row).get(col)!=null){
        petakLadang.get(row).remove(col);
    }
  }

}