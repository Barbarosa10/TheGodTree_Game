package PaooGame.Graphics;
import PaooGame.Tiles.Tile;

import java.awt.image.BufferedImage;
import java.util.*;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
    /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage[] playerLeft = new BufferedImage[5];
    public static BufferedImage[] playerRight = new BufferedImage[5];
    public static BufferedImage[] playerUp = new BufferedImage[5];
    public static BufferedImage[] playerDown = new BufferedImage[5];
    public static BufferedImage[] playerLeftUp = new BufferedImage[5];
    public static BufferedImage[] playerLeftDown = new BufferedImage[5];
    public static BufferedImage[] playerRightUp = new BufferedImage[5];
    public static BufferedImage[] playerRightDown = new BufferedImage[5];
    public static BufferedImage[] IDLEplayer = new BufferedImage[5];
    public static BufferedImage[] godTree = new BufferedImage[4];
    //projectiles
    public static BufferedImage[] projectiles = new BufferedImage[5];
    public static SpriteSheet[] projectile = new SpriteSheet[5];

    //enemies
    public static int up, left, down, right;
    public static BufferedImage[] enemyUp;
    public static BufferedImage[] enemyDown;
    public static BufferedImage[] enemyRight;
    public static BufferedImage[] enemyLeft;

    public static ArrayList<BufferedImage[]> enemy_nr = new ArrayList<>(20);
    public static SpriteSheet[] enemy = new SpriteSheet[10];


    public static BufferedImage soil;
    public static BufferedImage grass;
    public static BufferedImage grass2;
    public static BufferedImage mountain;

    public static BufferedImage water;

    public static BufferedImage[] trees = new BufferedImage[2];
    public static BufferedImage wallV; //zid vertical
    public static BufferedImage wallH; //zid orizontal
    public static BufferedImage wallCLUp; //colt stanga sus
    public static BufferedImage wallCLDown; //colt stanga jos
    public static BufferedImage wallCRUp; //colt dreapta sus
    public static BufferedImage wallCRDown; //colt dreapta jos
    public static BufferedImage wallTUp;
    public static BufferedImage wallTDown;
    public static BufferedImage wallTLeft;
    public static BufferedImage wallTRight;
    public static BufferedImage wallEndUp;
    public static BufferedImage wallEndDown;
    public static BufferedImage wallEndLeft;
    public static BufferedImage wallEndRight;
    public static BufferedImage wallBox;

    public static BufferedImage wallV2; //zid vertical
    public static BufferedImage wallH2; //zid orizontal
    public static BufferedImage wallCLUp2; //colt stanga sus
    public static BufferedImage wallCLDown2; //colt stanga jos
    public static BufferedImage wallCRUp2; //colt dreapta sus
    public static BufferedImage wallCRDown2; //colt dreapta jos
    public static BufferedImage wallTUp2;
    public static BufferedImage wallTDown2;
    public static BufferedImage wallTLeft2;
    public static BufferedImage wallTRight2;
    public static BufferedImage wallEndUp2;
    public static BufferedImage wallEndDown2;
    public static BufferedImage wallEndLeft2;
    public static BufferedImage wallEndRight2;
    public static BufferedImage wallBox2;

    //door
    public static BufferedImage[] doors = new BufferedImage[2];

    //life
    public static BufferedImage[] life = new BufferedImage[9];

    //key
    public static BufferedImage keys;

    //heart
    public static BufferedImage hearts;
    //tree


    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        //Map tiles
        SpriteSheet[] floor = new SpriteSheet[4];
        SpriteSheet[] walls = new SpriteSheet[4];
        SpriteSheet[] Tree = new SpriteSheet[2];
        SpriteSheet[] door = new SpriteSheet[2];
        SpriteSheet key;
        SpriteSheet heart;
        //life
        SpriteSheet[] Life = new SpriteSheet[9];

        Life[0] = new SpriteSheet(ImageLoader.LoadImage("/textures/life0.png"));
        Life[1] = new SpriteSheet(ImageLoader.LoadImage("/textures/life1.png"));
        Life[2] = new SpriteSheet(ImageLoader.LoadImage("/textures/life2.png"));
        Life[3] = new SpriteSheet(ImageLoader.LoadImage("/textures/life3.png"));
        Life[4] = new SpriteSheet(ImageLoader.LoadImage("/textures/life4.png"));
        Life[5] = new SpriteSheet(ImageLoader.LoadImage("/textures/life5.png"));
        Life[6] = new SpriteSheet(ImageLoader.LoadImage("/textures/life6.png"));
        Life[7] = new SpriteSheet(ImageLoader.LoadImage("/textures/life7.png"));
        Life[8] = new SpriteSheet(ImageLoader.LoadImage("/textures/life8.png"));

        //tree
        Tree[0] = new SpriteSheet(ImageLoader.LoadImage("/textures/simpleTree.png"));
        Tree[1] = new SpriteSheet(ImageLoader.LoadImage("/textures/godTree.png"));

        //key
        key = new SpriteSheet(ImageLoader.LoadImage("/textures/key.png"));

        //heart
        heart = new SpriteSheet(ImageLoader.LoadImage("/textures/heart.png"));

        //doors
        door[0] = new SpriteSheet(ImageLoader.LoadImage("/textures/door1.png"));
        door[1] = new SpriteSheet(ImageLoader.LoadImage("/textures/door2.png"));

        floor[0] = new SpriteSheet(ImageLoader.LoadImage("/textures/Floor - Grass 1 64x64.png"));
        walls[0] = new SpriteSheet(ImageLoader.LoadImage("/textures/Wall - Dirt 1 64x64.png"));
        floor[1] = new SpriteSheet(ImageLoader.LoadImage("/textures/Floor - Glass 1 64x64.png"));
        walls[1] = new SpriteSheet(ImageLoader.LoadImage("/textures/Wall - Brick 3 64x64.png"));

        //Enemies
        enemy[0] = new SpriteSheet(ImageLoader.LoadImage("/textures/schelet1.png"));
        enemy[1] = new SpriteSheet(ImageLoader.LoadImage("/textures/enemies.png"));

        //Projectile
        projectile[0] = new SpriteSheet((ImageLoader.LoadImage("/textures/projectile3.png")));
        projectile[1] = new SpriteSheet((ImageLoader.LoadImage("/textures/projectile4.png")));
        projectile[2] = new SpriteSheet((ImageLoader.LoadImage("/textures/projectile5.png")));
        projectile[3] = new SpriteSheet((ImageLoader.LoadImage("/textures/projectile6.png")));
        /* PLayer*/
        SpriteSheet player_right = new SpriteSheet(ImageLoader.LoadImage("/textures/player_right.png"));
        SpriteSheet player_left = new SpriteSheet(ImageLoader.LoadImage("/textures/player_left.png"));
        /// Se obtin subimaginile corespunzatoare elementelor necesare.
        grass = floor[0].tilecrop(7, 5, 64, 64);
        soil = floor[0].tilecrop(1, 0, 64, 64);
        wallV = walls[0].tilecrop(2, 0, 64, 64);
        wallH = walls[0].tilecrop(2, 1, 64, 64);
        wallCLUp = walls[0].tilecrop(0, 0, 64, 64);
        wallCLDown = walls[0].tilecrop(0, 1, 64, 64);
        wallCRUp = walls[0].tilecrop(1, 0, 64, 64);
        wallCRDown = walls[0].tilecrop(1, 1, 64, 64);
        wallTUp = walls[0].tilecrop(3, 0, 64, 64);
        wallTDown = walls[0].tilecrop(4, 0, 64, 64);
        wallTLeft = walls[0].tilecrop(3, 1, 64, 64);
        wallTRight = walls[0].tilecrop(4, 1, 64, 64);
        wallEndUp = walls[0].tilecrop(5, 1, 64, 64);
        wallEndDown = walls[0].tilecrop(6, 0, 64, 64);
        wallEndLeft = walls[0].tilecrop(6, 1, 64, 64);
        wallEndRight = walls[0].tilecrop(5, 0,64, 64);
        wallBox = walls[0].tilecrop(6, 3, 64, 64);

        grass2 = floor[1].tilecrop(7, 5, 64, 64);
        soil = floor[1].tilecrop(1, 0, 64, 64);
        wallV2 = walls[1].tilecrop(2, 0, 64, 64);
        wallH2 = walls[1].tilecrop(2, 1, 64, 64);
        wallCLUp2 = walls[1].tilecrop(0, 0, 64, 64);
        wallCLDown2 = walls[1].tilecrop(0, 1, 64, 64);
        wallCRUp2 = walls[1].tilecrop(1, 0, 64, 64);
        wallCRDown2 = walls[1].tilecrop(1, 1, 64, 64);
        wallTUp2 = walls[1].tilecrop(3, 0, 64, 64);
        wallTDown2 = walls[1].tilecrop(4, 0, 64, 64);
        wallTLeft2 = walls[1].tilecrop(3, 1, 64, 64);
        wallTRight2 = walls[1].tilecrop(4, 1, 64, 64);
        wallEndUp2 = walls[1].tilecrop(5, 1, 64, 64);
        wallEndDown2 = walls[1].tilecrop(6, 0, 64, 64);
        wallEndLeft2 = walls[1].tilecrop(6, 1, 64, 64);
        wallEndRight2 = walls[1].tilecrop(5, 0,64, 64);
        wallBox2 = walls[1].tilecrop(6, 3, 64, 64);

        doors[0] = door[0].tilecrop(0,0,43, 49);
        doors[1] = door[1].tilecrop(0,0,49, 43);
        keys = key.tilecrop(0, 0, 16, 16);
        hearts = heart.tilecrop(0,0,64,64);
        trees[0] = Tree[0].tilecrop(0,0, 200, 193);
        trees[1] = Tree[1].tilecrop(0,0, 214, 211);

        //life
        for(int i = 0; i < 9 ; i++)
            life[i] = Life[i].tilecrop(0,0, Tile.TILE_WIDTH*3, Tile.TILE_HEIGHT);

        //player
        for(int i = 0; i < 5; i++)
            IDLEplayer[i] = player_right.tilecrop(i, 0, 62, 86);
        for(int i = 0; i < 5; i++)
            playerUp[i] = player_right.tilecrop(i,9, 62, 86);
        for(int i = 0; i < 5; i++)
            playerDown[i] = player_right.tilecrop(i,6, 62, 86);
        int j = 0;
        for(int i = 4; i >=0; i--) {
            playerLeft[j] = player_left.tilecrop(i, 4, 62, 86);
            j++;
        }
        for(int i = 0; i < 5; i++)
            playerRight[i] = player_right.tilecrop(i, 4, 62, 86);
        for(int i = 0; i < 5; i++)
            playerLeftUp[i] = player_left.tilecrop(i, 2, 62, 86);
        for(int i = 0; i < 5; i++)
            playerLeftDown[i] = player_right.tilecrop(i, 7, 62, 86);
        for(int i = 0; i < 5; i++)
            playerRightUp[i] = player_right.tilecrop(i, 2, 62, 86);
        for(int i = 0; i < 5; i++)
            playerRightDown[i] = player_left.tilecrop(i, 7, 62, 86);

        //enemies
        down = 0; left = 1; right = 2; up = 3;
        InitEnemy(1, SpriteSheet.enemy1Width, SpriteSheet.enemy1Height, 0);
        InitEnemy(1, SpriteSheet.enemy1Width, SpriteSheet.enemy1Height, 6);
        InitEnemy(1, SpriteSheet.enemy1Width, SpriteSheet.enemy1Height, 9);
        down = 4; left = 5; right = 6; up = 7;
        InitEnemy(1,SpriteSheet.enemy1Width, SpriteSheet.enemy1Height, 9);

        //projectiles
        projectiles[0] =projectile[0].tilecrop(0,0,64, 64);
        projectiles[1] =projectile[1].tilecrop(0,0,64, 64);
        projectiles[2] =projectile[2].tilecrop(0,0,64, 64);
        projectiles[3] =projectile[3].tilecrop(0,0,64, 64);
    }
    public static void InitEnemy(int enemyNumber, int width, int height, int pos){

        enemyUp = new BufferedImage[4];
        enemyDown = new BufferedImage[4];
        enemyLeft = new BufferedImage[4];
        enemyRight = new BufferedImage[4];
        for(int i = 0; i < 3; i++)
            enemyUp[i] = enemy[enemyNumber].tilecrop(pos+i, up, width, height);

        for(int i = 0; i < 3; i++)
            enemyLeft[i] = enemy[enemyNumber].tilecrop(pos+i, left, width, height);

        for(int i = 0; i < 3; i++)
            enemyRight[i] = enemy[enemyNumber].tilecrop(pos+i, right, width, height);

        for(int i = 0; i < 3; i++)
            enemyDown[i] = enemy[enemyNumber].tilecrop(pos+i, down, width, height);

        enemy_nr.add(enemyUp);
        enemy_nr.add(enemyLeft);
        enemy_nr.add(enemyDown);
        enemy_nr.add(enemyRight);

        enemyUp = null;
        enemyDown = null;
        enemyLeft = null;
        enemyRight = null;
    }

    public static BufferedImage[] getPlayerLeft() {
        return playerLeft;
    }
}
