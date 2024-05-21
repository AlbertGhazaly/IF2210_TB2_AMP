package gamestatus;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameStatusTest {

    private GameStatus gameStatus;

    @BeforeEach
    public void setUp() {
        gameStatus = new GameStatus();
    }

    @Test
    public void testInitialTurn() {
        assertEquals(0, GameStatus.turn, "Initial turn should be 0");
    }

    @Test
    public void testNextTurn() {
        gameStatus.nextTurn();
        assertEquals(1, GameStatus.turn, "Turn should be 1 after one increment");
        gameStatus.nextTurn();
        assertEquals(0, GameStatus.turn, "Turn should wrap around to 0 after two increments");
    }

    @Test
    public void testGetToko() {
        assertNotNull(gameStatus.geToko(), "geToko should return a non-null Toko object");
    }

    // Test for load and save methods can be implemented here if needed
}
