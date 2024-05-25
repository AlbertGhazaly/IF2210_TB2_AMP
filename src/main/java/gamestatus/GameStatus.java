package gamestatus;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import entity.Entity;
import entity.saveloadJSON;
import entity.saveloadXML;
import state.*;
import gameobject.GameObject;
import toko.*;
public class GameStatus{
    public static int turn;
    private State status;
    private GameObject objek;
    private Entity saveload;
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


        if(Ext.equals("txt")) {
            objek.getPlayer1().save(folder + "/player1." + Ext);
            objek.getPlayer2().save(folder + "/player2." + Ext);
            objek.geToko().save(folder + "/gamestate." + Ext);

        } else if (Ext.equals("xml")){
            saveload = new saveloadXML();
            saveload.save(folder);
        } else if (Ext.equals("json")){
            saveload = new saveloadJSON();
            saveload.save(folder);
        }
    }
    public void loadState(String folder, String Ext) throws IOException {
        System.out.println("Ext: "+Ext);
        if(Ext.equals("txt")) {
            objek.getPlayer1().load(folder + "/player1." + Ext);
            objek.getPlayer2().load(folder + "/player2." + Ext);
            objek.geToko().load(folder + "/gamestate." + Ext);
            System.out.println("Player1 deck: "+objek.getPlayer1().getDeck().getAktifSize());
            System.out.println("Player ladang1: "+objek.getPlayer1().getPetakLadang().getNEff());

        } else if (Ext.equals("xml")){
            saveload = new saveloadXML();
            saveload.load(folder);
        } else if (Ext.equals("json")){
            saveload = new saveloadJSON();
            saveload.load(folder);
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
