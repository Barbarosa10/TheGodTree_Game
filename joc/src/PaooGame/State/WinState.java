package PaooGame.State;

import PaooGame.DataBase.DataBase;
import PaooGame.Game;

public class WinState extends State{
    public void update(Context context) {
        DataBase db = new DataBase();
        db.LoadHighScore();
        if(Game.getInstance().getUi().playTime < Game.getInstance().getUi().HighScore) {
            Game.getInstance().getUi().HighScore = Game.getInstance().getUi().playTime;
            db.SaveHighScore();
        }
        db.close();
        winGame = false;
    }
    public void setWinGame(){winGame = true;}
}
