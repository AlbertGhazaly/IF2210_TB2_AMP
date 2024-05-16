package gamestatus;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import exception.*;
import game.GameObject;
import toko.*;
public class GameStatus extends GameObject {
    public static int turn;
    private Toko toko;

    public GameStatus(){
        super();
        this.toko = new Toko();
        GameStatus.turn = 0;
    }

    /**
     * Setter untuk atribut turn
    */
    public void nextTurn(){
        turn = (turn+1)%2;
    }
    /**
     * getter untuk atribut turn
     *
     * @return int turn dalam permainan.
    */

    /**
     * getter untuk atribut private toko
     *
     * @return Toko dalam permainan.
    */
    public Toko geToko(){
        return this.toko;
    }
    /**
     * Load State dari file .txt dengan path relatif dari root project
     *@param path relatif terhadap root directory
     *@throws IOException
    */

}
