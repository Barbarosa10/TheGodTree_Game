package PaooGame.Entity;

import PaooGame.Collision.CollisionChecker;
import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Object.SuperObject;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Projectile extends Entity{
    Entity entity;
    Enemy enemy;
    int pos = 0;
    public int type = 0;
    public Projectile(Entity entity, int start, int solidArea_x, int solidArea_y, int solidArea_width, int solidArea_height, int pos, int type) {
        super(start, solidArea_x, solidArea_y, solidArea_width, solidArea_height);
        this.entity = entity;
        this.pos = pos;
        this.name = "projectile";
        this.type = type;
        direction = "";
        if(entity.name == "enemy") {
            img = Assets.projectiles[1];
            shootPlayer();
        }
        else {
            if(entity.name == "player") {
                if(type == 0) {
                    img = Assets.projectiles[0];
                    SetSpeed(4);
                }
                else if(type == 1){
                    img = Assets.projectiles[2];
                    SetSpeed(6);
                }
                else if(type == 2) {
                    img = Assets.projectiles[3];
                    SetSpeed(2);
                }
                shootEnemy();
            }
        }

        magnitude = Math.sqrt(velocity.x * velocity.x + velocity.y * velocity.y);
        speed = speed0;
        if (magnitude != 0) {
            //speed = speed0;
            speed = speed / magnitude;
        }


    }
    public void shootEnemy(){
        // System.out.println(entity.direction);
        switch(entity.direction){
            case "up":
                velocity.y = -1;
                velocity.x = 0;
                worldX = entity.worldX;
                worldY = entity.worldY;// - Tile.TILE_HEIGHT;
                direction = "up";
                break;
            case "left":
                velocity.x = -1;
                velocity.y = 0;
                worldX = entity.worldX;// - Tile.TILE_WIDTH;
                worldY = entity.worldY;
                direction = "left";
                break;
            case "down":
                velocity.x = 0;
                velocity.y = 1;
                worldX = entity.worldX;
                worldY = entity.worldY;
                direction = "down";
                break;
            case "right":
                velocity.x = 1;
                velocity.y = 0;
                worldX = entity.worldX;
                worldY = entity.worldY;
                direction = "right";
                break;
            case "leftUp":
                velocity.x = -1;
                velocity.y = -1;
                worldX = entity.worldX;
                worldY = entity.worldY;
                direction = "leftUp";
                break;
            case "leftDown":
                velocity.x = -1;
                velocity.y = 1;
                worldX = entity.worldX;
                worldY = entity.worldY;
                direction = "leftDown";
                break;
            case "rightDown":
                velocity.x = 1;
                velocity.y = 1;
                worldX = entity.worldX;
                worldY = entity.worldY;
                direction = "rightDown";
                break;
            case "rightUp":
                velocity.x = 1;
                velocity.y = -1;
                worldX = entity.worldX;
                worldY = entity.worldY;
                direction = "rightUp";
                break;
            default:
        }
    }
    public void shootPlayer(){
        SetSpeed(4);
        worldX = entity.worldX;
        worldY = entity.worldY;
        switch(entity.direction){
            case "up":
                if(pos == 0) {
                    velocity.x = -1;
                    velocity.y = -4;
                    direction = "leftUp";
                }
                else if(pos == 1){
                    velocity.y = -1;
                    velocity.x = 0;
                    direction = "up";
                }else{
                    velocity.x = 1;
                    velocity.y = -4;
                    direction = "rightUp";
                }
                break;
            case "left":
                if(pos == 0) {
                    velocity.x = -4;
                    velocity.y = 1;
                    direction = "leftDown";
                }
                else if(pos == 1){
                    velocity.x = -1;
                    velocity.y = 0;
                    direction = "left";
                }else{
                    velocity.x = -4;
                    velocity.y = -1;
                    direction = "leftUp";
                }
                break;
            case "down":
                if(pos == 0) {
                    velocity.x = -1;
                    velocity.y = 4;
                    direction = "leftDown";
                }
                else if(pos == 1){
                    velocity.x = 0;
                    velocity.y = 1;
                    direction = "down";
                }else{
                    velocity.x = 1;
                    velocity.y = 4;
                    direction = "rightDown";
                }
                break;
            case "right":
                if(pos == 0) {
                    velocity.x = 4;
                    velocity.y = 1;
                    direction = "rightDown";
                }
                else if(pos == 1){
                    velocity.x = 1;
                    velocity.y = 0;
                    direction = "right";
                }else{
                    velocity.x = 4;
                    velocity.y = -1;
                    direction = "rightUp";
                }
                break;
            case "leftUp":
                if(pos == 0) {
                    velocity.x = -4;
                    velocity.y = -1;
                    direction = "left";
                }
                else if(pos == 1){
                    velocity.x = -1;
                    velocity.y = -1;
                    direction = "leftUp";
                }else{
                    velocity.y = -4;
                    velocity.x = -1;
                    direction = "up";
                }
                break;
            case "leftDown":
                if(pos == 0) {
                    velocity.x = -1;
                    velocity.y = 4;
                    direction = "left";
                }
                else if(pos == 1){
                    velocity.x = -1;
                    velocity.y = 1;
                    direction = "leftDown";
                }else{
                    velocity.x = -4;
                    velocity.y = 1;
                    direction = "down";
                }
                break;
            case "rightDown":
                if(pos == 0) {
                    velocity.x = 1;
                    velocity.y = 4;
                    direction = "down";
                }
                else if(pos == 1){
                    velocity.x = 1;
                    velocity.y = 1;
                    direction = "rightDown";
                }else{
                    velocity.x = 4;
                    velocity.y = 1;
                    direction = "right";
                }

                break;
            case "rightUp":
                if(pos == 0) {
                    velocity.x = 4;
                    velocity.y = -1;
                    direction = "right";
                }
                else if(pos == 1){
                    velocity.x = 1;
                    velocity.y = -1;
                    direction = "rightUp";
                }else{
                    velocity.y = -4;
                    velocity.x = 1;
                    direction = "up";
                }
                break;
            default:
        }
    }
    public void SetSpeed( int speed) {

        speed0 = speed;
    }
    public void Update(){

        collisionOn = false;
        Game.getInstance().GetCollision().checktile(this);
        if (collisionOn == false) {
            if(entity.name == "enemy") {
                CollisionChecker.CheckEntityCollision(this, Game.getInstance().getPlayer());
            }
            if (collisionOn == false) {
                if(entity.name == "player") {
                    for (Enemy enemy : Game.getInstance().getEnemy()) {
                        if (entity.name == "entity") {
                            collisionOn = false;
                            break;
                        }
                        if (enemy.worldX != entity.worldX && enemy.worldY != entity.worldY)
                            CollisionChecker.CheckEntityCollision(this, enemy);
                        if (collisionOn == true) {
                            this.enemy = enemy;
                            break;
                        }

                    }
                    if (collisionOn == false) {
                        if(entity.name == "player"){
                            for (SuperObject obj : Game.getInstance().getObjectList()) {
                                Game.getInstance().GetCollision().checkObject(this, obj);
                                if(collisionOn == true) {
                                    obj.collision(this);
                                    break;
                                }
                            }
                        }
                        if(collisionOn == false) {
                            worldX += velocity.x * speed;
                            worldY += velocity.y * speed;
                        }
                        else{
                            isDestroyed = true;
                        }
                    } else {
                        isDestroyed = true;
                        if (entity.name == "player") {
                            if(type == 0 || type == 1) {
                                enemy.hp -= 1;
                            }
                            else if(type == 2){
                                enemy.hp -= 3;
                            }
                            Game.getInstance().playSE(2);
                        }
                    }


                } else {

                    worldX += velocity.x * speed;
                    worldY += velocity.y * speed;
                }
            }else{
                isDestroyed = true;
                Game.getInstance().getPlayer().hp -= 1;
                Game.getInstance().getPlayer().checkLife();
                Game.getInstance().playSE(2);
            }
        } else {

            isDestroyed = true;
        }
    }
    public void Draw(Graphics g){
        //Drawing the projectile

        screenX = worldX - Game.getInstance().getPlayer().worldX + Game.getInstance().getPlayer().draw_x;
        screenY = worldY - Game.getInstance().getPlayer().worldY + Game.getInstance().getPlayer().draw_y;

        g.drawImage(img, (int) (screenX), (int) (screenY), Tile.TILE_WIDTH, Tile.TILE_HEIGHT, null);

    }
}
