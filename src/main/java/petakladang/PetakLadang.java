package petakladang;
import java.util.List;
import java.util.ArrayList;
import card.*;
import com.tubesoop.tubes2oop.FieldController;

public class PetakLadang{
  private List<List<KartuLadang>> petakLadang;
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
public KartuLadang getElement(int row, int col) {
    return this.petakLadang.get(row).get(col);
}
  public void addElement(KartuLadang element, int row, int col) {
    if (petakLadang.get(row)==null){
        petakLadang.set(row,null);
    }

    petakLadang.get(row).set(col, element);
  }
  public boolean isElementEmpty(int row, int col) {
    return this.getElement(row,col)==null;
  }
  public  List<List<KartuLadang>> getPetakLadang() {
    return this.petakLadang;
  }
  public void removeElement(int row, int col) {
    if (petakLadang.get(row)!=null){
      if (!this.isElementEmpty(row,col)){
        petakLadang.get(row).set(col,null);
      }
    }

  }
  public void swapElement(int id1, int id2){
    int row1= id1/5;
    int col1 = id1 % 5;
    int row2= id2/5;
    int col2 = id2 % 5;
    KartuLadang temp;
    if (this.getElement(row1,col1)!=null){
      temp = (KartuLadang) this.getElement(row1,col1).getInstance();
    }else{
      temp = null;
    }
    KartuLadang temp2;
    if (this.getElement(row2,col2)!=null){
      temp2 = (KartuLadang) this.getElement(row2,col2).getInstance();
    }else{
      temp2 = null;
    }
    this.addElement(temp,row2,col2);
    this.addElement(temp2,row1,col1);
    FieldController.reloadImage();

  }

}