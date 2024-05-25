package exception;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InsertNonItemExceptionTest {

    @Test
    public void testExceptionMessage() {
        // The test checks if the exception message is as expected
        Exception exception = assertThrows(InsertNonItemException.class, () -> {
            throw new InsertNonItemException();
        });

        assertEquals("Cannot insert Non-Item into Not-Null Object !", exception.getMessage(),
                "The exception message should match the expected output.");
    }
}
