package toko;
import card.Produk;
import entity.Entity;
import exception.*;
import gamestatus.GameStatus;
import exception.BeliException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.scene.control.Alert;
import player.Player;
import gameobject.GameObject;

public class Toko implements Entity {
    private Map<String, Integer> stok;
    private Map<String, Integer> hargaBarang;

    public Toko() {
        stok = new HashMap<String, Integer>();
        hargaBarang = new HashMap<String, Integer>();

        // Inisialisasi harga barang
        hargaBarang.put("SIRIP_HIU", 500);
        hargaBarang.put("SUSU", 100);
        hargaBarang.put("DAGING_DOMBA", 120);
        hargaBarang.put("DAGING_KUDA", 150);
        hargaBarang.put("TELUR", 50);
        hargaBarang.put("DAGING_BERUANG", 500);
        hargaBarang.put("JAGUNG", 150);
        hargaBarang.put("LABU", 500);
        hargaBarang.put("STROBERI", 350);
    }

    /**
     * getter untuk atribut private stok dalam toko
     *
     * @return int stok toko dalam permainan.
     */
    public int getStok(String key) {
        if (!this.stok.containsKey(key)){
            return 0;
        }
        return this.stok.get(key);
    }
    /**
     * menambah item pada stok toko
     * 
     * 
     * @Item belum ada -> daftar item dengan jumlah val
     * @item sudah ada -> menambah jumlah item menjadi val + jumlah item sekarang
     */
    public void addStok(String key, int val){
        if (this.stok.containsKey(key)){
            int currStokNum = this.stok.get(key);
            this.stok.put(key, currStokNum+ val);
        }else{
            this.stok.put(key, val);
        }
    }

    /**
     * Menambahkan barang ke dalam stok toko sesuai dengan nama barang. Method ini akan melakukan validasi apakah
     * nama barang sudah terdapat dalam stok. Apabila barang sudah terdapat dalam stok maka jumlah barang kita
     * tambahkan 1.
     *
     * @param barang Nama barang yang akan ditambahkan ke dalam stok toko.
     */
    public void setStok(String barang) {
        // Mengecek apakah barang sudah ada di dalam stok
        if (this.stok.containsKey(barang)) {
            // Jika sudah ada, tingkatkan jumlahnya
            int jumlah = this.stok.get(barang);
            this.stok.put(barang, jumlah + 1);
        } else {
            // Jika belum ada, tambahkan ke stok dengan jumlah 1
            this.stok.put(barang, 1);
        }
    }

    public static void showErrorDialogBeli(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Pembelian Gagal");
        alert.setContentText(e.getMessage());

        // Print the stack trace to the console (optional)
        e.printStackTrace();
        alert.showAndWait();
    }

    /**
     * Method dengan masukan berupa player dan barang dimana player melakukan pembelian pada toko.
     * I.S. Barang terinisialisasi pada stok Toko
     * F.S. Barang diinput ke deck aktif player tersebut
     *
     * @param player Pemain yang sedang melakukan pembelian.
     * @param barang Barang yang ingin dibeli oleh pemain.
     */
    public void beli(Player player, String barang) {
        try{
            if(stok.get(barang) != null) {
                if (player.getDeck().getAktifSize() < 6 && player.getGulden() >= hargaBarang.get(barang) && stok.get(barang) > 0) {
                    for (int i = 0; i < GameObject.produkList.size(); i++) {
                        if (GameObject.produkList.get(i).getName().equals(barang)) {
                            // Menambahkan barang ke deck aktif pemain
                            player.getDeck().addAktifElement(new Produk(GameObject.produkList.get(i)));
                            int harga = hargaBarang.get(barang);
                            player.setGulden(player.getGulden() - harga);
                            // Mengurangi stok barang
                            stok.put(barang, stok.get(barang) - 1);
                            break;
                        }
                    }
                } else {
                    throw new BeliException();
                }
            }
            else{
                throw new BeliException();
            }
        } catch (Exception e){
            e.printStackTrace();
            showErrorDialogBeli(e);
        }
    }



    public static void showErrorDialogJual(Exception e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Penjualan Gagal");
        alert.setContentText(e.getMessage());

        // Print the stack trace to the console (optional)
        e.printStackTrace();
        alert.showAndWait();
    }

    /**
     * Method dengan masukan berupa player dan barang dimana player melakukan penjualan pada toko.
     * I.S. Barang terinisialisasi pada deck aktif player
     * F.S. Barang berpindah dari deck aktif player menuju Toko
     *
     * @param player Pemain yang sedang melakukan pembelian.
     * @param indeks lokasi deck aktif yang ingin dihapus.
     */
    public void jual(Player player, int indeks){
        try {
            if (player.getDeck().getAktifElement(indeks) != null) {
                String barang = player.getDeck().getAktifElement(indeks).getName();
                System.out.println(barang);
                // Cek apakah barang ada dalam stok dan hargaBarang
                if (hargaBarang.containsKey(barang)) {
                    // Menghapus barang dari deck aktif pemain
                    player.getDeck().removeAktifElement(indeks);
                    // Menambahkan stok barang
                    stok.put(barang, stok.getOrDefault(barang, 0) + 1);
                    int harga = hargaBarang.get(barang);
                    player.setGulden(player.getGulden() + harga);
                }
                else {
                    throw new JualException();
                }
            } else {
                throw new JualException();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            showErrorDialogJual(e);
        }
    }

    @Override
    public void load(String path) throws IOException {
        // FileReader declare
        this.stok.clear();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);

        if (inputStream == null) {
            throw new IOException("Resource not found: " + path);
        }

        // Wrap InputStream in BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        // Parse current turn
        line = bufferedReader.readLine();
        GameStatus.turn = Integer.parseInt(line);
        // Parse stok toko
        line = bufferedReader.readLine();
        int nItem = Integer.parseInt(line);
        for (int i=0;i<nItem;i++){
            line = bufferedReader.readLine();
            String[] paresdStr = line.split(" ");
            this.addStok(paresdStr[0], Integer.parseInt(paresdStr[1]));
        }
        // Close FileReader
        bufferedReader.close();

    }

    @Override
    public void save(String filename) throws IOException {
        String path = "src/main/resources/" + filename;
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(String.valueOf(GameStatus.turn));
        writer.newLine();
        writer.write(String.valueOf(stok.size()));
        writer.newLine();

        for (Map.Entry<String, Integer> entry : stok.entrySet()) {
            writer.write(entry.getKey() + " ");
            writer.write(String.valueOf(entry.getValue()));
            // Add a newline except for the last entry
            writer.newLine();

        }
        writer.close();
    }
}
