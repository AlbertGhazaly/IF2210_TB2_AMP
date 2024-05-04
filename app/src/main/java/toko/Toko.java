package toko;
import java.util.HashMap;
import java.util.Map;

public class Toko {
    private Map<String, Integer> stok;

    public Toko() {
        stok = new HashMap<String, Integer>();
    }

    /**
     * getter untuk atribut private stok dalam toko
     *
     * @return Map<String, Integer> stok toko dalam permainan.
     */
    public Map<String, Integer> getStok() {
        return stok;
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
}
