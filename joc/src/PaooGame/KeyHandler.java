package PaooGame;
import PaooGame.DataBase.DataBase;
import PaooGame.Map.Level;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean WPressed = false;
    public boolean SPressed = false;
    public boolean DPressed = false;
    public boolean APressed = false;
    public boolean ShiftPressed = false;
    public boolean SpacePressed = false;
    public int increase = 0;
    public int stop = 0;
    private Game game;

    public KeyHandler(Game game){
        this.game = game;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key_code = e.getKeyCode();

        if(Game.getInstance().getContext().getState() == Game.getInstance().getMenu()){
            switch(key_code){
                case KeyEvent.VK_W:
                    game.getUi().command --;
                    if(game.getUi().command < 0)
                        game.getUi().command = 3;
                    break;
                case KeyEvent.VK_S:
                    game.getUi().command ++;
                    if(game.getUi().command > 3)
                        game.getUi().command = 0;
                    break;
                case KeyEvent.VK_UP:
                    game.getUi().command --;
                    if(game.getUi().command < 0)
                        game.getUi().command = 3;
                    break;
                case KeyEvent.VK_DOWN:
                    game.getUi().command ++;
                    if(game.getUi().command > 3)
                        game.getUi().command = 0;
                    break;
                case KeyEvent.VK_ENTER:
                    if(game.getUi().command == 0) {
                        Game.getInstance().getStart().doAction(Game.getInstance().getContext());
                    }
                    if(game.getUi().command == 1 && Level.level < 3){
                        //loadGame
                        Game.getInstance().getLoad().update(Game.getInstance().getContext());
                    }
                    if(game.getUi().command == 2){
                        Game.getInstance().getContext().setState(Game.getInstance().getAbout());
                    }
                    if(game.getUi().command == 3) {
                        System.exit(0);
                        break;
                    }
                default:

            }
        }
        else if(Game.getInstance().getContext().getState() == Game.getInstance().getPause()){
            switch(key_code){
                case KeyEvent.VK_W:
                    game.getUi().command --;
                    if(game.getUi().command < 0)
                        game.getUi().command = 2;
                    break;
                case KeyEvent.VK_S:
                    game.getUi().command ++;
                    if(game.getUi().command > 2)
                        game.getUi().command = 0;
                    break;
                case KeyEvent.VK_UP:
                    game.getUi().command --;
                    if(game.getUi().command < 0)
                        game.getUi().command = 2;
                    break;
                case KeyEvent.VK_DOWN:
                    game.getUi().command ++;
                    if(game.getUi().command > 2)
                        game.getUi().command = 0;
                    break;
                case KeyEvent.VK_ENTER:
                    //resume
                    if(game.getUi().command == 0)
                        Game.getInstance().getContext().setState(Game.getInstance().getStart());
                    //save game
                    if(game.getUi().command == 1){
                        //saveGame
                        Game.getInstance().getSave().update(Game.getInstance().getContext());
                    }
                    //back
                    if(game.getUi().command == 2)
                        Game.getInstance().getContext().setState(Game.getInstance().getMenu());
                    break;
                case KeyEvent.VK_ESCAPE:
                    Game.getInstance().getContext().setState(Game.getInstance().getStart());
                    break;

                default:
            }
        }else if(Game.getInstance().getContext().getState() == Game.getInstance().getLost()){
            switch(key_code){
                case KeyEvent.VK_W:
                    game.getUi().command --;
                    if(game.getUi().command < 0)
                        game.getUi().command = 1;
                    break;
                case KeyEvent.VK_S:
                    game.getUi().command ++;
                    if(game.getUi().command > 1)
                        game.getUi().command = 0;
                    break;
                case KeyEvent.VK_UP:
                    game.getUi().command --;
                    if(game.getUi().command < 0)
                        game.getUi().command = 1;
                    break;
                case KeyEvent.VK_DOWN:
                    game.getUi().command ++;
                    if(game.getUi().command > 1)
                        game.getUi().command = 0;
                    break;
                case KeyEvent.VK_ENTER:
                    //try again
                    if(game.getUi().command == 0) {
                        Game.getInstance().getTryAgain().update(Game.getInstance().getContext());
                    }
                    //menu
                    if(game.getUi().command == 1){
                        Game.getInstance().getContext().setState(Game.getInstance().getMenu());
                    }
                    break;
                default:
            }

        }
        else if(Game.getInstance().getContext().getState() == Game.getInstance().getNextLevel()){
            switch(key_code){
                case KeyEvent.VK_W:
                    game.getUi().command --;
                    if(game.getUi().command < 0)
                        game.getUi().command = 1;
                    break;
                case KeyEvent.VK_S:
                    game.getUi().command ++;
                    if(game.getUi().command > 1)
                        game.getUi().command = 0;
                    break;
                case KeyEvent.VK_UP:
                    game.getUi().command --;
                    if(game.getUi().command < 0)
                        game.getUi().command = 1;
                    break;
                case KeyEvent.VK_DOWN:
                    game.getUi().command ++;
                    if(game.getUi().command > 1)
                        game.getUi().command = 0;
                    break;
                case KeyEvent.VK_ENTER:
                    //nextLevel
                    if(game.getUi().command == 0) {
                        Game.getInstance().getNextLevel().doAction(Game.getInstance().getContext());
                    }
                    //menu
                    if(game.getUi().command == 1){
                        Game.getInstance().getMenu().update(Game.getInstance().getContext());
                    }
                    break;
                default:
            }
        }
        else if(Game.getInstance().getContext().getState() == Game.getInstance().getAbout()){
            if(key_code == KeyEvent.VK_ESCAPE){
                Game.getInstance().getContext().setState(Game.getInstance().getMenu());
            }
            else if(key_code == KeyEvent.VK_ENTER){
                Game.getInstance().getContext().setState(Game.getInstance().getMenu());
            }
        }
        else if(Game.getInstance().getContext().getState() == Game.getInstance().getMenu()){
            switch(key_code){
                case KeyEvent.VK_W:
                    game.getUi().command --;
                    if(game.getUi().command < 0)
                        game.getUi().command = 1;
                    break;
                case KeyEvent.VK_S:
                    game.getUi().command ++;
                    if(game.getUi().command > 1)
                        game.getUi().command = 0;
                    break;
                case KeyEvent.VK_UP:
                    game.getUi().command --;
                    if(game.getUi().command < 0)
                        game.getUi().command = 1;
                    break;
                case KeyEvent.VK_DOWN:
                    game.getUi().command ++;
                    if(game.getUi().command > 1)
                        game.getUi().command = 0;
                    break;
                case KeyEvent.VK_ENTER:
                    //Menu
                    if(game.getUi().command == 0) {
                        Game.getInstance().getContext().setState(Game.getInstance().getMenu());
                        UserInterface.counter = 0;
                    }
                    //Exit
                    if(game.getUi().command == 1){
                        System.exit(0);
                    }
                    break;
                default:
            }
        }

        else if(Game.getInstance().getContext().getState() == Game.getInstance().getStart()) {
            switch (key_code) {
                case KeyEvent.VK_W: {
                    if (!WPressed) {
                        WPressed = true;
                        Game.getInstance().getPlayer().velocity.y -= 1;
                    }
                    break;
                }
                case KeyEvent.VK_S: {
                    if (!SPressed) {
                        SPressed = true;
                        Game.getInstance().getPlayer().velocity.y += 1;
                    }
                    break;
                }
                case KeyEvent.VK_D: {
                    if (!DPressed) {
                        DPressed = true;
                        Game.getInstance().getPlayer().velocity.x += 1;
                    }
                    break;
                }
                case KeyEvent.VK_A: {
                    if (!APressed) {
                        APressed = true;
                        Game.getInstance().getPlayer().velocity.x -= 1;
                    }
                    break;
                }
                case KeyEvent.VK_SHIFT: {
                    if (!ShiftPressed) {
                        ShiftPressed = true;
                        increase += 1;
                    }
                    break;
                }
                case KeyEvent.VK_SPACE: {
                    if (stop == 0) {
                        SpacePressed = true;
                        stop = 1;
                    }
                    break;
                }
                case KeyEvent.VK_ESCAPE:{
                    Game.getInstance().getContext().setState(Game.getInstance().getPause());
                    break;
                }
                default:
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key_code = e.getKeyCode();
        switch (key_code) {
            case KeyEvent.VK_W: {
                if (WPressed) {
                    WPressed = false;
                    Game.getInstance().getPlayer().velocity.y += 1;
                }
                break;
            }
            case KeyEvent.VK_S: {
                if (SPressed) {
                    SPressed = false;
                    Game.getInstance().getPlayer().velocity.y -= 1;
                }
                break;
            }
            case KeyEvent.VK_D: {
                if (DPressed) {
                    DPressed = false;
                    Game.getInstance().getPlayer().velocity.x -= 1;
                }
                break;
            }
            case KeyEvent.VK_A: {
                if (APressed) {
                    APressed = false;
                    Game.getInstance().getPlayer().velocity.x += 1;
                }
                break;
            }
            case KeyEvent.VK_SHIFT: {
                if (ShiftPressed) {
                    ShiftPressed = false;
                    increase -= 1;
                }
                break;
            }
            case KeyEvent.VK_SPACE: {
                stop = 0;
                break;
            }
        }
    }
}
