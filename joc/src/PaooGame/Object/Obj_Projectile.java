package PaooGame.Object;
import PaooGame.Entity.Entity;
import PaooGame.Game;
import PaooGame.Graphics.Assets;

public class Obj_Projectile extends SuperObject{
    public Obj_Projectile(int type){
        this.type = type;
        name = "projectile";
        if(type == 0) {
            img = Assets.projectiles[2]; //speed
        }
        else {
            img = Assets.projectiles[3]; //higherdamage
        }
        hp = 1;
    }
    @Override
    public boolean IsSolid(){
        return true;
    }

    @Override
    public void collision(Entity entity) {
        entity.setCollision(false);
        if(entity.name == "player") {
            if(type == 0){
                Game.getInstance().getPlayer().type = 1;
            }
            else if(type == 1){
                Game.getInstance().getPlayer().type = 2;
            }
            isDestroyed = true;
            Game.getInstance().playSE(3);
        }

    }
}
