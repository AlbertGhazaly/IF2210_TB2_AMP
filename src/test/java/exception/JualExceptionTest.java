package exception;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JualExceptionTest {

    @Test
    public void testExceptionMessage() {
        // The test checks if the exception message is as expected
        Exception exception = assertThrows(JualException.class, () -> {
            throw new JualException();
        });

        String expectedMessage = "Anda tidak dapat melakukan penjualan ! Pastikan slot deck aktif yang dipilih merupakan product !";
        assertEquals(expectedMessage, exception.getMessage(), "The exception message should match the expected output.");
    }
}
