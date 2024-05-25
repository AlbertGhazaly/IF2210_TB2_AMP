package exception;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FieldInAccessibleTest {

    @Test
    public void testExceptionMessage() {
        Exception exception = assertThrows(FieldInAccessible.class, () -> {
            throw new FieldInAccessible();
        });

        assertEquals("Field Accessed is Inaccessible !", exception.getMessage(), "Exception message should match the expected text.");
    }
}
