package PaooGame.Entity;
import PaooGame.Graphics.Assets;
import PaooGame.Object.SuperObject;
import PaooGame.Tiles.Tile;
import PaooGame.Game;
import PaooGame.Collision.CollisionChecker;
import java.awt.*;
import java.lang.Math;

import static PaooGame.Map.MapLoader.WorldHeight;
import static PaooGame.Map.MapLoader.WorldWidth;

public class Player extends Entity {
    public final double screenX;
    public final double screenY;
    public double draw_x;
    public double draw_y;
    public int type = 0;

    public Player() {
        super(0, 16, 16, 32, 32);
        SetPosition();
        screenX = Game.getInstance().GetWnd().GetWndWidth() / 2 - (Tile.TILE_WIDTH/2);
        screenY = Game.getInstance().GetWnd().GetWndHeight() / 2 - (Tile.TILE_HEIGHT/2);
        velocity.x =0;
        velocity.y = 0;
        name = "player";
        direction = "down";
        hp = 8;


    }
    public void Player(){
        direction = "down";
        start = 0;
    }
    public void load(double worldX, double worldY, int hp){
        this.worldX = worldX; this.worldY = worldY; this.hp = hp;
    }
    public void SetPosition() {
        worldX = Tile.TILE_WIDTH * 2; worldY = Tile.TILE_WIDTH * 2;
        speed0 = 2;
    }
    public boolean checkLife(){
        if(hp <= 0) {
            isDestroyed = true;
            return false;
        }
        return true;
    }
    public void shoot(){
        Game.getInstance().playSE(1);
        Game.getInstance().getProjectileList().add(new Projectile(this, start, 30, 30, 4, 4, 0, type));

    }
    public void handleEvents() {


        if(Game.getInstance().getKey().WPressed && Game.getInstance().getKey().SPressed && Game.getInstance().getKey().DPressed) {
            direction = "right";
        }
        else if(Game.getInstance().getKey().WPressed && Game.getInstance().getKey().SPressed && Game.getInstance().getKey().APressed) {
            direction = "left";
        }
        else if(Game.getInstance().getKey().WPressed && Game.getInstance().getKey().APressed && Game.getInstance().getKey().DPressed) {
            direction = "up";
        }
        else if(Game.getInstance().getKey().SPressed && Game.getInstance().getKey().APressed && Game.getInstance().getKey().DPressed) {
            direction = "down";
        }
        else if(Game.getInstance().getKey().WPressed && Game.getInstance().getKey().APressed) {
            direction = "leftUp";
        }
        else if(Game.getInstance().getKey().WPressed && Game.getInstance().getKey().DPressed) {
            direction = "rightUp";
        }
        else if(Game.getInstance().getKey().SPressed && Game.getInstance().getKey().APressed) {
            direction = "leftDown";
        }
        else if(Game.getInstance().getKey().SPressed && Game.getInstance().getKey().DPressed) {
            direction = "rightDown";
        }
        else if(Game.getInstance().getKey().WPressed) {
            direction = "up";
        }
        else if(Game.getInstance().getKey().SPressed) {
            direction = "down";
        }
        else if(Game.getInstance().getKey().DPressed) {
            direction = "right";
        }
        else if(Game.getInstance().getKey().APressed) {
            direction = "left";
        }
        else {
            stop = 1;
        }

        if(magnitude != 0) {
            speed = speed0;
            speed = speed / magnitude;
        }
        if(Game.getInstance().getKey().ShiftPressed)
            speed += Game.getInstance().getKey().increase;

        if(Game.getInstance().getKey().SpacePressed) {
            shoot();
            Game.getInstance().getKey().SpacePressed = false;
        }
    }
    public void Update() {
        checkLife();

        magnitude = Math.sqrt(velocity.x*velocity.x + velocity.y*velocity.y);
        handleEvents();
        collisionOn = false;
        Game.getInstance().GetCollision().checktile(this);
        worldX0 = worldX;
        worldY0 = worldY;
        if(collisionOn == false)
        {
            for(Enemy enemy : Game.getInstance().getEnemy()) {
                CollisionChecker.CheckEntityCollision(this, enemy);
            }
            if(collisionOn == false) {
                for(SuperObject obj : Game.getInstance().getObjectList()) {
                    Game.getInstance().GetCollision().checkObject(this, obj);
                    if(collisionOn == true) {
                        obj.collision(this);
                        if(collisionOn == true) {
                            stop = 1;
                            break;
                        }
                    }
                }
                if(collisionOn == false) {
                    worldX += velocity.x * speed;
                    worldY += velocity.y * speed;
                }
                else {
                    stop = 1;
                }
            }
            else {
                stop = 1;
            }
        }
        else {
            collisionOn  = false;
            if (direction == "leftUp" || direction == "leftDown" || direction == "rightUp" || direction == "rightDown") {
                for (SuperObject obj : Game.getInstance().getObjectList()) {
                    Game.getInstance().GetCollision().checkObject(this, obj);
                    if(obj.name == "door") {
                        if (collisionOn == true) {
                            obj.collision(this);
                            if (collisionOn == true) {
                                stop = 1;
                                break;
                            } else
                                stop = 0;
                        }
                    }
                    else
                        stop = 0;
                }
                if (stop == 0) {

                    if (CollisionChecker.check == 1) {
                        worldX += velocity.x * speed;
                        CollisionChecker.check = 0;
                    } else if (CollisionChecker.check == 2) {
                        worldY += velocity.y * speed;
                        CollisionChecker.check = 0;
                    } else {
                        stop = 1;
                    }
                }
            }
        }
        if(worldX == worldX0 && worldY == worldY0)
            stop = 1;

        spriteCounter++;
        if(spriteCounter > 6) {
            if(spriteNumber < 5)
                spriteNumber++;
            else
                spriteNumber = 1;
            spriteCounter = 0;
        }
        //Camera
        draw_x = screenX;
        draw_y = screenY;
        if(screenX >= worldX)
            draw_x = worldX;
        if(screenY >= worldY)
            draw_y = worldY;
        if(WorldWidth - worldX < Game.getInstance().GetWnd().GetWndWidth() - screenX)
            draw_x = Game.getInstance().GetWnd().GetWndWidth() - (WorldWidth - worldX);
        if(WorldHeight - worldY < Game.getInstance().GetWnd().GetWndHeight() - screenY)
            draw_y = Game.getInstance().GetWnd().GetWndHeight() - (WorldHeight - worldY);

    }

    public void Draw(Graphics g) {
        if(start == 0)
        {
            img = Assets.playerDown[0];
            start++;
        }
        if(stop == 0) {
            switch (direction) {
                case "up":
                    img = Assets.playerUp[spriteNumber - 1];
                    break;
                case "down":
                    img = Assets.playerDown[spriteNumber - 1];
                    break;
                case "right":
                    img = Assets.playerRight[spriteNumber - 1];
                    break;
                case "left":
                    img = Assets.playerLeft[spriteNumber - 1];
                    break;
                case "leftUp":
                    img = Assets.playerLeftUp[spriteNumber - 1];
                    break;
                case "leftDown":
                    img = Assets.playerLeftDown[spriteNumber - 1];
                    break;
                case "rightUp":
                    img = Assets.playerRightUp[spriteNumber - 1];
                    break;
                case "rightDown":
                    img = Assets.playerRightDown[spriteNumber - 1];
                    break;
                default:
            }
        }
        else
            stop = 0;

        //Drawing the player
        g.drawImage((Image) img,  (int)Math.floor(draw_x), (int)Math.floor(draw_y), Tile.TILE_WIDTH, Tile.TILE_HEIGHT, null);

    }
}
