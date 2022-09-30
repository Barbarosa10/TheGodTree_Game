package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Tile
{
    private static final int NO_TILES   = 35;
    public static Tile[] tiles          = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/
    public static Tile[] entityTiles = new Tile[35];
    /// De remarcat ca urmatoarele dale sunt statice si publice. Acest lucru imi permite sa le am incarcate
    /// o singura data in memorie
    public static Tile entity = new EntityTile(-1);

    /*!< Dala de tip iarba*/



    public static Tile cornerLeftfUp = new WallTile(0);
    public static Tile cornerRightUp = new WallTile(1);
    public static Tile wallVertical   = new WallTile(2);
    public static Tile grassTile           = new GrassTile(3);
    public static Tile wallHorizontal = new WallTile(4);
    public static Tile wallBox = new WallTile(5);
    public static Tile wallTRight = new WallTile(6);
    public static Tile wallEndLeft = new WallTile(7);
    public static Tile cornerLeftfDown = new WallTile(8);
    public static Tile cornerRightDown = new WallTile(9);
    public static Tile wallTUp = new WallTile(10);
    public static Tile wallTLeft = new WallTile(11);
    public static Tile wallTDown = new WallTile(12);
    public static Tile wallEndDown = new WallTile(13);
    public static Tile wallEndUp = new WallTile(14);
    public static Tile wallEndRight = new WallTile(15);

    public static Tile cornerLeftfUp2 = new WallTile(16);
    public static Tile cornerRightUp2 = new WallTile(17);
    public static Tile wallVertical2   = new WallTile(18);
    public static Tile grassTile2           = new GrassTile(19);
    public static Tile wallHorizontal2 = new WallTile(20);
    public static Tile wallBox2 = new WallTile(21);
    public static Tile wallTRight2 = new WallTile(22);
    public static Tile wallEndLeft2 = new WallTile(23);
    public static Tile cornerLeftfDown2 = new WallTile(24);
    public static Tile cornerRightDown2 = new WallTile(25);
    public static Tile wallTUp2 = new WallTile(26);
    public static Tile wallTLeft2 = new WallTile(27);
    public static Tile wallTDown2 = new WallTile(28);
    public static Tile wallEndDown2 = new WallTile(29);
    public static Tile wallEndUp2 = new WallTile(30);
    public static Tile wallEndRight2 = new WallTile(31);


    public static final int TILE_WIDTH  = 64;                       /*!< Latimea unei dale.*/
    public static final int TILE_HEIGHT = 64;                       /*!< Inaltimea unei dale.*/

    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de dala.*/
    protected  int id;                                         /*!< Id-ul unic aferent tipului de dala.*/

    /*! \fn public Tile(BufferedImage texture, int id)
        \brief Constructorul aferent clasei.

        \param image Imaginea corespunzatoare dalei.
        \param id Id-ul dalei.
     */
    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        tiles[id] = this;
    }
    public Tile(int check){

    }
    /*! \fn public void Update()
        \brief Actualizeaza proprietatile dalei.
     */
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g, int x, int y)
        \brief Deseneaza in fereastra dala.

        \param g Contextul grafic in care sa se realizeze desenarea
        \param x Coordonata x in cadrul ferestrei unde sa fie desenata dala
        \param y Coordonata y in cadrul ferestrei unde sa fie desenata dala
     */
    public void Draw(Graphics g, int x, int y)
    {
        /// Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
     */
    public boolean IsSolid()
    {
        return false;
    }

    /*! \fn public int GetId()
        \brief Returneaza id-ul dalei.
     */
    public int GetId()
    {
        return id;
    }
}
