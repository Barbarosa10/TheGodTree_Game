package PaooGame.Entity;

import PaooGame.Game;
import PaooGame.Map.Level;
import PaooGame.Tiles.Tile;

public class BossEnemy extends Enemy {
    public BossEnemy(double x, double y, int enemyNumber, int speed, int hp) {
        super(x, y, enemyNumber, speed, hp);
        this.hp = hp;
        type = 1;
    }
    @Override
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
            Game.getInstance().getProjectileList().add(new Projectile(this, start, 39, 30, 4, 4, 0, 0));
            Game.getInstance().getProjectileList().add(new Projectile(this, start, 30, 30, 4, 4, 1, 0));

            Game.getInstance().getProjectileList().add(new Projectile(this, start, 30, 30, 4, 4, 2, 0));
            counter = 0;
        }
        counter++;
    }
}
