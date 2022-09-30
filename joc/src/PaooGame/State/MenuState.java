package PaooGame.State;

import PaooGame.DataBase.DataBase;
import PaooGame.Game;
import PaooGame.Map.Level;

public class MenuState extends State{
    public void update(Context context) {
        DataBase db = new DataBase();
        db.loadLevel(Level.level);
        db.SaveGame();
        db.close();
        context.setState(Game.getInstance().getMenu());
    }
}
