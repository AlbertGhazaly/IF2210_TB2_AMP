package gameobject;
import card.*;
import gamestatus.GameStatus;
import player.*;
import toko.Toko;
import java.util.*;

public class GameObject {
    private Player player1;
    private Player player2;
    private Toko toko;
    public static ArrayList<Hewan> hewanList = new ArrayList<>();
    public static ArrayList<Tanaman> tanamanList =  new ArrayList<>();
    public static ArrayList<Produk> produkList = new ArrayList<>();
    public static ArrayList<Item> itemList = new ArrayList<>();

    public GameObject() {
        GameObject.initiateCard();
        this.player1 = new Player();
        this.player2 = new Player();
        this.toko = new Toko();

    }
    public Toko geToko(){
        return this.toko;
    }
    public Player getPlayer1() {return this.player1;}
    public Player getPlayer2() {return this.player2;}
    public Player getCurrentPlayer() {
        if (GameStatus.turn%2==0){
            return this.player2;
        }
        return this.player1;
    }
    public static void initiateCard(){
        GameObject.hewanList.add(new Hewan("HIU_DARAT",
                "assets/hewan/hiu_darat.png",
                "karnivora",
                0,20
                ));
        GameObject.hewanList.add(new Hewan("SAPI",
                "assets/hewan/cow.png",
                "herbivora",
                0,10
        ));
        GameObject.hewanList.add(new Hewan("DOMBA",
                "assets/hewan/sheep.png",
                "herbivora",
                0,12
        ));
        GameObject.hewanList.add(new Hewan("KUDA",
                "assets/hewan/horse.png",
                "herbivora",
                0,14
        ));
        GameObject.hewanList.add(new Hewan("AYAM",
                "assets/hewan/chicken.png",
                "omnivora",
                0,5
        ));
        GameObject.hewanList.add(new Hewan("BERUANG",
                "assets/hewan/bear.png",
                "omnivora",
                0,25
        ));
        GameObject.itemList.add(new Item(
                "ACCELERATE",
                "assets/item/Accelerate.png"
        ));
        GameObject.itemList.add(new Item(
                "DELAY",
                "assets/item/Delay.png"
        ));
        GameObject.itemList.add(new Item(
                "INSTANT_HARVEST",
                "assets/item/Instant_Harvest.png"
        ));
        GameObject.itemList.add(new Item(
                "DESTROY",
                "assets/item/Destroy.png"
        ));
        GameObject.itemList.add(new Item(
                "PROTECT",
                "assets/item/Protect.png"
        ));
        GameObject.itemList.add(new Item(
                "TRAP",
                "assets/item/bear_trap.png"
        ));
        GameObject.tanamanList.add(new Tanaman(
                "BIJI_JAGUNG",
                "assets/tanaman/corn_seeds.png",
                3,0
        ));
        GameObject.tanamanList.add(new Tanaman(
                "BIJI_LABU",
                "assets/tanaman/pumpkin_seeds.png",
                5,0
        ));
        GameObject.tanamanList.add(new Tanaman(
                "BIJI_STROBERI",
                "assets/tanaman/strawberry_seeds.png",
                4,0

        ));
        GameObject.produkList.add(new Produk(
                "SIRIP_HIU",
                "assets/produk/shark-fin.png",
                500,12,"HIU_DARAT"
        ));
        GameObject.produkList.add(new Produk(
                "SUSU",
                "assets/produk/susu.png",
                100,4,"SAPI"
        ));
        GameObject.produkList.add(new Produk(
                "DAGING_DOMBA",
                "assets/produk/Daging_Domba.png",
                120,6,"DOMBA"
        ));
        GameObject.produkList.add(new Produk(
                "DAGING_KUDA",
                "assets/produk/Daging_Kuda.png",
                150,8,"KUDA"
        ));
        GameObject.produkList.add(new Produk(
                "TELUR",
                "assets/produk/telur.png",
                50,2,"AYAM"
        ));
        GameObject.produkList.add(new Produk(
                "DAGING_BERUANG",
                "assets/produk/Daging_Beruang.png",
                500,12,"BERUANG"
        ));
        GameObject.produkList.add(new Produk(
                "JAGUNG",
                "assets/produk/corn.png",
                150,3,"BIJI_JAGUNG"
        ));
        GameObject.produkList.add(new Produk(
                "LABU",
                "assets/produk/pumpkin.png",
                500,10,"BIJI_LABU"
        ));
        GameObject.produkList.add(new Produk(
                "STROBERI",
                "assets/produk/strawberry.png",
                350,5,"BIJI_STROBERI"
        ));
    }
}
