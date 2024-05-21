package card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdukTest {

    private Produk produk;

    @BeforeEach
    public void setUp() {
        produk = new Produk("Beruang", "/images/Beruang.jpg", 10000, 5);
    }

    @Test
    public void testDefaultConstructor() {
        Produk defaultProduk = new Produk();
        assertEquals(0, defaultProduk.getHarga(), "Harga harus 0");
        assertEquals(0, defaultProduk.getAddedBerat(), "Added berat harus 0");
        assertEquals("produk", defaultProduk.getType(), "Type harus 'produk'");
    }

    @Test
    public void testParameterizedConstructor() {
        assertEquals("Beruang", produk.getName(), "Nama harus 'Beruang'");
        assertEquals("/images/Beruang.jpg", produk.getImgPath(), "Image path harus '/images/Beruang.jpg'");
        assertEquals(10000, produk.getHarga(), "Harga harus 10000");
        assertEquals(5, produk.getAddedBerat(), "Added berat harus 5");
        assertEquals("produk", produk.getType(), "Type harus 'produk'");
    }

    @Test
    public void testCopyConstructor() {
        Produk copyProduk = new Produk(produk);
        assertEquals(produk.getName(), copyProduk.getName(), "Name harus cocok");
        assertEquals(produk.getImgPath(), copyProduk.getImgPath(), "Image path harus cocok");
        assertEquals(produk.getHarga(), copyProduk.getHarga(), "Harga harus cocok");
        assertEquals(produk.getAddedBerat(), copyProduk.getAddedBerat(), "Added berat harus cocok");
        assertEquals(produk.getType(), copyProduk.getType(), "Type harus cocok");
    }
}
