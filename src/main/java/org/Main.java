package org;

import card.Item;
import entity.saveloadJSON;
import entity.saveloadXML;
import gameobject.GameObject;
import gamestatus.GameStatus;
import toko.Toko;

public class Main {
    public static void main(String[] args) {
        GameStatus gameStatus = new GameStatus();
        saveloadXML saveload = new saveloadXML();
        saveload.setGameStatus(gameStatus);
        try{
            gameStatus.loadState("tes", "txt");
            saveload.save("andi");
            saveload.load("andi");
            gameStatus.saveState("alan", "txt");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(gameStatus.getObjek().getPlayer1().getPetakLadang().getPetakLadang().get(0).size());

//        System.out.println(GameStatus.turn);
//
//        System.out.println(gameStatus.getObjek().getPlayer1().getGulden());
//
//        try{
//            System.out.println(gameStatus.getObjek().getPlayer1().getDeck().getAktifElement(0).getName());
//            System.out.println(gameStatus.getObjek().getPlayer1().getPetakLadang().getElement(0,0).getKartu().getName());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        try{
////            gameStatus.getObjek().getPlayer1().load("player1.txt");
//            gameStatus.saveState("", "txt");
//        } catch (Exception e){
//            e.printStackTrace();
//        }

    }
}
