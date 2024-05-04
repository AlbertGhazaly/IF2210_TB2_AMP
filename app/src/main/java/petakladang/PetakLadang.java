package petakladang;
import java.util.ArrayList;

class PetakLadang<T extends Card> {
  private List<List<T>> petakLadang;
  private static final int MAX_ROW = 4;
  private static final int MAX_COL = 5;

  public PetakLadang() {
    petakLadang = new ArrayList<T>(MAX_ROW);

    for (int i = 0; i < MAX_ROW; i++) {
      petakLadang.add(new ArrayList<T>(MAX_COL));
    }
  }
}