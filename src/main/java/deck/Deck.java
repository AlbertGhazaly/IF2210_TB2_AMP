package deck;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import card.*;
import com.tubesoop.tubes2oop.FieldController;
import gameobject.GameObject;

import java.util.Random;
public class Deck<T extends Card> {
  private List<Card> deckPasif;
  private List<Card> deckAktif;
  public static final int DECK_PASSIVE_ROW_SIZE = 40;
  public static final int DECK_ACTIVE_SIZE = 6;

  public Deck() {
    this.deckAktif = new ArrayList<>();
    for (int i = 0;i<DECK_ACTIVE_SIZE;i++){
      this.deckAktif.add(null);
    }
    this.deckPasif = new ArrayList<>();
    insertPassiveDeck(DECK_PASSIVE_ROW_SIZE);
  }
public void addAktifElementRandom(T element){
      for (int i = 0;i<DECK_ACTIVE_SIZE;i++){
          if (deckAktif.get(i) == null){
              this.addAktifElement(element,0,i);
              return;

          }
      }
}
  public void addAktifElement(T element) {
      for (int i = 0; i < DECK_ACTIVE_SIZE; i++) {
          if (this.deckAktif.get(i) == null) {
              this.deckAktif.set(i, element);
              break;
          }
      }
  }
  public void addAktifElement(T element, int row, int col) {
    element.setPosition(row,col);
    this.deckAktif.set(col,element);
  }

  public void addPasifElement(T element) {
    this.deckPasif.add(element);
  }
  public void removeAktifElement(T element) {
    this.deckAktif.remove(element);
  }
  public void removeAktifElement(int idx){
    this.deckAktif.set(idx,null);
  }


  public void removePasifElement(T element) {
    this.deckPasif.remove(element);
  }
  public void removePasifElement(int idx) {
    this.deckPasif.remove(idx);
  }

  public Card getAktifElement(int index) {
    return this.deckAktif.get(index);
  }
  public Card getPasifElement(int index) {
    return this.deckPasif.get(index);
  }
  public int getAktifSize() {
      int n = 0;
      for (int i = 0;i<DECK_ACTIVE_SIZE;i++){
          Card temp = (Card) this.deckAktif.get(i);
          if (temp!= null) {
              n += 1;
          }
      }
      return n;
  }
  public int getPasifSize() {
    return this.deckPasif.size();
  }
    public final static List<Integer> komposisi = new ArrayList<>(Arrays.asList(
            0,1,2,3,4,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,
            0,1,2,3,4,
            15,16,17,
            18,19,20,21,22,23,
            0,1,3
            ));
  public void insertPassiveDeck(int n){
      if (n==40){
          this.deckPasif.clear();
      }
      int i = 0;
      while (this.deckPasif.size()<n){
          if (komposisi.get(i)<6){
              if (!GameObject.hewanList.get(komposisi.get(i)).getName().equals("BERUANG")){
                  this.deckPasif.add( new Hewan(GameObject.hewanList.get(komposisi.get(i))));
              }
          }else if (komposisi.get(i)>=6 && komposisi.get(i)<15){
              this.deckPasif.add( new Produk(GameObject.produkList.get(komposisi.get(i)-6)));
          }else if (komposisi.get(i)>=15 && komposisi.get(i)<18){
            this.deckPasif.add( new Tanaman(GameObject.tanamanList.get(komposisi.get(i)-15)));
          }else if (komposisi.get(i)>=18 && komposisi.get(i)<24){
            this.deckPasif.add( new Item(GameObject.itemList.get(komposisi.get(i)-18)));
          }
          i += 1;
      }
  }

  public void swapIndex(int i, int j){
      Card temp = this.deckAktif.get(i);
      this.deckAktif.set(i,this.deckAktif.get(j));
      this.deckAktif.set(j,temp);
      FieldController.reloadImage();
  }
}