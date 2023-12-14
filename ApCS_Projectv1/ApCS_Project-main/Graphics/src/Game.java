import processing.core.PApplet;

import javax.swing.*;
import javax.xml.soap.Text;
import java.util.ArrayList;

public class Game extends PApplet {

    ArrayList<Player> playerList = new ArrayList<Player>();
    ArrayList<playerAi> playerAiList = new ArrayList<playerAi>();
    int elixer;

    int playerElixer;
    int aiPlayerTimer;
    int aiTowerHealth;
    int playerTowerHealth;

    int time = 0;
    int timerAttack = 0;
    int timerAttackAi;
    boolean isGameOver;

    public void settings() {
        size(800, 800);   // set the window size

    }

    public void setup() {
        aiPlayerTimer =0;
        elixer = 0;
        aiTowerHealth = 100;
        playerTowerHealth = 100;
        timerAttack = 0;
        timerAttackAi  = 0;
        playerElixer = 3;
        isGameOver = false;
        // TODO: initialize game variables
    }

    /***
     * Draws each frame to the screen.  Runs automatically in a loop at frameRate frames a second.
     * tick each object (have it update itself), and draw each object
     */
    public void draw() {
        if (!isGameOver) {
            time++;
            timerAttack++;
            aiPlayerTimer++;
            timerAttackAi++;
            if (keyPressed) {
                keyReleased();
            }
            randomPlaceAi();
            fill(1);

            textSize(25);
            text(aiTowerHealth, 25, 25);


            background(0, 255, 0);    // paint screen white
            //Water
            fill(0, 0, 255);
            rect(0, 325, 800, 150);

            //BrownThingy
            fill(102, 51, 0);
            rect(325, 225, 150, 350);

            //Towers

            if (isPlayerTowerPlaced(playerTowerHealth)) {
                fill(255);
                rect(325, 700, 150, 100);
            }
            if (isPlayerTowerPlaced(aiTowerHealth)) {
                fill(255);
                rect(325, 0, 150, 100);
            }


            textSize(25);
            text(aiTowerHealth, 25, 25);

            textSize(25);
            text(playerTowerHealth, 750, 780);
            //TIMER
            drawingTheMainPlayer();
            drawingTheAiPlayer();


            if (time == 160) {
                if (elixer < 10 && playerElixer < 10) {
                    elixer++;
                    playerElixer++;
                }
                time = 0;
            }

        }else{
            fill(0);

            textSize(50);
        }


        /*System.out.println(aiPlayer1.isPlaced);*/
    }


    public static void main(String[] args) {
        PApplet.main("Game");
    }
    public void keyReleased(){
        if (key == '1' && elixer >= 1) {
            playerList.add(new Player(1, 3, 1, 8, this));
            elixer--;
        }
        else if (key == '2' && elixer >= 2) {
            playerList.add(new Player(1, 2, 2, 10,this));
            elixer = elixer - 2;
        }
        else if (key == '3' && elixer >= 3) {
            playerList.add(new Player(1, 1, 3, 15,this));
            elixer = elixer - 3;
        }
        for (int i = 0; i < playerList.size(); i++) {
            playerList.get(i).keyIsPressed(this);
        }
    }

    public void randomPlaceAi(){
        int randomPlayer = (int) (Math.random()*3);
        if ( playerElixer >= 3){
            if (randomPlayer == 2){
                playerAiList.add(new playerAi(1,1,3,15, this));
                playerElixer = playerElixer -3;
            }
            if (randomPlayer == 1){
                playerAiList.add(new playerAi(1,2,2,10, this));
                playerElixer = playerElixer -2;
            }
            if (randomPlayer == 0){
                playerAiList.add(new playerAi(1,3,1,9, this));
                playerElixer = playerElixer -3;
            }
        }
        for (int i = 0; i < playerAiList.size(); i++) {
            playerAiList.get(i).randomlyPlaced(this);
        }
    }
    public void drawingTheMainPlayer(){
        for (int i = 0; i < playerList.size(); i++) {

            playerList.get(i).draw(this);
            playerList.get(i).moveAttacker();

        }
        for (int i = 0; i < playerList.size();) {
            if (timerAttack >= 15){
                aiTowerHealth = aiTowerHealth - playerList.get(i).attackTower();
                timerAttack = 0;
            }
            if (!playerList.get(i).isPlayerDead()) playerList.remove(i); break;
        }
    }
    public void drawingTheAiPlayer(){
        for (int i = 0; i < playerAiList.size(); i++) {
            playerAiList.get(i).draw(this);
            playerAiList.get(i).moveAttackerAi();
        }
        for (int i = 0; i < playerAiList.size();) {
            if (timerAttackAi >= 15){
                playerTowerHealth = playerTowerHealth - playerAiList.get(i).attackTowerAi();
                timerAttackAi = 0;
            }
            if (!playerAiList.get(i).isPlayerDead()) playerAiList.remove(i); break;
        }
    }
    public boolean isPlayerTowerPlaced(int tower){
        if (tower > 0){
            isGameOver = true;
             return true;
        }
        return false;
    }

}

