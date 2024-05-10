package gamestatus;
import exception.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class GameStatusTest {
     @Test void atributeTurnTest() {
        GameStatus state = new GameStatus();
        state.nextTurn();
        assertEquals(1,state.getTurn(),"Turn incorrect expected: 1, got: "+state.getTurn());

    }
    @Test void atributeTokoTest() {
        GameStatus state = new GameStatus();
        state.geToko().addStok("Mangga", 1);
        state.geToko().addStok("Jambu", 2);
        try{
            assertEquals(1,state.geToko().getStok("Mangga"),"Turn incorrect expected: 1, got: "+state.geToko().getStok("Mangga"));

        }catch(KeyNotInMapException e){
            
        }
    }
    @Test void loaderStateTest() {
        GameStatus state = new GameStatus();
        try{
            state.loadState("resource/gamestate.txt");
            
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            System.out.println( state.geToko().getStok("SIRIP_HIU"));
            assertEquals(4, state.geToko().getStok("SIRIP_HIU"));
        }
        catch(KeyNotInMapException e){
            e.printStackTrace();
        }
    }
}
