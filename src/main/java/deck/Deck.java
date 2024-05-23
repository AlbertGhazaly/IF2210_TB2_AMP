package deck;
import java.util.List;
import java.util.ArrayList;
import card.*;
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
      this.deckAktif.add(element);
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
  public void insertPassiveDeck(int n){
      this.deckPasif.clear();
      Random random = new Random();
      while (this.deckPasif.size()<n){
          int x = random.nextInt(24);
          if (x<6){
              if (!GameObject.hewanList.get(x).getName().equals("Beruang")){
                  this.deckPasif.add( new Hewan(GameObject.hewanList.get(x)));
              }
          }else if (x>=6 && x<15){
              this.deckPasif.add( new Produk(GameObject.produkList.get(x-6)));
          }else if (x>=15 && x<18){
            this.deckPasif.add( new Tanaman(GameObject.tanamanList.get(x-15)));
          }else if (x>=18 && x<24){
            this.deckPasif.add( new Item(GameObject.itemList.get(x-18)));
          }
      }
  }
}