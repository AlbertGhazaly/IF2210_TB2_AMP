package state;

import gameobject.GameObject;
import card.*;

import java.util.*;

public class Shuffle implements State{
    private List<Card> cards;
    public Shuffle(){
        cards = new ArrayList<>();
    }

    @Override
    public void execute(GameObject objek) {
        Random random = new Random();

        while (cards.size() < 4){
            int x = random.nextInt(objek.getCurrentPlayer().getDeck().getPasifSize());
            cards.add(objek.getCurrentPlayer().getDeck().getPasifElement(x));
            objek.getCurrentPlayer().getDeck().removePasifElement(x);
        }

    }


}
