package gameobject;
import card.*;
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
        GameObject.hewanList.add(new Hewan("Hiu Darat",
                "resources/assets/hewan/hiu_darat.png",
                "karnivora",
                0,20
                ));
        GameObject.hewanList.add(new Hewan("Sapi",
                "resources/assets/hewan/cow.png",
                "herbivora",
                0,10
        ));
        GameObject.hewanList.add(new Hewan("Domba",
                "resources/assets/hewan/sheep.png",
                "herbivora",
                0,12
        ));
        GameObject.hewanList.add(new Hewan("Kuda",
                "resources/assets/hewan/horse.png",
                "herbivora",
                0,14
        ));
        GameObject.hewanList.add(new Hewan("Ayam",
                "resources/assets/hewan/chicken.png",
                "omnivora",
                0,5
        ));
        GameObject.hewanList.add(new Hewan("Beruang",
                "resources/assets/hewan/bear.png",
                "omnivora",
                0,25
        ));
        GameObject.itemList.add(new Item(
                "Accelerate",
                "resources/assets/item/Accelerate.png"
        ));
        GameObject.itemList.add(new Item(
                "Delay",
                "resources/assets/item/Delay.png"
        ));
        GameObject.itemList.add(new Item(
                "Instant Harvest",
                "resources/assets/item/Instant_Harvest.png"
        ));
        GameObject.itemList.add(new Item(
                "Destroy",
                "resources/assets/item/Destroy.png"
        ));
        GameObject.itemList.add(new Item(
                "Protect",
                "resources/assets/item/Protect.png"
        ));
        GameObject.itemList.add(new Item(
                "Trap",
                "resources/assets/item/bear_trap.png"
        ));
        GameObject.tanamanList.add(new Tanaman(
                "Biji Jagung",
                "resources/assets/tanaman/corn_seeds.png",
                3,0
        ));
        GameObject.tanamanList.add(new Tanaman(
                "Biji Labu",
                "resources/assets/tanaman/pumpkin_seeds.png",
                5,0
        ));
        GameObject.tanamanList.add(new Tanaman(
                "Biji Stroberi",
                "resources/assets/tanaman/strawberry_seeds.png",
                4,0

        ));
        GameObject.produkList.add(new Produk(
                "Sirip Hiu",
                "resources/assets/produk/shark-fin.png",
                500,12,"Hiu Darat"
        ));
        GameObject.produkList.add(new Produk(
                "Susu",
                "resources/assets/produk/susu.png",
                100,4,"Sapi"
        ));
        GameObject.produkList.add(new Produk(
                "Daging Domba",
                "resources/assets/produk/Daging_Domba.png",
                120,6,"Domba"
        ));
        GameObject.produkList.add(new Produk(
                "Daging Kuda",
                "resources/assets/produk/Daging_Kuda.png",
                150,8,"Kuda"
        ));
        GameObject.produkList.add(new Produk(
                "Telur",
                "resources/assets/produk/telur.png",
                50,2,"Ayam"
        ));
        GameObject.produkList.add(new Produk(
                "Daging Beruang",
                "resources/assets/produk/Daging_Beruang.png",
                500,12,"Beruang"
        ));
        GameObject.produkList.add(new Produk(
                "Jagung",
                "resources/assets/produk/corn.png",
                150,3,"Biji Jagung"
        ));
        GameObject.produkList.add(new Produk(
                "Labu",
                "resources/assets/produk/pumpkin.png",
                500,10,"Biji Labu"
        ));
        GameObject.produkList.add(new Produk(
                "Stroberi",
                "resources/assets/produk/strawberry.png",
                350,5,"Biji Stroberi"
        ));
    }
}
