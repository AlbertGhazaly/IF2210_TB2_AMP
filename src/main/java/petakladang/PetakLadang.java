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

//    if (element.getKartu() instanceof Hewan){
//      System.out.println("Berat hewan: "+((Hewan) element.getKartu()).getBerat());
//    }else if (element.getKartu() instanceof  Tanaman){
//      System.out.println("Berat tanam: "+((Tanaman) element.getKartu()).getUmur());
//    }
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
  public int getNEff(){
    int n = 0;
    for (int i=0;i<MAX_ROW;i++){
      for (int j=0;j<MAX_COL;j++){
        KartuLadang temp = (KartuLadang) this.getElement(i,j);
        if (temp!=null){
          n+=1;
        }
      }
    }
    return n;
  }
  public void petakLadangClear(){
    this.petakLadang.clear();
    for (int i = 0; i < MAX_ROW; i++) {
      this.petakLadang.add(new ArrayList<>());
      for (int j = 0; j < MAX_COL; j++) {
        this.petakLadang.get(i).add(null);
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
      System.out.println("Items1 : "+this.getElement(row1,col1).getItems().size());
      if (this.getElement(row1,col1).getKartu() instanceof Hewan){
        System.out.println("Berat hewan: "+((Hewan) this.getElement(row1,col1).getKartu()).getBerat());
      }else if (this.getElement(row1,col1).getKartu() instanceof  Tanaman){
        System.out.println("Berat tanam: "+((Tanaman) this.getElement(row1,col1).getKartu()).getUmur());
      }
      temp = (KartuLadang) this.getElement(row1,col1).getInstance();
    }else{
      temp = null;
    }
    KartuLadang temp2;
    if (this.getElement(row2,col2)!=null){
      System.out.println("Items2 : "+this.getElement(row2,col2).getItems().size());
          if (this.getElement(row2,col2).getKartu() instanceof Hewan){
      System.out.println("Berat hewan: "+((Hewan) this.getElement(row2,col2).getKartu()).getBerat());
      }else if (this.getElement(row2,col2).getKartu() instanceof  Tanaman){
        System.out.println("Berat tanam: "+((Tanaman) this.getElement(row2,col2).getKartu()).getUmur());
      }
      temp2 = (KartuLadang) this.getElement(row2,col2).getInstance();
    }else{
      temp2 = null;
    }
    this.addElement(temp,row2,col2);
    this.addElement(temp2,row1,col1);
    FieldController.reloadImage();

  }

}