package card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TanamanTest {

    @Test
    void testDefaultConstructor() {
        Tanaman tanaman = new Tanaman();
        assertNull(tanaman.getName());
        assertNull(tanaman.getImgPath());
        assertNull(tanaman.getPosition());
        assertEquals(0, tanaman.getdurasiPanen());
        assertEquals(0, tanaman.getUmur());
    }

    @Test
    void testParameterizedConstructor() {
        Tanaman tanaman = new Tanaman("Tomat", "tomat.png", 30, 10);
        assertEquals("Tomat", tanaman.getName());
        assertEquals("tomat.png", tanaman.getImgPath());
        assertNull(tanaman.getPosition());
        assertEquals(30, tanaman.getdurasiPanen());
        assertEquals(10, tanaman.getUmur());
    }

    @Test
    void testCopyConstructor() {
        Tanaman original = new Tanaman("Wortel", "wortel.png", 60, 5);
        Tanaman copy = new Tanaman(original);
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getImgPath(), copy.getImgPath());
        assertEquals(original.getPosition(), copy.getPosition());
        assertEquals(original.getdurasiPanen(), copy.getdurasiPanen());
        assertEquals(original.getUmur(), copy.getUmur());
    }

    @Test
    void testAddUmur() {
        Tanaman tanaman = new Tanaman("Cabai", "cabai.png", 45, 15);
        tanaman.addUmur(5);
        assertEquals(20, tanaman.getUmur());
    }

    @Test
    void testGetUmur() {
        Tanaman tanaman = new Tanaman("Bayam", "bayam.png", 25, 3);
        assertEquals(3, tanaman.getUmur());
    }

    @Test
    void testSetDurasiPanen() {
        Tanaman tanaman = new Tanaman("Terong", "terong.png", 50, 20);
        tanaman.setdurasiPanen(55);
        assertEquals(55, tanaman.getdurasiPanen());
    }
}
