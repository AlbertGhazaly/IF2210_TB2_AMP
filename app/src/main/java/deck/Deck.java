package deck;
import java.util.List;
import java.util.ArrayList;
import card.*;

class Deck<T extends Card> {
  private List<T> deck;

  public static final int DECK_SIZE = 40;
  public static final int DECK_ACTIVE_SIZE = 6;

  public Deck() {
    deck = new ArrayList<T>(DECK_SIZE);
  }

  public Deck(int size) {
    deck = new ArrayList<T>(size);
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
}