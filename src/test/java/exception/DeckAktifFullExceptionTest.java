package exception;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DeckAktifFullExceptionTest {

    @Test
    public void testExceptionMessage() {
        Exception exception = assertThrows(DeckAktifFullException.class, () -> {
            throw new DeckAktifFullException();
        });

        assertEquals("Deck Aktif Space Not Enough !", exception.getMessage());
    }
}