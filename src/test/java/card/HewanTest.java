package card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HewanTest {

    @Test
    void testDefaultConstructor() {
        var hewan = new Hewan();
        assertNull(hewan.getKategori());
        assertEquals(0, hewan.getBerat());
        assertEquals(0, hewan.getBeratPanen());
        assertNull(hewan.getName());
        assertNull(hewan.getImgPath());
    }

    @Test
    void testParameterizedConstructor() {
        var hewan = new Hewan("Sapi", "sapi.png", "Mamalia", 500, 400);
        assertEquals("Mamalia", hewan.getKategori());
        assertEquals(500, hewan.getBerat());
        assertEquals(400, hewan.getBeratPanen());
        assertEquals("Sapi", hewan.getName());
        assertEquals("sapi.png", hewan.getImgPath());
    }

    @Test
    void testCopyConstructor() {
        var original = new Hewan("Ayam", "ayam.png", "Unggas", 2, 1);
        var copy = new Hewan(original);
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getImgPath(), copy.getImgPath());
        assertEquals(original.getKategori(), copy.getKategori());
        assertEquals(original.getBerat(), copy.getBerat());
        assertEquals(original.getBeratPanen(), copy.getBeratPanen());
    }

    @Test
    void testSetAndGetKategori() {
        var hewan = new Hewan();
        hewan.setKategori("Reptil");
        assertEquals("Reptil", hewan.getKategori());
    }

    @Test
    void testSetAndGetBerat() {
        var hewan = new Hewan();
        hewan.setBerat(300);
        assertEquals(300, hewan.getBerat());
    }

    @Test
    void testSetAndGetBeratPanen() {
        var hewan = new Hewan();
        hewan.setBeratPanen(200);
        assertEquals(200, hewan.getBeratPanen());
    }

    @Test
    void testAddBerat() {
        var hewan = new Hewan();
        hewan.setBerat(100);
        hewan.addBerat(50);
        assertEquals(150, hewan.getBerat());
    }

    @Test
    void testAddBeratPanen() {
        var hewan = new Hewan();
        hewan.setBeratPanen(80);
        hewan.addBeratPanen(20);
        assertEquals(100, hewan.getBeratPanen());
    }
}
