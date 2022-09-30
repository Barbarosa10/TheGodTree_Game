package PaooGame.Entity;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Entity {
    public double screenX;
    public double screenY;
    protected double worldX;
    protected double worldY;
    protected double worldX0;
    protected double worldY0;
    protected double speed;
    double speed0;
    public String direction = "";
    public String name = "";
    protected int spriteNumber = 1;
    protected int spriteCounter = 0;
    public Rectangle solidArea;
    protected boolean collisionOn = false;
    int start = 0;
    int stop = 1;
    public boolean isDestroyed = false;
    public PlayerVelocity velocity;
    BufferedImage img = null;
    double magnitude = 1;
    int hp;
    public int keysNumber = 0;
    public int treesNumber = 0;

    public Entity(int start, int solidArea_x, int solidArea_y, int solidArea_width, int solidArea_height){

        velocity = new PlayerVelocity();
        this.start = start;
        solidArea = new Rectangle();
        solidArea.x = solidArea_x;
        solidArea.y = solidArea_y;
        solidArea.width = solidArea_width;
        solidArea.height = solidArea_height;

    }
    public int getHp(){
        return hp;
    }
    public void increaseHp(int inc){
        hp += inc;
    }
    public double getX(){return worldX;}
    public double getY(){return  worldY;}
    public double getSpeed(){return speed;}
    public void setX(double x){worldX = x;}
    public void setY(double y){worldY = y;}
    public boolean getCollision(){return collisionOn;}
    public void setCollision(boolean col){collisionOn = col;}


}
