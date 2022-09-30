package PaooGame.Object;
import PaooGame.Entity.Entity;
import PaooGame.Game;
import PaooGame.Graphics.Assets;
import java.awt.*;

import static PaooGame.Map.Level.maxTree;

public class Obj_Tree extends SuperObject{
    int width, height;
    public Obj_Tree(int type, int width, int height){
        name = "tree";
        this.width = width;
        this.height = height;
        this.type = type;
        if(type == 0)
            img = Assets.trees[0];
        else
            img = Assets.trees[1];
        hp = 1;
    }

    @Override
    public void Draw(Graphics g){
        double screenX = worldX - Game.getInstance().getPlayer().getX() + Game.getInstance().getPlayer().draw_x;
        double screenY = worldY - Game.getInstance().getPlayer().getY() + Game.getInstance().getPlayer().draw_y;

        g.drawImage(img, (int) (screenX), (int) (screenY), width, height, null);
    }

    @Override
    public boolean IsSolid(){
        return true;
    }

    @Override
    public void collision(Entity entity) {
        entity.setCollision(false);
        if(entity.name == "player") {
            if(type == 0) {
                isDestroyed = true;
                entity.treesNumber += 1;
            }
            else {
                if (type == 1) {
                    if (Game.getInstance().getPlayer().treesNumber == maxTree)
                        isDestroyed = true;
                }
            }

        }
    }
}