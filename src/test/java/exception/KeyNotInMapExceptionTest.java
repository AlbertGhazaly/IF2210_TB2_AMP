package exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class KeyNotInMapExceptionTest {

    @Test
    public void testExceptionMessage() {
        Exception exception = assertThrows(KeyNotInMapException.class, () -> {
            throw new KeyNotInMapException();
        });
        assertEquals("Key Not In Map !", exception.getMessage());
    }
}
