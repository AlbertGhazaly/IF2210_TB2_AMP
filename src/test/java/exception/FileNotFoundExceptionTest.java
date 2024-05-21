package exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileNotFoundExceptionTest {

    @Test
    public void testExceptionMessage() {
        Exception exception = assertThrows(FileNotFoundException.class, () -> {
            throw new FileNotFoundException();
        });

        String expectedMessage = "File Not Found ! ";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage, "The exception message should match the expected output.");
    }
}