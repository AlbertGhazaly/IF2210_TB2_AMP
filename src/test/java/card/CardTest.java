package card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    // Helper method to create an anonymous subclass of Card for testing
    private Card createCardInstance(String name, String imgPath, String tipe, String position) {
        return new Card(name, imgPath, tipe, position) {};
    }

    @Test
    void testDefaultConstructor() {
        Card card = new Card() {};
        assertNull(card.getName());
        assertNull(card.getImgPath());
        assertNull(card.getPosition());
        assertNull(card.getTipe());
    }

    @Test
    void testParameterizedConstructor() {
        Card card = new Card("Lion", "lion.png", "animal") {};
        assertEquals("Lion", card.getName());
        assertEquals("lion.png", card.getImgPath());
        assertNull(card.getPosition());
        assertEquals("animal", card.getTipe());
    }

    @Test
    void testParameterizedConstructorWithPosition() {
        Card card = new Card("Tiger", "tiger.png", "animal", "A01") {};
        assertEquals("Tiger", card.getName());
        assertEquals("tiger.png", card.getImgPath());
        assertEquals("A01", card.getPosition());
        assertEquals("animal", card.getTipe());
    }

    @Test
    void testCopyConstructor() {
        Card original = createCardInstance("Elephant", "elephant.png", "animal", "B02");
        Card copy = new Card(original) {};
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getImgPath(), copy.getImgPath());
        assertEquals(original.getPosition(), copy.getPosition());
        assertEquals(original.getTipe(), copy.getTipe());
    }

    @Test
    void testSetPosition() {
        Card card = new Card() {};
        card.setPosition(1, 2); // Should set position to C02
        assertEquals("C02", card.getPosition());
    }

    @Test
    void testConvertPositionToString() {
        assertEquals("A01", Card.convertPositionToString(0, 0));
        assertEquals("B02", Card.convertPositionToString(1, 1));
        assertEquals("C03", Card.convertPositionToString(2, 2));
    }

    @Test
    void testConvertStringtoCol() {
        assertEquals(0, Card.convertStringtoCol("A01"));
        assertEquals(1, Card.convertStringtoCol("B02"));
        assertEquals(2, Card.convertStringtoCol("C03"));
    }

    @Test
    void testConvertStringtoRow() {
        assertEquals(0, Card.convertStringtoRow("A01"));
        assertEquals(1, Card.convertStringtoRow("B02"));
        assertEquals(2, Card.convertStringtoRow("C03"));
    }
}
