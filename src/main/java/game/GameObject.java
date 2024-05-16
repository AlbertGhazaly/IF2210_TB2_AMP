package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import player.*;
import card.*;

public class GameObject {
    private Player player1;
    private Player player2;

    public GameObject() {
        player1 = new Player();
        player2 = new Player();
    }

}
