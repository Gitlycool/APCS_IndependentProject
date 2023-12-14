import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Player {
    protected int x;
    protected int y;
    protected int xSpeed;
    protected int ySpeed;
    protected int elixerValue;
    protected int health;
    protected boolean isPlaced;
    protected PImage giant;
    protected PImage hogrider;
    protected PImage skeleton;
    protected  PImage whatImage;


    public Player(int xSpeed, int ySpeed, int elixerValue, int health, PApplet window) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.elixerValue = elixerValue;
        this.health = health;
        isPlaced = false;
        giant = window.loadImage("giant.png");
        skeleton = window.loadImage("skeleton.png");
        hogrider = window.loadImage("hogrider.png");
    }

    public void draw(PApplet window) {

        if(isPlaced) {
            while(x >= 430 && x <= 370 && y < 55 && y > 0){
                moveAttacker();
            }
            window.fill(0);
            window.image(whatImage, x,y);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int keyIsPressed(PApplet window) {
        int someX = window.mouseX;
        int someY = window.mouseY;
        if (!isPlaced) {
            if (window.key == '1' || window.key == '2' || window.key == '3') {
                if (window.key == '1') {
                    x = someX;
                    y = someY;
                    window.fill(0);
                    skeleton.resize(50,50);
                    window.image(this.skeleton,x,y);
                    whatImage = skeleton;
                    isPlaced = true;
                    return -1;

                }
                if (window.key == '2') {
                    x = someX;
                    y = someY;
                    window.fill(255);
                    this.hogrider.resize(50,50);
                    window.image(this.hogrider,x,y);
                    whatImage = hogrider;
                    isPlaced = true;
                    return -2;
                }
                if (window.key == '3') {
                    x = someX;
                    y = someY;
                    window.fill(0, 125, 125);
                    giant.resize(50,50);
                    window.image(this.giant,x,y);
                    whatImage = giant;
                    isPlaced = true;
                    return -3;
                }
            }
        }
        return 0;
    }

/*    public void moveDefender(ArrayList<playerAi> enemy){
        if (elixerValue == 3){
        int indexWhichIsClose = 0;
            for (int i = 0; i < enemy.size(); i++) {
                if (enemy.get(i).getX() <= x && enemy.get(i).getX() >= x){
                    indexWhichIsClose = i;
                }

            }
        }*/


        public void moveAttacker(){
            if(x > 400){
        x -= xSpeed;

    } else if (x < 400) {
        x += xSpeed;
    } else if (y > 120 /* 120 is the y value to stop on */ ) {
                y -= ySpeed;
            }
    }

    public int damageTower(){
        if (y < 120 && y > 0){
            health --;
        }
        return -1;
    }
    public boolean isPlayerDead(){
        if (health <= 0){
            isPlaced = false;
            return false;
        }
        return true;
    }
    public int attackTower(){
        if (y == 118){
            health = health -2;
            return 1;
        }else if(y == 119){
            health = health -2;
            return 1;
        }else if(y == 120){
            health = health -2;
            return 1;
        }
        return 0;
    }

}

 /*  public static double calcDist(double bridgeEnd){

    }*/


