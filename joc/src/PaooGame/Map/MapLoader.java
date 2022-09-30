package PaooGame.Map;
import java.util.Scanner;
import java.util.*;
import java.util.List;
import PaooGame.Tiles.Tile;

public class MapLoader {
    public int map[][];
    public static int maxWorldCol;
    public static int maxWorldRow;
    public static int WorldWidth;
    public static int WorldHeight;

    public void Load(String path) {
        List<String[]> list = new ArrayList<String[]>();
        try {

            Scanner input = new Scanner(MapLoader.class.getResourceAsStream(path));
            String string[];
            while(input.hasNextLine())
            {
                string = input.nextLine().split(",");
                list.add(string);
            }
        }catch(Exception e) {
            System.out.println("Error when reading file " + path);
        }
        maxWorldCol = list.get(0).length;
        maxWorldRow = list.size();
        WorldWidth = maxWorldCol * Tile.TILE_WIDTH;
        WorldHeight = maxWorldCol * Tile.TILE_HEIGHT;



        map = new int[maxWorldCol][maxWorldRow];
        for(int i = 0; i < maxWorldCol; i++)
            for(int j = 0; j < maxWorldRow; j++)
            {
                map[i][j] = Integer.parseInt(list.get(i)[j]);
            }
    }
}
