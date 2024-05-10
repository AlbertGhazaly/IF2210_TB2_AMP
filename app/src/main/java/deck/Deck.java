package deck;
import java.util.List;
import java.util.ArrayList;
import card.*;

public class Deck<T extends Card> {
  private List<T> deck;

  public static final int DECK_SIZE = 40;
  public static final int DECK_ACTIVE_SIZE = 6;

  public Deck() {
    deck = new ArrayList<T>(DECK_SIZE);
  }

  public Deck(int size) {
    deck = new ArrayList<T>(size);
  }

  public Deck(Deck<T> deck) {
    this.deck = new ArrayList<T>(deck.deck);
  }

  public void addElement(T element) {
    deck.add(element);
  }

  public void removeElement(T element) {
    deck.remove(element);
  }

  public T getElement(int index) {
    return deck.get(index);
  }

  public int getSize() {
    return deck.size();
  }
}