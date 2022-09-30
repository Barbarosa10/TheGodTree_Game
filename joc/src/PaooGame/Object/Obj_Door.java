package PaooGame.Object;
import PaooGame.Entity.Entity;
import PaooGame.Game;
import PaooGame.Graphics.Assets;

public class Obj_Door extends SuperObject{

    public Obj_Door(int type){
        this.type = type;
        name = "door";
        if(type == 0) {
            img = Assets.doors[0]; //vertical
        }
        else {
            img = Assets.doors[1]; //orizontal
        }
        hp = 50;
    }
    @Override
    public void Update(){
        if(hp <= 0)
            isDestroyed = true;

    }
    @Override
    public boolean IsSolid(){
        return true;
    }

    @Override
    public void collision(Entity entity) {
        if(entity.name == "projectile") {
            if (Game.getInstance().getPlayer().keysNumber > 0) {
                hp -= 50;
                Game.getInstance().getPlayer().keysNumber--;
            }
        }

    }
}
