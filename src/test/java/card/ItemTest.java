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
    }

    @Test
    void testParameterizedConstructor() {
        Item item = new Item("Potion", "potion.png");
        assertEquals("Potion", item.getName());
        assertEquals("potion.png", item.getImgPath());
        assertNull(item.getPosition());
    }

    @Test
    void testCopyConstructor() {
        Item original = new Item("Elixir", "elixir.png");
        Item copy = new Item(original);
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getImgPath(), copy.getImgPath());
        assertEquals(original.getPosition(), copy.getPosition());
    }
}
