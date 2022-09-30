package PaooGame.State;

import PaooGame.DataBase.DataBase;

public class SaveState extends State{
    public void update(Context context) {
        DataBase db = new DataBase();
        db.SaveGame();
        db.close();
    }
}
