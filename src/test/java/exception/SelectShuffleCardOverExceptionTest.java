package exception;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SelectShuffleCardOverExceptionTest {

    @Test
    public void testExceptionMessage() {
        // The test checks if the exception message is as expected
        Exception exception = assertThrows(SelectShuffleCardOverException.class, () -> {
            throw new SelectShuffleCardOverException();
        });

        assertEquals("Jumlah kartu yang kamu pilih itu kebanyakan...", exception.getMessage(),
                "The exception message should match the expected output.");
    }
}
