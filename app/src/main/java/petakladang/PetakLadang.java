package petakladang;
import java.util.ArrayList;

class PetakLadang<T extends Card> {
  private List<T> petakLadang;

  public PetakLadang() {
    petakLadang = new ArrayList<T>();
  }
}