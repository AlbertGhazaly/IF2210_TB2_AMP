package state;

import gameobject.GameObject;
import card.*;

import java.util.*;

public class Shuffle implements State{
    private List<Card> cards;
    public Shuffle(){
        cards = new ArrayList<>();
    }
    public void insertCardBack(GameObject objek){
        while (cards.size() > 0){
            objek.getCurrentPlayer().getDeck().addPasifElement(cards.get(0));
            cards.remove(0);
        }
    }
    public List<Card> getCards(){
        return cards;
    }
    @Override
    public void execute(GameObject objek){
        Random random = new Random();
        while (cards.size() < 4){
            int x = random.nextInt(objek.getCurrentPlayer().getDeck().getPasifSize());
            cards.add(objek.getCurrentPlayer().getDeck().getPasifElement(x));
            objek.getCurrentPlayer().getDeck().removePasifElement(x);
        }

    }


}
