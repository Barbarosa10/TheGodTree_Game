package PaooGame.State;

import PaooGame.DataBase.DataBase;
import PaooGame.Game;
import PaooGame.Map.Level;

public class LoadState extends State{
    public void update(Context context) {
        DataBase db = new DataBase();
        db.LoadGame();
        db.close();
        context.setState(Game.getInstance().getStart());
    }

}
