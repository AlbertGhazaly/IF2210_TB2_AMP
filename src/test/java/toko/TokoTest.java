package toko;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import exception.KeyNotInMapException;

public class TokoTest {

    private Toko toko;

    @BeforeEach
    public void setUp() {
        toko = new Toko();
    }

    @Test
    public void testAddStokNewKey() {
        toko.addStok("apple", 10);
        assertEquals(10, toko.getStok("apple"), "Stok should be 10 for new item 'apple'");
    }

    @Test
    public void testAddStokExistingKey() {
        toko.addStok("apple", 5);
        toko.addStok("apple", 15);
        assertEquals(20, toko.getStok("apple"), "Stok should be 20 for existing item 'apple' after adding more");
    }

    @Test
    public void testSetStokNewKey() {
        toko.setStok("banana");
        assertEquals(1, toko.getStok("banana"), "Stok should be 1 for new item 'banana'");
    }

    @Test
    public void testSetStokExistingKey() {
        toko.setStok("banana");
        toko.setStok("banana");
        assertEquals(2, toko.getStok("banana"), "Stok should be 2 for existing item 'banana' after setting twice");
    }

    @Test
    public void testGetStokException() {
        Exception exception = assertThrows(KeyNotInMapException.class, () -> {
            toko.getStok("nonexistent");
        });
        assertEquals("Key Not In Map !", exception.getMessage());
    }

    // Implement test for `load` method here if necessary
}
