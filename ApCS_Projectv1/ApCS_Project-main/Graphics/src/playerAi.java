import processing.core.PApplet;

import static java.awt.SystemColor.window;

public class playerAi extends Player {
    public playerAi(int xSpeed, int ySpeed, int elixerValue, int health, PApplet window) {
        super(xSpeed, ySpeed, elixerValue, health, window);
        giant = window.loadImage("giant.png");
        skeleton = window.loadImage("skeleton.png");
        hogrider = window.loadImage("hogrider.png");
    }
    public void randomlyPlaced(PApplet window) {
        if (!isPlaced) {
            int someX = (int) (Math.random() * 800);
            int someY = (int) (Math.random() * 325);
            int randomPlayer = (int) (Math.random() * 3);
            if (randomPlayer == 0) {
                x = someX;
                y = someY;
                window.image(skeleton, x, y);
                whatImage = skeleton;
                isPlaced = true;

            }
            if (randomPlayer == 1) {
                x = someX;
                y = someY;
                window.image(hogrider, x, y);
                whatImage = hogrider;
                isPlaced = true;
            }
            if (randomPlayer == 2) {
                x = someX;
                y = someY;
                window.image(giant, x, y);
                whatImage = giant;
                isPlaced = true;

            }
        }
    }
    public void draw(PApplet window) {

        if(isPlaced) {

            while(x > 420 && x< 380  && y < 670 && y < 700){
                moveAttackerAi();
            }
            window.fill(0);
            whatImage.resize(50,50);
            window.image(whatImage, x,y);

        }
    }
    public void moveAttackerAi(){
    if(x > 400){
        x -= xSpeed;

    } else if (x < 400) {
        x += xSpeed;
    } else if (y < 670 /* 580 is the y value to stop on */ ) {
        y += ySpeed;
    }
}
    public int attackTowerAi(){
        if (y == 671){
            health = health -2;
            return 1;
        }else if(y == 672){
            health = health -2;
            return 1;
        }else if(y == 670){
            health = health -2;
            return 1;
        }
        return 0;
    }
}
