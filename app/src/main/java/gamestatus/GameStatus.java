package gamestatus;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import exception.*;
import game.GameObject;
import toko.*;
public class GameStatus extends GameObject {
    private int turn;
    private Toko toko;
    
    public GameStatus(){
        super();
        this.turn = 0;
        this.toko = new Toko();
    }

    /**
     * Setter untuk atribut turn
    */
    public void nextTurn(){
        this.turn = (turn+1)%2;
    }
    /**
     * getter untuk atribut turn
     *
     * @return int turn dalam permainan.
    */
    public int getTurn(){
        return this.turn;
    }
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
    public void loadState(String path) throws IOException {
            // FileReader declare
            String filePath = GameStatus.class.getResource(path).getFile();
            FileReader fileReader = new FileReader(filePath);
             // Wrap FileReader in BufferedReader 
             BufferedReader bufferedReader = new BufferedReader(fileReader);
 
             String line;
            // Parse current turn
            line = bufferedReader.readLine();
            int currTurn = Integer.parseInt(line);
            this.turn = currTurn;
            // Parse stok toko
            line = bufferedReader.readLine();
            int nItem = Integer.parseInt(line);
            for (int i=0;i<nItem;i++){
                line = bufferedReader.readLine();
                String[] paresdStr = line.split(" ");
                this.toko.addStok(paresdStr[0], Integer.parseInt(paresdStr[1]));
            }
            // Close FileReader
             bufferedReader.close();

    }
}
