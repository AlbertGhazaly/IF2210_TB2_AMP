package gamestatus;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import state.*;
import gameobject.GameObject;
import toko.*;
public class GameStatus{
    public static int turn;
    private State status;
    private GameObject objek;
    public GameStatus(){
        GameStatus.turn = 1;
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
            this.status = new Shuffle();
        }
    }
    public void execute(){
        this.status.execute(this.objek);
    }

    public void saveState(String folder, String Ext) throws IOException {
        Path path = Paths.get("src/main/resources/" + folder);

        try {
            Files.createDirectories(path);
            System.out.println("Directory created successfully.");
        } catch (IOException e) {
            System.err.println("Failed to create directory: " + e.getMessage());
        }

        objek.getPlayer1().save(folder + "/player1." + Ext);
        objek.getPlayer2().save(folder + "/player2." + Ext);
        objek.geToko().save(folder + "/gamestate." + Ext);
    }
    public void loadState(String folder, String Ext) throws IOException {
        if (folder.length() == 0){
            objek.getPlayer1().load("player1." + Ext);
            objek.getPlayer2().load("player2." + Ext);
            objek.geToko().load("gamestate." + Ext);
        } else {
            objek.getPlayer1().load(folder + "/player1." + Ext);
            objek.getPlayer2().load(folder + "/player2." + Ext);
            objek.geToko().load(folder + "/gamestate." + Ext);
        }

    }
    public State getStatus() {
    return status;
    }
    public GameObject  getObjek(){
        return objek;
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
