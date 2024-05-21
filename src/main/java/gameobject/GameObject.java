package gameobject;
import card.*;
import player.*;
import toko.Toko;
import java.util.*;

public class GameObject {
    private Player player1;
    private Player player2;
    private Toko toko;
    public static List<Hewan> hewanList;
    public static List<Tanaman> tanamanList;
    public static List<Produk> produkList;
    public static List<Item> itemList;

    public GameObject() {
        this.player1 = new Player();
        this.player2 = new Player();
        this.toko = new Toko();
        this.initiateCard();
    }
    public Toko geToko(){
        return this.toko;
    }
    public Player getPlayer1() {return this.player1;}
    public Player getPlayer2() {return this.player2;}

    private void initiateCard(){

    }
}
