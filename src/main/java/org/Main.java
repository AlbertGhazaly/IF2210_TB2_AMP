package org;

import gameobject.GameObject;
import gamestatus.GameStatus;
import toko.Toko;

public class Main {
    public static void main(String[] args) {
        GameObject objek = new GameObject();
        try{
            objek.geToko().load("gamestate.txt");
            objek.getPlayer1().load("player1.txt");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(GameStatus.turn);

        System.out.println(objek.getPlayer1().getGulden());

        try{
            System.out.println(objek.getPlayer1().getDeck().getAktifElement(0).getName());
            System.out.println(objek.getPlayer1().getPetakLadang().getElement(0,0).getKartu().getName());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
