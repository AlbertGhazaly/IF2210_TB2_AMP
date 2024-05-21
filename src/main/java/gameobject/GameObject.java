package gameobject;

import player.*;
import toko.Toko;

public class GameObject {
    private Player player1;
    private Player player2;
    private Toko toko;
    public GameObject() {
        this.player1 = new Player();
        this.player2 = new Player();
        this.toko = new Toko();
    }
    public Toko geToko(){
        return this.toko;
    }

}
