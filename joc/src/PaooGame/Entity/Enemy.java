package PaooGame.Entity;
import PaooGame.Graphics.Assets;
import PaooGame.Map.Level;
import PaooGame.Tiles.Tile;
import PaooGame.Game;
import java.lang.Math;
import PaooGame.Collision.CollisionChecker;
import java.awt.*;

public class Enemy extends Entity {
    public static int wX;
    public static int wY;
    public int enemyNumber;
    int counter = 20;
    int check;
    boolean detectPlayer;
    public int type;

    public Enemy(double x, double y, int enemyNumber, int speed, int hp) {
        super(0, 16, 16, 32, 32);
        this.enemyNumber = enemyNumber;
        check = 0;
        SetPosition(x, y, speed);
        name = "enemy";
        direction = "down";
        this.hp = hp;
        detectPlayer = false;
        type = 0;
        if(hp == 3)
            type = 1;
    }

    public void SetPosition(double x, double y, int speed) {
        worldX = Tile.TILE_WIDTH * x;
        worldY = Tile.TILE_WIDTH * y;
        speed0 = speed;
    }
    public void checkLife(){
        if(hp <= 0)
            isDestroyed = true;
    }

    public void shoot(){
        detectPlayer = false;
        double dx  = Game.getInstance().getPlayer().worldX - worldX;
        double dy = Game.getInstance().getPlayer().worldY - worldY;
        magnitude = Math.sqrt(dx * dx + dy * dy);
        dx  /= magnitude;
        dy /= magnitude;
        double tmpX = worldX, tmpY = worldY;
        while(true){
            tmpX += dx;
            tmpY += dy;
            if(Tile.tiles[Level.lv.map[(int) Math.floor(tmpY + Tile.TILE_HEIGHT/2)/Tile.TILE_HEIGHT][(int) Math.floor(tmpX + Tile.TILE_WIDTH/2)/Tile.TILE_WIDTH]].IsSolid()) {
                detectPlayer = false;
                break;
            }
            if(Math.abs(Game.getInstance().getPlayer().worldX - tmpX) <= Math.abs(dx) && Math.abs(Game.getInstance().getPlayer().worldY - tmpY) <= Math.abs(dy)){
                detectPlayer = true;
                break;
            }
        }
        if(detectPlayer && Math.abs(Game.getInstance().getPlayer().worldX - worldX) < 300 && Math.abs(Game.getInstance().getPlayer().worldY - worldY) < 300 && counter >= 60) {
            //int posx =
            //Game.getInstance().getProjectileList().add(new Projectile(key, Game.getInstance(), Game.getInstance().getPlayer(), this, start, 39, 30, 4, 4, 0));
            Game.getInstance().getProjectileList().add(new Projectile(this, start, 30, 30, 4, 4, 1, 0));

            //Game.getInstance().getProjectileList().add(new Projectile(key, Game.getInstance(), Game.getInstance().getPlayer(), this, start, 30, 30, 4, 4, 2));
            counter = 0;
        }
        counter++;
    }
    public void Update() {
        checkLife();

        detectPlayer = false;
        double dx  = Game.getInstance().getPlayer().worldX - worldX;
        double dy = Game.getInstance().getPlayer().worldY - worldY;
        magnitude = Math.sqrt(dx * dx + dy * dy);
        dx  /= magnitude;
        dy /= magnitude;


        double tmpX = worldX, tmpY = worldY;
        while(true){
            tmpX += dx;
            tmpY += dy;
            if(Tile.tiles[Level.lv.map[(int) Math.floor(tmpY + Tile.TILE_HEIGHT/2)/Tile.TILE_HEIGHT][(int) Math.floor(tmpX + Tile.TILE_WIDTH/2)/Tile.TILE_WIDTH]].IsSolid()) {
                detectPlayer = false;
                break;
            }
            if(Math.abs(Game.getInstance().getPlayer().worldX - tmpX) <= Math.abs(dx) && Math.abs(Game.getInstance().getPlayer().worldY - tmpY) <= Math.abs(dy)){
                detectPlayer = true;
                break;
            }
        }


        if(detectPlayer) {

            if (worldX > Game.getInstance().getPlayer().worldX)
                velocity.x = -1;
            else if (worldX < Game.getInstance().getPlayer().worldX)
                velocity.x = 1;
            else
                velocity.x = 0;
            if (worldY > Game.getInstance().getPlayer().worldY)
                velocity.y = -1;
            else if (worldY < Game.getInstance().getPlayer().worldY)
                velocity.y = 1;
            else
                velocity.y = 0;
            if (Math.abs(worldX - Game.getInstance().getPlayer().worldX) < 48)
                velocity.x = 0;
            if (Math.abs(worldY - Game.getInstance().getPlayer().worldY) < 48)
                velocity.y = 0;
        }
        else
        {
            velocity.x = 0;
            velocity.y = 0;
        }


        if (velocity.x == 1 && velocity.y == -1) {
            direction = "rightUp";
        } else if (velocity.x == -1 && velocity.y == -1) {
            direction = "leftUp";
        } else if (velocity.x == -1 && velocity.y == 1) {
            direction = "leftDown";
        } else if (velocity.x == 1 && velocity.y == 1) {
            direction = "rightDown";
        } else if (velocity.x == 1) {
            direction = "right";
        } else if (velocity.x == -1) {
            direction = "left";
        } else if (velocity.y == 1) {
            direction = "down";
        } else if (velocity.y == -1) {
            direction = "up";
        } else {
            stop = 1;
        }
        shoot();
        magnitude = Math.sqrt(velocity.x * velocity.x + velocity.y * velocity.y);
        speed = speed0;
        if (magnitude != 0) {
            speed = speed0;
            speed = speed / magnitude;
        }
        collisionOn = false;
        Game.getInstance().GetCollision().checktile(this);
        if (collisionOn == false) {
            CollisionChecker.CheckEntityCollision(this, Game.getInstance().getPlayer());
            if(collisionOn == false) {
                for (Enemy enemy : Game.getInstance().getEnemy()) {
                    CollisionChecker.CheckEntityCollision(this, enemy);
                    if(collisionOn == true)
                        break;
                }
                if (collisionOn == false) {
                    worldX += velocity.x * speed;
                    worldY += velocity.y * speed;
                }
                else {
                    stop = 1;
                }
            }else{
                stop = 1;
            }
        } else {
            if(direction == "leftUp" || direction == "leftDown" || direction == "rightUp" || direction == "rightDown"){
                if(CollisionChecker.check == 1) {
                    worldX += velocity.x * speed;

                    //worldY -= key.velocity.y * speed;
                    CollisionChecker.check = 0;
                }
                else if(CollisionChecker.check == 2) {
                    worldY += velocity.y * speed;
                    //worldX += key.velocity.x * 5;
                    CollisionChecker.check = 0;
                }
                else {
                    stop = 1;
                }
            }
            else {
                velocity.x = 0;
                velocity.y = 0;
                stop = 1;
            }

        }

        spriteCounter++;
        if (spriteCounter > 6) {
            if (spriteNumber < 3)
                spriteNumber++;
            else
                spriteNumber = 1;
            spriteCounter = 0;
        }
    }


    public void Draw(Graphics g) {
        if (start == 0) {
            img = Assets.enemy_nr.get(4 * enemyNumber + 2)[0];
            start++;
        }
        if(stop == 0) {
            switch (direction) {
                case "up":
                    img = Assets.enemy_nr.get(4 * enemyNumber)[spriteNumber - 1];
                    break;
                case "down":
                    img = Assets.enemy_nr.get(4 * enemyNumber + 2)[spriteNumber - 1];
                    break;
                case "right":
                    img = Assets.enemy_nr.get(4 * enemyNumber + 3)[spriteNumber - 1];
                    break;
                case "left":
                    img = Assets.enemy_nr.get(4 * enemyNumber + 1)[spriteNumber - 1];
                    break;
                case "leftUp":
                    img = Assets.enemy_nr.get(4 * enemyNumber + 1)[spriteNumber - 1];
                    break;
                case "leftDown":
                    img = Assets.enemy_nr.get(4 * enemyNumber + 1)[spriteNumber - 1];
                    break;
                case "rightUp":
                    img = Assets.enemy_nr.get(4 * enemyNumber + 3)[spriteNumber - 1];
                    break;
                case "rightDown":
                    img = Assets.enemy_nr.get(4 * enemyNumber + 3)[spriteNumber - 1];
                    break;
                default:

            }
        }
        else
            stop = 0;
        //Drawing the Game.getInstance().getPlayer()

        screenX = worldX - Game.getInstance().getPlayer().worldX + Game.getInstance().getPlayer().draw_x;
        screenY = worldY - Game.getInstance().getPlayer().worldY + Game.getInstance().getPlayer().draw_y;

        g.drawImage(img, (int) (screenX), (int) (screenY), Tile.TILE_WIDTH, Tile.TILE_HEIGHT, null);

    }
}
