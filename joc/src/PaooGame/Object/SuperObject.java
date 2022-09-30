package PaooGame.Object;
import PaooGame.Entity.Entity;
import PaooGame.Game;
import PaooGame.Tiles.Tile;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    public BufferedImage img;
    protected double worldX, worldY;
    public String name;
    public int hp;
    public boolean isDestroyed = false;
    public int type;

    public void Update(){
    }
    public void Draw(Graphics g){
        double screenX = worldX - Game.getInstance().getPlayer().getX() + Game.getInstance().getPlayer().draw_x;
        double screenY = worldY - Game.getInstance().getPlayer().getY() + Game.getInstance().getPlayer().draw_y;

        g.drawImage(img, (int) (screenX), (int) (screenY), Tile.TILE_WIDTH, Tile.TILE_HEIGHT, null);
    }
    public boolean IsSolid(){
        return false;
    }
    public void collision(Entity entity) {
    }
    public BufferedImage getImg(){
        return img;
    }
    public double getX(){ return worldX;}
    public double getY(){ return worldY;}
    public void setX(double x){worldX = x;}
    public void setY(double y){worldY = y;}
}
