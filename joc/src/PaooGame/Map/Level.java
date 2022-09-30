package PaooGame.Map;
import PaooGame.Tiles.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import PaooGame.Entity.Player;
import PaooGame.Game;
import static PaooGame.Map.MapLoader.*;

public class Level {
    public static int level = 1;
    public static MapLoader lv = new MapLoader();
    public static int maxTree;
    public static String path_lv = "/Maps/map1.txt";

    public Level(){

        if(level == 1) {
            lv.Load(path_lv);
            maxTree = 6;
        }
        else if(level == 2){
            path_lv =  "/Maps/map2.txt";
            lv.Load(path_lv);
            maxTree = 6;
        }

    }
    public static void setLevel(int lev){

        level = lev;
        if(level == 1) {
            path_lv =  "/Maps/map1.txt";
            lv.Load(path_lv);
            maxTree = 6;
        }
        else if(level == 2){
            path_lv =  "/Maps/map2.txt";
            lv.Load(path_lv);
            maxTree = 7;
        }
    }
    public void Draw() {

        for(int worldRow = 0; worldRow < MapLoader.maxWorldRow; worldRow++)
            for(int worldCol = 0; worldCol < MapLoader.maxWorldCol; worldCol++) {
                //Camera
                int worldX = worldCol * Tile.TILE_WIDTH;
                int worldY = worldRow * Tile.TILE_HEIGHT;
                double screenX = worldX - Game.getInstance().getPlayer().getX() + Game.getInstance().getPlayer().screenX;
                double screenY = worldY - Game.getInstance().getPlayer().getY() + Game.getInstance().getPlayer().screenY;

                //Stop moving camera at the edge of the screen
                if(Game.getInstance().getPlayer().screenX > Game.getInstance().getPlayer().getX())
                    screenX = worldX;
                if(Game.getInstance().getPlayer().screenY > Game.getInstance().getPlayer().getY())
                    screenY = worldY;
                if(WorldWidth - Game.getInstance().getPlayer().getX() < Game.getInstance().GetWnd().GetWndWidth() - Game.getInstance().getPlayer().screenX)
                    screenX = Game.getInstance().GetWnd().GetWndWidth() - (WorldWidth - worldX);
                if(WorldHeight - Game.getInstance().getPlayer().getY() < Game.getInstance().GetWnd().GetWndHeight() - Game.getInstance().getPlayer().screenY)
                    screenY = Game.getInstance().GetWnd().GetWndHeight() - (WorldHeight - worldY);
                Tile.tiles[lv.map[worldRow][worldCol]].Draw(Game.getInstance().getGraphics(), (int)screenX, (int)screenY);
            }
    }

}
