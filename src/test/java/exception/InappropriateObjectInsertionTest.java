package exception;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InappropriateObjectInsertionTest {

    @Test
    public void testExceptionMessage() {
        // The test checks if the exception message is as expected
        Exception exception = assertThrows(InappropriateObjectInsertion.class, () -> {
            throw new InappropriateObjectInsertion();
        });

        assertEquals("Object insertion failed, inappropriate object type", exception.getMessage(),
                "The exception message should match the expected output.");
    }
}
