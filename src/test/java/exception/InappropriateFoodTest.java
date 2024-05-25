package exception;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InappropriateFoodTest {

    @Test
    public void testExceptionMessage() {
        // The test checks if the exception message is as expected
        Exception exception = assertThrows(InappropriateFood.class, () -> {
            throw new InappropriateFood();
        });

        assertEquals("'Yikes...', they seem to not like the food !", exception.getMessage(),
                "The exception message should match the expected output.");
    }
}
