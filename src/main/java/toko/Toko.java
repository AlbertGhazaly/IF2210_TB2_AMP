package toko;
import entity.Entity;
import exception.*;
import gamestatus.GameStatus;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import entity.Entity;

public class Toko implements Entity {
    private Map<String, Integer> stok;

    public Toko() {
        stok = new HashMap<String, Integer>();
    }

    /**
     * getter untuk atribut private stok dalam toko
     *
     * @return int stok toko dalam permainan.
     */
    public int getStok(String key) throws KeyNotInMapException {
        if (!this.stok.containsKey(key)){
            throw new KeyNotInMapException();
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

    @Override
    public void load(String path) throws IOException {
        // FileReader declare
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
    public void save(String path) {

    }
}
