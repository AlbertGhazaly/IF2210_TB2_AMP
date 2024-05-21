package card;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testDefaultConstructor() {
        Item item = new Item();
        assertNull(item.getName());
        assertNull(item.getImgPath());
        assertNull(item.getPosition());
        assertEquals("item", item.getTipe());
        assertEquals(0, item.getHarga());
    }

    @Test
    void testParameterizedConstructor() {
        Item item = new Item("Potion", "potion.png", 100);
        assertEquals("Potion", item.getName());
        assertEquals("potion.png", item.getImgPath());
        assertNull(item.getPosition());
        assertEquals("item", item.getTipe());
        assertEquals(100, item.getHarga());
    }

    @Test
    void testCopyConstructor() {
        Item original = new Item("Elixir", "elixir.png", 200);
        Item copy = new Item(original);
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getImgPath(), copy.getImgPath());
        assertEquals(original.getPosition(), copy.getPosition());
        assertEquals(original.getTipe(), copy.getTipe());
        assertEquals(original.getHarga(), copy.getHarga());
    }

    @Test
    void testGetHarga() {
        Item item = new Item("Sword", "sword.png", 300);
        assertEquals(300, item.getHarga());
    }
}
