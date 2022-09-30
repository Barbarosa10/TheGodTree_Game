package PaooGame.State;

import PaooGame.DataBase.DataBase;
import PaooGame.Entity.Enemy;
import PaooGame.Entity.Projectile;
import PaooGame.Game;
import PaooGame.Map.Level;
import PaooGame.Object.Obj_Heart;
import PaooGame.Object.Obj_Key;
import PaooGame.Object.SuperObject;

public class StartState extends State{
    public void update(Context context) {
        Game.getInstance().getPlayer().Update();
        for (Enemy enemy : Game.getInstance().getEnemy()) {
            enemy.Update();
        }
        for (Projectile projectile : Game.getInstance().getProjectileList())
            projectile.Update();
        for (SuperObject obj : Game.getInstance().getObjectList()) {
            obj.Update();
            if (obj.name == "tree" && obj.isDestroyed == true && obj.type == 1 && Level.maxTree == Game.getInstance().getPlayer().treesNumber)
                context.setState(Game.getInstance().getNextLevel());
            //Game.getInstance().gameState = Game.getInstance().nextLevelState;
        }
        remove();
        //context.setState(this);
    }
    public void doAction(Context context){
        DataBase db = new DataBase();
        Level.level = 1;
        db.loadLevel(1);
        db.SaveGame();
        db.close();
        context.setState(Game.getInstance().getStart());
    }
    public void Draw(){
        Game.getInstance().getLevel().Draw();

        for(int i = 0; i <Game.getInstance().getObjectList().size(); i++)
            Game.getInstance().getObjectList().get(i).Draw(Game.getInstance().getGraphics());
        for(int i = 0; i < Game.getInstance().getProjectileList().size(); i++)
            Game.getInstance().getProjectileList().get(i).Draw(Game.getInstance().getGraphics());
        for(int i = 0; i < Game.getInstance().getEnemy().size(); i++)
            Game.getInstance().getEnemy().get(i).Draw(Game.getInstance().getGraphics());

        Game.getInstance().getPlayer().Draw(Game.getInstance().getGraphics());
        Game.getInstance().getUi().Draw(Game.getInstance().getGraphics());
    }

    private void remove(){
        for(int i = 0; i < Game.getInstance().getEnemy().size(); i++) {
            if (Game.getInstance().getEnemy().get(i).isDestroyed == true && Game.getInstance().getEnemy().get(i).type == 0) {
                if (Game.getInstance().getObjectList().size() >= 0) {
                    Game.getInstance().getObjectList().add(new Obj_Key());
                    Game.getInstance().getObjectList().get(Game.getInstance().getObjectList().size() - 1).setX(Game.getInstance().getEnemy().get(i).getX()) ;
                    Game.getInstance().getObjectList().get(Game.getInstance().getObjectList().size() - 1).setY(Game.getInstance().getEnemy().get(i).getY()) ;
                }
                Game.getInstance().getEnemy().remove(i);
            }
            else if (Game.getInstance().getEnemy().get(i).isDestroyed == true && Game.getInstance().getEnemy().get(i).type == 1) {
                if (Game.getInstance().getObjectList().size() >=0) {
                    Game.getInstance().getObjectList().add(new Obj_Heart());
                    Game.getInstance().getObjectList().get(Game.getInstance().getObjectList().size() - 1).setX(Game.getInstance().getEnemy().get(i).getX()) ;
                    Game.getInstance().getObjectList().get(Game.getInstance().getObjectList().size() - 1).setY(Game.getInstance().getEnemy().get(i).getY()) ;
                }
                Game.getInstance().getEnemy().remove(i);
            }
        }


        for(int i = 0; i < Game.getInstance().getProjectileList().size(); i++)
            if(Game.getInstance().getProjectileList().get(i).isDestroyed == true)
                Game.getInstance().getProjectileList().remove(i);
        for(int i = 0; i <Game.getInstance().getObjectList().size(); i++)
            if(Game.getInstance().getObjectList().get(i).isDestroyed == true)
                Game.getInstance().getObjectList().remove(i);


    }
}
