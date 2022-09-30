package PaooGame.Collision;
import PaooGame.Entity.Entity;
import PaooGame.Game;
import PaooGame.Object.SuperObject;
import  PaooGame.Tiles.Tile;
import static PaooGame.Map.Level.lv;
import static PaooGame.Tiles.Tile.*;

public class CollisionChecker {
    Game game;
    public static int check = 0;
    public static String tile = "";

    public CollisionChecker(Game game) {
        this.game = game;
    }

    public void checkObject(Entity entity, SuperObject entity2){
        int leftWorldX = (int)entity.getX() + entity.solidArea.x;
        int rightWorldX = (int)entity.getX() + entity.solidArea.x + entity.solidArea.width;
        int upWorldY = (int)entity.getY() + entity.solidArea.y;
        int downWorldY = (int)entity.getY() + entity.solidArea.y + entity.solidArea.height;
        double up = upWorldY, left = leftWorldX, right = rightWorldX, down = downWorldY;
        if(entity.getX() == entity2.getX() && entity.getY() == entity2.getY())
            return;
        if(entity2.IsSolid() == false)
            return;
        else {
            switch (entity.direction) {
                case "up":
                    up = (upWorldY - entity.getSpeed());
                    if ((up <= entity2.getY() + Tile.TILE_HEIGHT && up >= entity2.getY()) && ((right >= entity2.getX() && right <= entity2.getX() + Tile.TILE_WIDTH)
                            || (left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX()))) {
                        entity.setCollision(true);
                        tile = entity2.name;
                        return;
                    }
                    break;
                case "down":
                    down = (downWorldY + entity.getSpeed());
                    if ((down <= entity2.getY() + Tile.TILE_HEIGHT && down >= entity2.getY()) && ((right >= entity2.getX() && right <= entity2.getX() + Tile.TILE_WIDTH)
                            || (left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX()))) {
                        entity.setCollision(true);
                        tile = entity2.name;
                        return;
                    }
                    break;
                case "left":
                    left = (leftWorldX - entity.getSpeed());
                    if (((up <= entity2.getY() + Tile.TILE_HEIGHT && up >= entity2.getY()) || (down <= entity2.getY() + Tile.TILE_HEIGHT && down >= entity2.getY()))
                            && left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX()) {
                        entity.setCollision(true);
                        tile = entity2.name;
                        return;
                    }
                    break;
                case "right":
                    right = (rightWorldX + entity.getSpeed());
                    if (((up <= entity2.getY() + Tile.TILE_HEIGHT && up >= entity2.getY()) || (down <= entity2.getY() + Tile.TILE_HEIGHT && down >= entity2.getY()))
                            && right >= entity2.getX() && right <= entity2.getX() + Tile.TILE_WIDTH) {
                        entity.setCollision(true);
                        tile = entity2.name;
                        return;
                    }
                    break;
                case "leftUp":
                    up = (upWorldY - entity.getSpeed());
                    left = (leftWorldX - entity.getSpeed());
                    down = (downWorldY - entity.getSpeed());
                    right = (rightWorldX - entity.getSpeed());
                    if (((up <= entity2.getY() + Tile.TILE_HEIGHT && up >= entity2.getY()) && ((left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX())
                            || (right <= entity2.getX() + Tile.TILE_WIDTH && right >= entity2.getX()))) || ((down <= entity2.getY() + Tile.TILE_HEIGHT && down >= entity2.getY())
                            && ((left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX())  || (right <= entity2.getX() + Tile.TILE_WIDTH && right >= entity2.getX())))) {
                        entity.setCollision(true);
                        tile = entity2.name;
                        check = 2;
                        return;
                    }
                    break;
                case "leftDown":
                    left = (leftWorldX - entity.getSpeed());
                    down = (downWorldY + entity.getSpeed());
                    right = (rightWorldX - entity.getSpeed());
                    up = (upWorldY + entity.getSpeed());
                    if (((down <= entity2.getY() + Tile.TILE_HEIGHT && down >= entity2.getY()) && ((left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX())
                            || (right <= entity2.getX() + Tile.TILE_WIDTH && right >= entity2.getX()))) || ((up <= entity2.getY() + TILE_HEIGHT && up >= entity2.getY())
                            && ((left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX())  || (right <= entity2.getX() + Tile.TILE_WIDTH && right >= entity2.getX())))) {
                        entity.setCollision(true);
                        tile = entity2.name;
                        check = 2;
                        return;
                    }
                    break;
                case "rightUp":
                    up = (upWorldY - entity.getSpeed());
                    down = (downWorldY - entity.getSpeed());
                    right = (rightWorldX + entity.getSpeed());
                    left = (leftWorldX + entity.getSpeed());
                    if (((up <= entity2.getY() + Tile.TILE_HEIGHT && up >= entity2.getY()) && ((right >= entity2.getX() && right <= entity2.getX() + Tile.TILE_WIDTH)
                            || (left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX()))) || ((down <= entity2.getY() + Tile.TILE_HEIGHT && down >= entity2.getY())
                            && ((right >= entity2.getX() && right <= entity2.getX() + Tile.TILE_WIDTH) || (left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX())))) {
                        entity.setCollision(true);
                        tile = entity2.name;
                        check = 2;
                        return;
                    }
                    break;
                case "rightDown":
                    right = (rightWorldX + entity.getSpeed());
                    down = (downWorldY + entity.getSpeed());
                    left = (leftWorldX + entity.getSpeed());
                    up = (upWorldY + entity.getSpeed());
                    if (((down <= entity2.getY() + Tile.TILE_HEIGHT && down >= entity2.getY()) && ((right >= entity2.getX() && right <= entity2.getX() + Tile.TILE_WIDTH)
                            || (left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX()))) || ((up <= entity2.getY() + Tile.TILE_HEIGHT && up >= entity2.getY())
                            && ((right >= entity2.getX() && right <= entity2.getX() + Tile.TILE_WIDTH) || (left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX())))) {
                        entity.setCollision(true);
                        tile = entity2.name;
                        check = 2;
                        return;
                    }
                    break;
                default:
                    tile = "";
            }
        }
    }

    public void checktile(Entity entity) {
        int leftWorldX = (int)entity.getX() + entity.solidArea.x;
        int rightWorldX = (int)entity.getX() + entity.solidArea.x + entity.solidArea.width;
        int upWorldY = (int)entity.getY() + entity.solidArea.y;
        int downWorldY = (int)entity.getY() + entity.solidArea.y + entity.solidArea.height;

        int leftCol = leftWorldX / Tile.TILE_WIDTH;
        int rightCol = rightWorldX / Tile.TILE_WIDTH;
        int upRow = upWorldY / Tile.TILE_HEIGHT;
        int downRow = downWorldY / Tile.TILE_HEIGHT;


        int tile1 = -1, tile2 = -1, tile3 = -1, tile4 = -1;
        switch(entity.direction) {
            case "up":
                upRow = (int)(upWorldY - entity.getSpeed()) / Tile.TILE_HEIGHT;
                tile1 = lv.map[upRow][leftCol];
                tile2 = lv.map[upRow][rightCol];

                break;
            case "down":
                downRow = (int)(downWorldY + entity.getSpeed()) / Tile.TILE_HEIGHT;
                tile1 = lv.map[downRow][leftCol];
                tile2 = lv.map[downRow][rightCol];
                break;
            case "left":
                leftCol = (int)(leftWorldX - entity.getSpeed()) / Tile.TILE_WIDTH;
                tile1 = lv.map[upRow][leftCol];
                tile2 = lv.map[downRow][leftCol];
                break;
            case "right":
                rightCol = (int)(rightWorldX + entity.getSpeed()) / Tile.TILE_WIDTH;
                tile1 = lv.map[upRow][rightCol];
                tile2 = lv.map[downRow][rightCol];
                break;
            case "leftUp":
                upRow = (int)(upWorldY - entity.getSpeed()) / Tile.TILE_HEIGHT;
                leftCol = (int)(leftWorldX - entity.getSpeed()) / Tile.TILE_WIDTH;
                tile1 = lv.map[upRow][leftCol];
                tile2 = lv.map[upRow][rightCol];

                tile3 = lv.map[upRow][leftCol];
                tile4 = lv.map[downRow][leftCol];
                break;
            case "leftDown":
                leftCol = (int)(leftWorldX - entity.getSpeed()) / Tile.TILE_WIDTH;
                downRow = (int)(downWorldY + entity.getSpeed()) / Tile.TILE_HEIGHT;
                tile3 = lv.map[upRow][leftCol];
                tile4 = lv.map[downRow][leftCol];

                tile1 = lv.map[downRow][leftCol];
                tile2 = lv.map[downRow][rightCol];
                break;
            case "rightUp":
                upRow = (int)(upWorldY - entity.getSpeed()) / Tile.TILE_HEIGHT;
                rightCol = (int)(rightWorldX + entity.getSpeed()) / Tile.TILE_WIDTH;
                tile1 = lv.map[upRow][leftCol];
                tile2 = lv.map[upRow][rightCol];

                tile3 = lv.map[upRow][rightCol];
                tile4 = lv.map[downRow][rightCol];
                break;
            case "rightDown":
                rightCol = (int)(rightWorldX + entity.getSpeed()) / Tile.TILE_WIDTH;
                downRow = (int)(downWorldY + entity.getSpeed()) / Tile.TILE_HEIGHT;
                tile1 = lv.map[downRow][leftCol];
                tile2 = lv.map[downRow][rightCol];

                tile3 = lv.map[upRow][rightCol];
                tile4 = lv.map[downRow][rightCol];
                break;
            default:
        }
        if(tile1 != -1 && tile2 != -1 && tile3 != -1 && tile4 != -1) {
            if (tiles[tile1].IsSolid() && tiles[tile2].IsSolid() && tiles[tile3].IsSolid() && tiles[tile4].IsSolid()) {
                entity.setCollision(true);
                check = 3;
                tile = "tile";
                return;
            }

        }
        if((tile1 != -1 && tile2 != -1) || (tile3 != -1 && tile4 != -1))
            if(tile3 != -1 && tile4 != -1){
                if (tiles[tile3].IsSolid()) {
                    entity.setCollision(true);
                    check = 2;
                    tile = "tile";
                }
                if (tiles[tile4].IsSolid()) {
                    entity.setCollision(true);
                    check = 2;
                    tile = "tile";
                }
                if(tiles[tile3].IsSolid() && tiles[tile4].IsSolid())
                {
                    check = 2;
                    return;
                }
            }

        if(tile1 != -1 && tile2 != -1) {
            if (tiles[tile1].IsSolid()) {
                entity.setCollision(true);
                check = 1;
                tile = "tile";
            }
            if(tiles[tile2].IsSolid()) {
                entity.setCollision(true);
                check = 1;
                tile = "tile";
            }
            if(tiles[tile1].IsSolid() && tiles[tile2].IsSolid())
            {
                check = 1;
                return;
            }
        }
    }
    public static void CheckEntityCollision(Entity entity, Entity entity2){

        int leftWorldX = (int)entity.getX() + entity.solidArea.x;
        int rightWorldX = (int)entity.getX() + entity.solidArea.x + entity.solidArea.width;
        int upWorldY = (int)entity.getY() + entity.solidArea.y;
        int downWorldY = (int)entity.getY() + entity.solidArea.y + entity.solidArea.height;
        double up = upWorldY, left = leftWorldX, right = rightWorldX, down = downWorldY;
        if(entity.getX() == entity2.getX() && entity.getY() == entity2.getY())
            return;
        switch(entity.direction) {
            case "up":
                up = (upWorldY - entity.getSpeed());
                down = (upWorldY - entity.getSpeed());
                if((up <= entity2.getY() + Tile.TILE_HEIGHT && up >= entity2.getY()) && ((right >= entity2.getX() && right <= entity2.getX() + Tile.TILE_WIDTH)
                        || (left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX()))){
                    entity.setCollision(true);
                    tile = entity2.name;
                    return;
                }
                break;
            case "down":
                down = (downWorldY + entity.getSpeed());
                up = (downWorldY + entity.getSpeed());
                if((down <= entity2.getY() + Tile.TILE_HEIGHT && down >= entity2.getY()) && ((right >= entity2.getX() && right <= entity2.getX() + Tile.TILE_WIDTH)
                        || (left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX()))){
                    entity.setCollision(true);
                    tile = entity2.name;
                    return;
                }
                break;
            case "left":
                left = (leftWorldX - entity.getSpeed());
                right = (leftWorldX - entity.getSpeed());
                if(((up <= entity2.getY() + Tile.TILE_HEIGHT && up >= entity2.getY()) || (down <= entity2.getY() + Tile.TILE_HEIGHT && down >= entity2.getY()))
                        && left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX()){
                    entity.setCollision(true);
                    tile = entity2.name;
                    return;
                }
                break;
            case "right":
                right = (rightWorldX + entity.getSpeed());
                left = (rightWorldX + entity.getSpeed());
                if(((up <= entity2.getY() + Tile.TILE_HEIGHT && up >= entity2.getY()) || (down <= entity2.getY() + Tile.TILE_HEIGHT && down >= entity2.getY()))
                        && right >= entity2.getX() && right <= entity2.getX() + Tile.TILE_WIDTH){
                    entity.setCollision(true);
                    tile = entity2.name;
                    return;
                }
                break;
            case "leftUp":
                up = (upWorldY - entity.getSpeed());
                left = (leftWorldX - entity.getSpeed());
                down = (upWorldY - entity.getSpeed());
                right = (leftWorldX - entity.getSpeed());
                if((up <= entity2.getY() + Tile.TILE_HEIGHT && up >= entity2.getY()) && left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX()){
                    entity.setCollision(true);
                    tile = entity2.name;
                    return;
                }
                break;
            case "leftDown":
                left = (leftWorldX - entity.getSpeed());
                down = (downWorldY + entity.getSpeed());
                right = (leftWorldX - entity.getSpeed());
                up = (downWorldY + entity.getSpeed());
                if((down <= entity2.getY() + Tile.TILE_HEIGHT && down >= entity2.getY()) && left <= entity2.getX() + Tile.TILE_WIDTH && left >= entity2.getX()){
                    entity.setCollision(true);
                    tile = entity2.name;
                    return;
                }
                break;
            case "rightUp":
                up = (upWorldY - entity.getSpeed());
                down = (upWorldY - entity.getSpeed());
                right = (rightWorldX + entity.getSpeed());
                left = (rightWorldX + entity.getSpeed());
                if((up <= entity2.getY() + Tile.TILE_HEIGHT && up >= entity2.getY()) && right >= entity2.getX() && right <= entity2.getX() + Tile.TILE_WIDTH){
                    entity.setCollision(true);
                    tile = entity2.name;
                    return;
                }
                break;
            case "rightDown":
                right = (rightWorldX + entity.getSpeed());
                down = (downWorldY + entity.getSpeed());
                left = (rightWorldX + entity.getSpeed());
                up = (downWorldY + entity.getSpeed());
                if((down <= entity2.getY() + Tile.TILE_HEIGHT && down >= entity2.getY()) && right >= entity2.getX() && right <= entity2.getX() + Tile.TILE_WIDTH){
                    entity.setCollision(true);
                    tile = entity2.name;
                    return;
                }
                break;
            default:
                tile = "";
        }
    }


}
