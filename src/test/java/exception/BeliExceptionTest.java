package exception;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BeliExceptionTest {

    @Test
    public void testExceptionMessage() {
        // This test checks if the exception message is as expected
        Exception exception = assertThrows(BeliException.class, () -> {
            throw new BeliException();
        });

        String expectedMessage = "Anda tidak dapat melakukan pembelian ! Pastikan slot deck aktif kosong, gulden anda cukup, dan stok tersedia pada toko !";
        assertEquals(expectedMessage, exception.getMessage(),
                "The exception message should match the expected output.");
    }
}
