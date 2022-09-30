package PaooGame.DataBase;

import PaooGame.Entity.BossEnemy;
import PaooGame.Entity.Enemy;
import PaooGame.Game;
import PaooGame.Map.Level;
import PaooGame.Object.Obj_Door;
import PaooGame.Object.Obj_Projectile;
import PaooGame.Object.Obj_Tree;
import PaooGame.Object.SuperObject;
import PaooGame.Tiles.Tile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DataBase {
    Connection c = null;
    private final static String DATABASE_URL = "jdbc:sqlite:DataBase.db";
    public DataBase(){
        try {
            c = DriverManager.getConnection(DATABASE_URL);
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);

        }
        System.out.println("Opened database successfully");
    }
    public void SaveHighScore(){
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE HighScore SET HighScore=? WHERE ID=1";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, Game.getInstance().getUi().playTime);
            stmt.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void LoadHighScore(){
        Statement stmt = null;
        try {

            String sql = "SELECT HighScore FROM HighScore WHERE ID=1";
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Game.getInstance().getUi().HighScore = rs.getInt("HighScore");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void SaveGame(){
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE Saves SET PlayerX=?, PlayerY=?, PlayerHP=?, Enemies=?, Score=?, Level=?, Door=?, Tree=?, Projectile=?, keyNumber=?, treeNumber=? WHERE ID=1";
            stmt = c.prepareStatement(sql);
            stmt.setDouble(1, Game.getInstance().getPlayer().getX());
            stmt.setDouble(2, Game.getInstance().getPlayer().getY());
            stmt.setInt(3, Game.getInstance().getPlayer().getHp());
            String string = "";
            for(Enemy e : Game.getInstance().getEnemy()){
                string += e.enemyNumber + "," + e.getX()/64 + "," + e.getY()/64 + "," + e.getHp() + ";";
            }
            stmt.setString(4, string);
            stmt.setDouble(5, Game.getInstance().getUi().playTime);
            stmt.setInt(6, Level.level);

            string = "";
            for(SuperObject obj : Game.getInstance().getObjectList()){
                if(obj.name == "door")
                    string += obj.type + "," + (int)obj.getX()/Tile.TILE_WIDTH + "," + (int)obj.getY()/Tile.TILE_HEIGHT + ";";
            }
            stmt.setString(7, string);

            string = "";
            for(SuperObject obj : Game.getInstance().getObjectList()){
                if(obj.name == "tree")
                    string += obj.type + "," + (int)obj.getX()/Tile.TILE_WIDTH + "," + (int)obj.getY()/Tile.TILE_HEIGHT + ";";
            }
            stmt.setString(8, string);

            string = "";
            for(SuperObject obj : Game.getInstance().getObjectList()){
                if(obj.name == "projectile")
                    string += obj.type + "," + (int)obj.getX()/Tile.TILE_WIDTH + "," + (int)obj.getY()/Tile.TILE_HEIGHT + ";";
            }
            stmt.setString(9, string);

            stmt.setInt(10, Game.getInstance().getPlayer().keysNumber);
            stmt.setInt(11, Game.getInstance().getPlayer().treesNumber);

            stmt.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void LoadGame(){
        Statement stmt = null;
        try {

            String sql = "SELECT PlayerX, PlayerY, PlayerHP, Enemies, Score, Level, Door, Tree, Projectile, keyNumber, treeNumber FROM Saves WHERE ID=1";
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Game.getInstance().EndGame();
            Game.getInstance().getPlayer().Player();
            Game.getInstance().getPlayer().load(rs.getDouble("PlayerX"), rs.getDouble("PlayerY"), rs.getInt("PlayerHP"));

            Game.getInstance().getEnemy().clear();
            if(rs.getString("Enemies") != null) {
                for (String str : rs.getString("Enemies").split(";")) {
                    if (str.length() != 0) {
                        String[] s = str.split(",");
                        if (Integer.parseInt(s[0]) != 3)
                            Game.getInstance().getEnemy().add(new Enemy(Double.parseDouble(s[1]), Double.parseDouble(s[2]), Integer.parseInt(s[0]), 2, Integer.parseInt(s[3])));
                        else
                            Game.getInstance().getEnemy().add(new BossEnemy(Double.parseDouble(s[1]), Double.parseDouble(s[2]), Integer.parseInt(s[0]), 2, Integer.parseInt(s[3])));
                    }
                }
            }


            Game.getInstance().getUi().playTime =rs.getInt("Score");

            Level.level =rs.getInt("Level");
            System.out.println(Level.level);
            Level.setLevel(Level.level);
            Level.lv.Load(Level.path_lv);

            Game.getInstance().getObjectList().clear();
            int i = 0;
            if(rs.getString("Door") != null) {
                for (String str : rs.getString("Door").split(";")) {
                    if (str.length() != 0) {
                        String[] s = str.split(",");
                        Game.getInstance().getObjectList().add(new Obj_Door(Integer.parseInt(s[0])));
                        Game.getInstance().getObjectList().get(i).setX(Double.parseDouble(s[1]) * Tile.TILE_WIDTH);
                        Game.getInstance().getObjectList().get(i).setY(Double.parseDouble(s[2]) * Tile.TILE_HEIGHT);
                        i++;
                    }
                }
            }
            if(rs.getString("Tree") != null) {
                for (String str : rs.getString("Tree").split(";")) {
                    if (str.length() != 0) {
                        String[] s = str.split(",");
                        Game.getInstance().getObjectList().add(new Obj_Tree(Integer.parseInt(s[0]), Tile.TILE_WIDTH * 2, Tile.TILE_HEIGHT * 2));
                        Game.getInstance().getObjectList().get(i).setX(Double.parseDouble(s[1]) * Tile.TILE_WIDTH);
                        Game.getInstance().getObjectList().get(i).setY(Double.parseDouble(s[2]) * Tile.TILE_HEIGHT);
                        i++;
                    }
                }
            }
            if(rs.getString("Projectile") != null) {
                for (String str : rs.getString("Projectile").split(";")) {
                    if (str.length() != 0) {
                        String[] s = str.split(",");
                        Game.getInstance().getObjectList().add(new Obj_Projectile(Integer.parseInt(s[0])));
                        Game.getInstance().getObjectList().get(i).setX(Integer.parseInt(s[1]) * Tile.TILE_WIDTH);
                        Game.getInstance().getObjectList().get(i).setY(Integer.parseInt(s[2]) * Tile.TILE_HEIGHT);
                        i++;
                    }
                }
            }

            Game.getInstance().getPlayer().keysNumber =rs.getInt("keyNumber");
            Game.getInstance().getPlayer().treesNumber =rs.getInt("treeNumber");

            Game.getInstance().getContext().setState(Game.getInstance().getStart());
            //Game.getInstance().gameState = Game.getInstance().playState;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void loadLevel(int level){
        Statement stmt = null;
        try{
            System.out.println(Level.level);
            String sql = "SELECT PlayerX, PlayerY, PlayerHP, Enemies, Score, Door, Tree, Projectile, keyNumber, treeNumber FROM Levels WHERE ID=" + Level.level;
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            Level.setLevel(Level.level);
            Level.lv.Load(Level.path_lv);
            Game.getInstance().getPlayer().Player();
            Game.getInstance().getPlayer().type = 0;

            Game.getInstance().EndGame();

            Game.getInstance().getPlayer().load(rs.getDouble("PlayerX"), rs.getDouble("PlayerY"), rs.getInt("PlayerHP"));
            if(Level.level == 1)
                Game.getInstance().getUi().playTime =rs.getInt("Score");
            Game.getInstance().getEnemy().clear();
            if(rs.getString("Enemies") != null) {
                for (String str : rs.getString("Enemies").split(";")) {
                    if (str.length() != 0) {
                        String[] s = str.split(",");
                        if(Integer.parseInt(s[0]) != 3)
                            Game.getInstance().getEnemy().add(new Enemy(Double.parseDouble(s[1]), Double.parseDouble(s[2]), Integer.parseInt(s[0]), 2, Integer.parseInt(s[3])));
                        else
                            Game.getInstance().getEnemy().add(new BossEnemy(Double.parseDouble(s[1]), Double.parseDouble(s[2]), Integer.parseInt(s[0]), 2, Integer.parseInt(s[3])));
                    }
                }
            }

            Game.getInstance().getObjectList().clear();
            int i = 0;
            if(rs.getString("Door") != null) {
                for (String str : rs.getString("Door").split(";")) {
                    if (str.length() != 0) {
                        String[] s = str.split(",");
                        Game.getInstance().getObjectList().add(new Obj_Door(Integer.parseInt(s[0])));
                        Game.getInstance().getObjectList().get(i).setX(Double.parseDouble(s[1]) * Tile.TILE_WIDTH);
                        Game.getInstance().getObjectList().get(i).setY(Double.parseDouble(s[2]) * Tile.TILE_HEIGHT);
                        i++;
                    }
                }
            }
            if(rs.getString("Tree") != null) {
                for (String str : rs.getString("Tree").split(";")) {
                    if (str.length() != 0) {
                        String[] s = str.split(",");
                        System.out.println(Integer.parseInt(s[0]));
                        Game.getInstance().getObjectList().add(new Obj_Tree(Integer.parseInt(s[0]), Tile.TILE_WIDTH * 2, Tile.TILE_HEIGHT * 2));
                        Game.getInstance().getObjectList().get(i).setX(Double.parseDouble(s[1]) * Tile.TILE_WIDTH);
                        Game.getInstance().getObjectList().get(i).setY(Double.parseDouble(s[2]) * Tile.TILE_HEIGHT);
                        i++;
                    }
                }
            }
            if(rs.getString("Projectile") != null) {
                for (String str : rs.getString("Projectile").split(";")) {
                    if (str.length() != 0) {
                        String[] s = str.split(",");
                        Game.getInstance().getObjectList().add(new Obj_Projectile(Integer.parseInt(s[0])));
                        Game.getInstance().getObjectList().get(i).setX(Integer.parseInt(s[1]) * Tile.TILE_WIDTH);
                        Game.getInstance().getObjectList().get(i).setY(Integer.parseInt(s[2]) * Tile.TILE_HEIGHT);
                        i++;
                    }
                }
            }
            Game.getInstance().getPlayer().keysNumber =rs.getInt("keyNumber");
            Game.getInstance().getPlayer().treesNumber =rs.getInt("treeNumber");

            //Game.getInstance().gameState = Game.getInstance().playState;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void close(){
        try{
            c.close();
            System.out.println("DB closed");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
