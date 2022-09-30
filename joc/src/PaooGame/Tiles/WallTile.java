package PaooGame.Tiles;

import PaooGame.Graphics.Assets;
import PaooGame.Map.Level;

import java.awt.image.BufferedImage;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class WallTile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public WallTile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.wallV, id);
        BufferedImage tmp = null;
        switch (id) {
            case 2:
                tmp = Assets.wallV;
                break;
            case 4:
                tmp = Assets.wallH;
                break;
            case 0:
                tmp = Assets.wallCLUp;
                break;
            case 8:
                tmp = Assets.wallCLDown;
                break;
            case 1:
                tmp = Assets.wallCRUp;
                break;
            case 9:
                tmp = Assets.wallCRDown;
                break;
            case 10:
                tmp = Assets.wallTUp;
                break;
            case 12:
                tmp = Assets.wallTDown;
                break;
            case 11:
                tmp = Assets.wallTLeft;
                break;
            case 6:
                tmp = Assets.wallTRight;
                break;
            case 14:
                tmp = Assets.wallEndUp;
                break;
            case 13:
                tmp = Assets.wallEndDown;
                break;
            case 7:
                tmp = Assets.wallEndLeft;
                break;
            case 15:
                tmp = Assets.wallEndRight;
                break;
            case 5:
                tmp = Assets.wallBox;
                break;
            case 18:
                tmp = Assets.wallV2;
                break;
            case 20:
                tmp = Assets.wallH2;
                break;
            case 16:
                tmp = Assets.wallCLUp2;
                break;
            case 24:
                tmp = Assets.wallCLDown2;
                break;
            case 17:
                tmp = Assets.wallCRUp2;
                break;
            case 25:
                tmp = Assets.wallCRDown2;
                break;
            case 26:
                tmp = Assets.wallTDown2;
                break;
            case 28:
                tmp = Assets.wallTUp2;
                break;
            case 27:
                tmp = Assets.wallTLeft2;
                break;
            case 22:
                tmp = Assets.wallTRight2;
                break;
            case 30:
                tmp = Assets.wallEndUp2;
                break;
            case 29:
                tmp = Assets.wallEndDown2;
                break;
            case 23:
                tmp = Assets.wallEndLeft2;
                break;
            case 31:
                tmp = Assets.wallEndRight2;
                break;
            case 21:
                tmp = Assets.wallBox2;
                break;
            default:
        }

        update(tmp);
    }
    public void update(BufferedImage tmp) {
        img = tmp;
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
