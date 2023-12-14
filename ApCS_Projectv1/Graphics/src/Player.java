import processing.core.PApplet;

public class Player {
    private int x;
    private int y;
    private int x2;
    private int y2;
    private int x3;
    private int y3;
   private int xSpeed;
    private int ySpeed;
   private int elixerValue;
    private int health;
    private int counter;

    public Player(int xSpeed, int ySpeed, int elixerValue, int health, PApplet window) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.elixerValue = elixerValue;
        this.health = health;
        counter = 0;
    }

    public void draw(PApplet window) {
        window.fill(0);
        window.ellipse(x, y, 50, 50);
        window.ellipse(x2, y2, 50, 50);
        window.ellipse(x3, y3, 50, 50);
    }

    public void keyIsPressed(String key1, PApplet window) {


            if (key1 == "1") {
                x = window.mouseX;
                y = window.mouseY;
                window.fill(0);
                window.ellipse(x, y, 50, 50);
                counter++;
            }
            if (key1 == "2") {
                x2 = window.mouseX;
                y2 = window.mouseY;
                window.fill(255);
                window.ellipse(x2, y2, 50, 50);
                counter++;
            }
            if (key1 == "3") {
                x3 = window.mouseX;
                y3 = window.mouseY;
                window.fill(0, 125, 125);
                window.ellipse(x3, y3, 50, 50);
                counter++;
            }
        }

/*    public static double calcDist(double bridgeEnd){


    }*/

}
