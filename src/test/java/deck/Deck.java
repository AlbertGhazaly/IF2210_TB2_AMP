package deck;

import card.Card;

import java.util.ArrayList;
import java.util.List;

public class Deck<T extends Card> {
  private List<T> deckPasif;
  private List<T> deckAktif;
  public static final int DECK_SIZE = 40;
  public static final int DECK_ACTIVE_SIZE = 6;

  public Deck() {
    this.deckAktif = new ArrayList<>(DECK_ACTIVE_SIZE);
    this.deckPasif = new ArrayList<>(DECK_SIZE);
  }

  public void addAktifElement(T element) {
      this.deckAktif.add(element);
  }
  public void addPasifElement(T element) {
    this.deckPasif.add(element);
  }
  public void removeAktifElement(T element) {
    this.deckAktif.remove(element);
  }
  public void removePasifElement(T element) {
    this.deckPasif.remove(element);
  }

  public T getAktifElement(int index) {
    return this.deckAktif.get(index);
  }
  public T getPasifElement(int index) {
    return this.deckPasif.get(index);
  }
  public int getAktifSize() {
    return this.deckAktif.size();
  }
  public int getPasifSize() {
    return this.deckPasif.size();
  }

}