package PaooGame.State;

public class PauseState extends State{
    public void update(Context context) {
        context.setState(this);
    }

}
