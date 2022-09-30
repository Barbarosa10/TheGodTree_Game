package PaooGame.Object;
import PaooGame.Entity.Entity;
import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;
import java.awt.*;

public class Obj_Key extends SuperObject{
    public Obj_Key(){
        name = "key";
        img = Assets.keys;
        hp = 1;
    }
    @Override
    public void Draw(Graphics g){
        double screenX = worldX - Game.getInstance().getPlayer().getX() + Game.getInstance().getPlayer().draw_x;
        double screenY = worldY - Game.getInstance().getPlayer().getY() + Game.getInstance().getPlayer().draw_y;

        g.drawImage(img, (int) (screenX), (int) (screenY), Tile.TILE_WIDTH-16, Tile.TILE_HEIGHT-16, null);
    }
    @Override
    public boolean IsSolid(){
        return true;
    }

    @Override
    public void collision(Entity entity) {
        entity.setCollision(false);
        if(entity.name == "player") {
            isDestroyed = true;
            entity.keysNumber += 1;
            Game.getInstance().playSE(3);
        }
    }
}

