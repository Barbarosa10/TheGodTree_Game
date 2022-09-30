package PaooGame;

import PaooGame.DataBase.DataBase;
import PaooGame.Graphics.Assets;
import PaooGame.State.Context;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class UserInterface {
    private Game game;
    private Font arial_40;
    private BufferedImage keyImg;
    private BufferedImage treeImg;
    private BufferedImage[] lifeImg;
    int command = 0;
    public int playTime = 0;
    public int HighScore = Integer.MAX_VALUE;
    static int counter = 0;
    private Graphics g;

    public UserInterface() {
        this.game = Game.getInstance();
        arial_40 = new Font("Arial", Font.CENTER_BASELINE, 27);

        keyImg = Assets.keys;
        treeImg = Assets.trees[1];
        lifeImg = Assets.life;
        g = game.getGraphics();

    }
    public void Draw(Graphics g){
        this.g = g;
        this.g.setFont(new Font("Serif", Font.ITALIC, 40));
        this.g.setColor(Color.white);

        if(Game.getInstance().getContext().getState() == Game.getInstance().getStart()){
            DrawPlayState();
        }
        if(Game.getInstance().getContext().getState() == Game.getInstance().getMenu()){
            DrawTitleState();
        }
        if(Game.getInstance().getContext().getState() == Game.getInstance().getPause()){
            DrawPauseState();
        }
        if(Game.getInstance().getContext().getState() == Game.getInstance().getAbout()){
            DrawAboutState();
        }
        if(Game.getInstance().getContext().getState() == Game.getInstance().getLost()){
            DrawLoseState();
        }
        if(Game.getInstance().getContext().getState() == Game.getInstance().getNextLevel())
            DrawNextLevelState();
        if(Game.getInstance().getContext().getState() == Game.getInstance().getWin())
            DrawWinState();
    }
    private void DrawTitleState(){
        g.setFont(g.getFont().deriveFont(Font.ITALIC, 50));
        int x = getXforText("The God Tree");
        int y = Tile.TILE_HEIGHT * 2;

        //shadow
        g.setColor(Color.black);
        g.drawString("The God Tree", x + 5, y + 5);
        //main color
        g.setColor(Color.white);
        g.drawString("The God Tree", x, y);

        g.drawImage(Assets.trees[1], game.GetWnd().GetWndWidth() / 2 - Tile.TILE_WIDTH - Tile.TILE_WIDTH/2, Tile.TILE_HEIGHT * 2 + 20, 64*3, 64*3, null);
        g.setFont(g.getFont().deriveFont(Font.ITALIC, 30));
        //new game
        x = getXforText("New Game");
        y = Tile.TILE_HEIGHT * 6;
        if(command == 0){
            g.setColor(Color.black);
            g.drawString("New Game", x, y);
        }
        else{
            g.setColor(Color.white);
            g.drawString("New Game", x, y);
        }
        //load game
        x = getXforText("New Game");
        y += 40;
        if(command == 1){
            g.setColor(Color.black);
            g.drawString("Load Game", x, y);
        }
        else{
            g.setColor(Color.white);
            g.drawString("Load Game", x, y);
        }
        //About
        x = getXforText("About");
        y += 40;
        if(command == 2){
            g.setColor(Color.black);
            g.drawString("About", x, y);
        }
        else{
            g.setColor(Color.white);
            g.drawString("About", x, y);
        }
        //exit
        x = getXforText("Exit");
        y += 40;
        if(command == 3){
            g.setColor(Color.black);
            g.drawString("Exit", x, y);
        }
        else{
            g.setColor(Color.white);
            g.drawString("Exit", x, y);
        }

    }
    private void DrawPlayState(){
        g.setFont(arial_40);
        g.setColor(Color.white);
        g.drawImage(keyImg, Tile.TILE_WIDTH/2, Tile.TILE_HEIGHT/2, Tile.TILE_WIDTH -24, Tile.TILE_HEIGHT - 24, null);
        g.drawString("x " + game.getPlayer().keysNumber, 75, 63);
        g.drawImage(treeImg, Tile.TILE_WIDTH/2, Tile.TILE_HEIGHT + 28, Tile.TILE_WIDTH-16, Tile.TILE_HEIGHT-16, null);
        g.drawString("x " + game.getPlayer().treesNumber, 75, 63*2);

        //DrawLife
        g.drawImage(lifeImg[Math.max(game.getPlayer().getHp(), 0)],  game.GetWnd().GetWndWidth() - Tile.TILE_WIDTH*4 + 32, Tile.TILE_HEIGHT + 16, Tile.TILE_WIDTH*3, Tile.TILE_HEIGHT, null);

        //DrawTime

        playTime += 1;
        System.out.println(playTime);
        int counter = playTime/60;
        g.drawString("Time:  " + counter / 60 + ":" + counter % 60, game.GetWnd().GetWndWidth() - Tile.TILE_WIDTH*4 + 32, Tile.TILE_HEIGHT);
    }
    private void DrawPauseState(){
        g.setFont(g.getFont().deriveFont(Font.ITALIC, 50));
        int x = getXforText("The God Tree");
        int y = Tile.TILE_HEIGHT * 2;

        //shadow
        g.setColor(Color.black);
        g.drawString("The God Tree", x + 5, y + 5);
        //main color
        g.setColor(Color.white);
        g.drawString("The God Tree", x, y);

        g.setFont(g.getFont().deriveFont(Font.ITALIC, 30));
        //resume game
        x = getXforText("Resume Game");
        y = game.GetWnd().GetWndHeight() / 2 - Tile.TILE_HEIGHT/2;
        if(command == 0){
            g.setColor(Color.black);
            g.drawString("Resume Game", x, y);
        }
        else{
            g.setColor(Color.white);
            g.drawString("Resume Game", x, y);
        }
        //save game
        x = getXforText("Save Game");
        y += 40;
        if(command == 1){
            g.setColor(Color.black);
            g.drawString("Save Game", x, y);
        }
        else{
            g.setColor(Color.white);
            g.drawString("Save Game", x, y);
        }
        //back
        x = getXforText("Back");
        y += 40;
        if(command == 2){
            g.setColor(Color.black);
            g.drawString("Back", x, y);
        }
        else{
            g.setColor(Color.white);
            g.drawString("Back", x, y);
        }
    }
    private void DrawNextLevelState(){
        g.setFont(g.getFont().deriveFont(Font.ITALIC, 50));
        int x = getXforText("The God Tree");
        int y = Tile.TILE_HEIGHT * 2;

        //shadow
        g.setColor(Color.black);
        g.drawString("The God Tree", x + 5, y + 5);
        //main color
        g.setColor(Color.white);
        g.drawString("The God Tree", x, y);

        g.setFont(g.getFont().deriveFont(Font.ITALIC, 40));
        x = getXforText("Congratulations!!!");
        y += 70;

        //shadow
        g.setColor(Color.black);
        g.drawString("Congratulations!!!", x + 5, y + 5);
        //main color
        g.setColor(Color.white);
        g.drawString("Congratulations!!!", x, y);

        g.setFont(g.getFont().deriveFont(Font.ITALIC, 30));
        //resume game
        x = getXforText("Next Level");
        y = game.GetWnd().GetWndHeight() / 2 - Tile.TILE_HEIGHT/2;
        if(command == 0){
            g.setColor(Color.black);
            g.drawString("Next Level", x, y);
        }
        else{
            g.setColor(Color.white);
            g.drawString("Next Level", x, y);
        }
        //save game
        x = getXforText("Menu");
        y += 40;
        if(command == 1){
            g.setColor(Color.black);
            g.drawString("Menu", x, y);
        }
        else{
            g.setColor(Color.white);
            g.drawString("Menu", x, y);
        }

    }
    private void DrawAboutState() {
        g.setFont(g.getFont().deriveFont(Font.ITALIC, 20));
        g.setColor(Color.white);
        int x = Tile.TILE_WIDTH  + 20;
        int y = Tile.TILE_HEIGHT;
        String text = "The God Tree este un joc de aventură în care player-ul trebuie să învingă inamcii";
        g.drawString(text, x, y);
        x += -20;
        y += 25;

        text = "pentru a colecționa chei cu care poate să deschidă porțile care îi stau în cale.";
        g.drawString(text, x, y);
        x += 20;
        y += 35;
        text = "Scopul jocului este ca player-ul să ajungă la The God Tree, dar prima dată el";
        g.drawString(text, x, y);
        x += -20;
        y += 25;
        text = "trebuie să colecționeze ceilalți copaci din joc, pentru avea acces la ultimul. Când";
        g.drawString(text, x, y);
        //x += -20;
        y += 25;
        text = "ultimul copac este luat, jucătorul poate trece la următorul nivel.";
        g.drawString(text, x, y);

        g.setFont(g.getFont().deriveFont(Font.ITALIC, 30));
        x += 20;
        y += 50;

        text = "Controale:";
        g.drawString(text, x, y);

        g.setFont(g.getFont().deriveFont(Font.ITALIC, 20));
        x -= 20;
        y += 30;
        text = "W -> Up";
        g.drawString(text, x, y);

        y += 30;
        text = "S -> Down";
        g.drawString(text, x, y);

        y += 30;
        text = "A -> Left";
        g.drawString(text, x, y);

        y += 30;
        text = "D -> Right";
        g.drawString(text, x, y);

        y += 30;
        text = "SPACE -> Shoot";
        g.drawString(text, x, y);

        y += 30;
        text = "SHIFT -> Sprint";
        g.drawString(text, x, y);

        y += 30;
        text = "UP_ARROW -> Up through the menu";
        g.drawString(text, x, y);

        y += 30;
        text = "DOWN_ARROW -> Down through the menu";
        g.drawString(text, x, y);

        y += 30;
        text = "ESC -> Pause game";
        g.drawString(text, x, y);

        g.setFont(g.getFont().deriveFont(Font.ITALIC, 30));
        y = game.GetWnd().GetWndHeight() - Tile.TILE_HEIGHT + 30;
        g.setColor(Color.black);
        g.drawString("Back", x, y);

    }
    private void DrawWinState(){
        g.setFont(g.getFont().deriveFont(Font.ITALIC, 50));
        int x = getXforText("The God Tree");
        int y = Tile.TILE_HEIGHT * 2;

        //shadow
        g.setColor(Color.black);
        g.drawString("The God Tree", x + 5, y + 5);
        //main color
        g.setColor(Color.white);
        g.drawString("The God Tree", x, y);

        //Text
        g.setFont(g.getFont().deriveFont(Font.ITALIC, 40));
        x = getXforText("Congratulations! You won the game.");
        y += 70;
        //shadow
        g.setColor(Color.black);
        g.drawString("Congratulations! You won the game.", x + 5, y + 5);
        //main color
        g.setColor(Color.white);
        g.drawString("Congratulations! You won the game.", x, y);

        //Score
        int counter = playTime/60;
        x = getXforText("Score: " + counter / 60 + ":" + counter % 60);
        y += 50;
        //shadow
        /*g.setColor(Color.blue);
        g.drawString("Score: " + counter / 60 + ":" + counter % 60, x + 5, y + 5);*/
        //main color
        g.setColor(Color.white);
        g.drawString("Score: " + counter / 60 + ":" + counter % 60, x, y);

        //HighScore
        if(this.counter == 0) {
            winDataBase();
            this.counter++;
        }
        counter = HighScore/60;
        x = getXforText("HighScore: " + counter / 60 + ":" + counter % 60);
        y += 50;
        //shadow
        /*g.setColor(Color.blue);
        g.drawString("HighScore: " + counter / 60 + ":" + counter % 60, x + 5, y + 5);*/
        //main color
        g.setColor(Color.white);
        g.drawString("HighScore: " + counter / 60 + ":" + counter % 60, x, y);

        g.setFont(g.getFont().deriveFont(Font.ITALIC, 30));
        //resume game
        x = getXforText("Menu");
        y += 100;
        if(command == 0){
            g.setColor(Color.black);
            g.drawString("Menu", x, y);
        }
        else{
            g.setColor(Color.white);
            g.drawString("Menu", x, y);
        }
        //save game
        x = getXforText("Exit");
        y += 40;
        if(command == 1){
            g.setColor(Color.black);
            g.drawString("Exit", x, y);
        }
        else{
            g.setColor(Color.white);
            g.drawString("Exit", x, y);
        }
    }

    private void DrawLoseState(){
        g.setFont(g.getFont().deriveFont(Font.ITALIC, 50));
        int x = getXforText("You've lost!");
        int y = Tile.TILE_HEIGHT * 2;

        //shadow
        g.setColor(Color.black);
        g.drawString("You've lost!", x + 5, y + 5);
        //main color
        g.setColor(Color.white);
        g.drawString("You've lost!", x, y);

        g.setFont(g.getFont().deriveFont(Font.ITALIC, 40));
        x = getXforText("Try again!");
        y = Tile.TILE_HEIGHT * 3;

        //shadow
        g.setColor(Color.black);
        g.drawString("Try again!", x + 5, y + 5);
        //main color
        g.setColor(Color.white);
        g.drawString("Try again!", x, y);


        g.setFont(g.getFont().deriveFont(Font.ITALIC, 30));
        //try again
        x = getXforText("Try again");
        y = game.GetWnd().GetWndHeight() / 2 - Tile.TILE_HEIGHT/2;
        if(command == 0){
            g.setColor(Color.black);
            g.drawString("Try again", x, y);
        }
        else{
            g.setColor(Color.white);
            g.drawString("Try again", x, y);
        }
        //menu
        x = getXforText("Menu");
        y += 40;
        if(command == 1){
            g.setColor(Color.black);
            g.drawString("Menu", x, y);
        }
        else{
            g.setColor(Color.white);
            g.drawString("Menu", x, y);
        }
    }
    private int getXforText(String text){
        int len = (int)g.getFontMetrics().getStringBounds(text, g).getWidth();
        int x = game.GetWnd().GetWndWidth() / 2 - len / 2;

        return x;
    }
    private void winDataBase(){
        DataBase db = new DataBase();
        db.LoadHighScore();
        db.close();
    }



}
