package PaooGame;

import PaooGame.GameWindow.GameWindow;

public class Main
{
    public static void main(String[] args)
    {
        Game paooGame = Game.getInstance("The God Tree", 12*64, 9*64); //1920
        paooGame.StartGame();
    }
}
