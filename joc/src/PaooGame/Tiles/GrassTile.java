package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class GrassTile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public GrassTile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.grass, id);
        BufferedImage tmp = null;
        switch (id) {
            case 3:
                tmp = Assets.grass;
                break;
            case 19:
                tmp = Assets.grass2;
                break;
            default:
        }

        update(tmp);
    }

    public void update(BufferedImage tmp) {
        img = tmp;
    }
}
