package gamestatus;
import java.io.IOException;
import state.*;
import gameobject.GameObject;
import toko.*;
public class GameStatus{
    public static int turn;
    private State status;
    private GameObject objek;
    public GameStatus(){
        GameStatus.turn = 0;
        this.status = new Shuffle();
        this.objek = new GameObject();
    }

    /**
     * Setter untuk atribut turn
    */
    public void nextState(){
        if (this.status instanceof Shuffle){
            this.status = new SeranganBeruang();
        }else if(this.status instanceof SeranganBeruang){
            this.status = new AksiBebas();
        }else{
            this.status = new Shuffle();
            GameStatus.turn += 1;
        }
    }
    public void execute(){
        this.status.execute(this.objek);
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
    /**
     * Load State dari file .txt dengan path relatif dari root project
     *@param path relatif terhadap root directory
     *@throws IOException
    */

}
