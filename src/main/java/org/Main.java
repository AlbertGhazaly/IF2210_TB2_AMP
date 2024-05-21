package org;

import gameobject.GameObject;
import gamestatus.GameStatus;
import toko.Toko;

public class Main {
    public static void main(String[] args) {
        GameObject objek = new GameObject();
        try{
            objek.geToko().load("gamestate.txt");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(GameStatus.turn);

    }
}
