package PaooGame.State;

public class AboutState extends State{
    public void update(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }
}
