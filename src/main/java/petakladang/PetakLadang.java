package petakladang;
import java.util.List;
import java.util.ArrayList;
import card.*;

class PetakLadang <T extends Card>{
  private List<List<T>> petakLadang;
  public static final int MAX_ROW = 4;
  public static final int MAX_COL = 5;

  public PetakLadang() {
    this.petakLadang = new ArrayList<>();
    for (int i = 0; i < MAX_ROW; i++) {
      this.petakLadang.add(new ArrayList<>());
      for (int j = 0; j < MAX_COL; j++) {
          this.petakLadang.get(i).add(null);
      }
    }
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
    if (petakLadang.get(row)!=null){
      if (petakLadang.get(row).get(col)!=null){
        petakLadang.get(row).set(col,null);
      }
    }

  }

}