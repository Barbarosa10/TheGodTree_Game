package PaooGame.State;

public abstract class State {
    boolean nextLevel = false;
    boolean winGame = false;
    public void update(Context context){}
    public void setWinGame(){}
    public void doAction(Context context){}
}
