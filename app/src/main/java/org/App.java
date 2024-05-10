package org;
import deck.*;
import gamestatus.*;

import card.*;
import player.*;
import game.*;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        GameObject game = new GameObject();
        game.muatPlayer1("C:\\Users\\aland\\Desktop\\IF2210_TB2_AMP\\app\\src\\main\\java\\org\\player1.txt");
        game.printInfoPlayer1();
    }
}