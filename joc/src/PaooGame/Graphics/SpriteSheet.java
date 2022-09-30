package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class SpriteSheet
    \brief Clasa retine o referinta catre o imagine formata din dale (sprite sheet)

    Metoda crop() returneaza o dala de dimensiuni fixe (o subimagine) din sprite sheet
    de la adresa (x * latimeDala, y * inaltimeDala)
 */
public class SpriteSheet
{
    private BufferedImage       spriteSheet;              /*!< Referinta catre obiectul BufferedImage ce contine sprite sheet-ul.*/
    private static final int    tileWidth   = 64;   /*!< Latimea unei dale din sprite sheet.*/
    private static final int    tileHeight  = 64;   /*!< Inaltime unei dale din sprite sheet.*/
    private static final int    playerWidth = 62; //64
    private static final int    playerHeight = 86; //87
    private static final int    player_leftWidth = 62;
    private static final int    player_leftHeight = 86;
    public static final int enemy0Width = 64;
    public static final int enemy0Height = 60;
    public static final int enemy1Width = 52;
    public static final int enemy1Height = 72;
    private static final int treeWidth = 95;
    private static final int treeHeight = 95;

    /*! \fn public SpriteSheet(BufferedImage sheet)
        \brief Constructor, initializeaza spriteSheet.

        \param img Un obiect BufferedImage valid.
     */
    public SpriteSheet(BufferedImage buffImg)
    {
        /// Retine referinta catre BufferedImage object.
        spriteSheet = buffImg;
    }

    /*! \fn public BufferedImage crop(int x, int y)
        \brief Returneaza un obiect BufferedImage ce contine o subimage (dala).

        Subimaginea este localizata avand ca referinta punctul din stanga sus.

        \param x numarul dalei din sprite sheet pe axa x.
        \param y numarul dalei din sprite sheet pe axa y.
     */
    public BufferedImage tilecrop(int x, int y, int width, int height)
    {
        /// Subimaginea (dala) este regasita in sprite sheet specificad coltul stanga sus
        /// al imaginii si apoi latimea si inaltimea (totul in pixeli). Coltul din stanga sus al imaginii
        /// se obtine inmultind numarul de ordine al dalei cu dimensiunea in pixeli a unei dale.
        return spriteSheet.getSubimage(x * width, y * height, width, height);
    }
    public BufferedImage enemycrop(int x, int y, int width, int height){
        return spriteSheet.getSubimage(x * width, y * height, width, height);
    }
}
