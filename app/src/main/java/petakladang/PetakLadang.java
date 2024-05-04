package petakladang;
import java.util.ArrayList;

class PetakLadang<T extends Card> {
  private List<List<T>> petakLadang;
  public static final int MAX_ROW = 4;
  public static final int MAX_COL = 5;

  public PetakLadang() {
    petakLadang = new ArrayList<T>(MAX_ROW);

    for (int i = 0; i < MAX_ROW; i++) {
      petakLadang.add(new ArrayList<T>(MAX_COL));
    }
  }

  public void addElement(T element, int row, int col) {
    petakLadang.get(row).add(col, element);
  }

  public void removeElement(int row, int col) {
    petakLadang.get(row).remove(col);
  }
}