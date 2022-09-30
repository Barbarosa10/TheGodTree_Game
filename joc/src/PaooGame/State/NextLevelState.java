package PaooGame.State;

import PaooGame.DataBase.DataBase;
import PaooGame.Game;
import PaooGame.Map.Level;

public class NextLevelState extends State{
    public void update(Context context) {
        Level.level += 1;
        if(!(Level.level < 3)) {
            context.setState(Game.getInstance().getWin());
            //Game.getInstance().gameState = Game.getInstance().winGameState;
            Game.getInstance().getWin().setWinGame();
        }
        nextLevel = false;
        //context.setState(this);
    }


    public void doAction(Context context){
        DataBase db = new DataBase();
        db.loadLevel(Level.level);
        db.SaveGame();
        db.close();
        context.setState(Game.getInstance().getStart());
    }
}
