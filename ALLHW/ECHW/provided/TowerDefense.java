import java.awt.MouseInfo;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This is the TowerDefense Application
 * @version 1.0
 * @author Zack Sparks
 */
public class TowerDefense extends Application {
    private Image turretImage;
    private Image enemyImage;
    private Image bombImage;

    private ArrayList<Turret> turrets = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Projectile> projectiles = new ArrayList<>();
    private House house = new House();
    private ProgressBar houseHealth = new ProgressBar();

    private Group root;
    private Scene scene;

    private Pane spriteLayer;

    private Point p = MouseInfo.getPointerInfo().getLocation();

    /**
     * This is the main method
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Overrides Application's start method
     * @param stage the stage to be shown
     */
    public void start(Stage stage) {
        root = new Group();
        spriteLayer = new Pane();

        stage.setTitle("TowerDefense");
        stage.setResizable(false);

        scene = new Scene(root, 1376, 736);

        File background = new File("MapCropped.png");
        File foreground = new File("MapCroppedForeground.png");
        File bomba = new File("bomb.gif");

        Image backgroundIm = new Image(background.toURI().toString());
        ImageView iv = new ImageView(backgroundIm);

        Image foregroundIm = new Image(foreground.toURI().toString());
        ImageView ivF = new ImageView(foregroundIm);

        bombImage = new Image(bomba.toURI().toString());


        scene.addEventFilter(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {
                    placeTurret(mouseEvent.getX(), mouseEvent.getY());
                }
            });


        houseHealth.setProgress(1.0F);
        root.getChildren().add(iv);
        root.getChildren().add(spriteLayer);
        root.getChildren().add(houseHealth);
        root.getChildren().add(ivF);
        stage.setScene(scene);
        stage.show();

        loadGame();

        spawnEnemy();

        houseHealth.relocate(1120 - houseHealth.getWidth() * 0.5, 56);
        houseHealth.setProgress(1.0F);

        AnimationTimer gameLoop = new AnimationTimer() {

            public void handle(long now) {

                if (now % 500 == 0) {
                    spawnEnemy();
                }

                enemies.forEach(sprite -> sprite.move());
                enemies.forEach(sprite -> sprite.updateUI());
                enemies.forEach(sprite -> sprite.strike());
                enemies.forEach(sprite -> sprite.checkRemovability());

                houseHealth.setProgress(house.getHitPoints() * 1.0
                    / house.getMaxHealth());

                if (now % 25 == 0) {
                    if (enemies.size() != 0) {
                        turrets.forEach(sprite -> projectiles.add(
                            sprite.shoot(spriteLayer, bombImage, enemies)
                        ));
                    }
                }

                projectiles.forEach(sprite -> sprite.move());
                projectiles.forEach(sprite -> sprite.updateUI());
                projectiles.forEach(sprite -> sprite.strike());
                projectiles.forEach(sprite -> sprite.checkRemovability());


                removeSprites(projectiles);
                removeSprites(enemies);

                if (!house.isAlive()) {
                    projectiles.removeAll(projectiles);
                    enemies.removeAll(enemies);
                    Label gameOver = new Label("GAME OVER");
                    gameOver.setFont(Font.font("Arial", 125));
                    root.getChildren().add(gameOver);
                }
            }
        };
        gameLoop.start();
    }

    /**
     * This loads the sprite images into memory
     */
    private void loadGame() {
        File turretFile = new File("launcher.png");
        turretImage = new Image(turretFile.toURI().toString());

        File enemyFile = new File("pixel-Alien-7.png");
        enemyImage = new Image(enemyFile.toURI().toString());
    }


    /**
     * Creates a new enemy object and adds it to the List of enemies
     */
    private void spawnEnemy() {
        Enemy enemy = new Enemy(spriteLayer,
            enemyImage,
            Settings.ENEMY_START_X,
            Settings.ENEMY_START_Y,
            Settings.ENEMY_SPEED,
            0,
            house);

        enemies.add(enemy);
    }

    /**
     * Creates a new turret that is centered at (x, y)
     * @param x the x coordinate of the turret sprite's left edge
     * @param y the y coordinate of the turret sprite's top edge
     */
    private void placeTurret(double x, double y) {

        Turret turret = new Turret(spriteLayer,
            turretImage,
            x - turretImage.getWidth() * 0.5,
            y - turretImage.getHeight() * 0.5);

        turrets.add(turret);
    }

    /**
     * This removes all sprites in the passed list from the sprite layer
     * @param spriteList this is the list of specific sprites (enemies, turrets,
        etc.)
     */
    private void removeSprites(List<? extends SpriteBase> spriteList) {
        Iterator<? extends SpriteBase> iter = spriteList.iterator();
        while (iter.hasNext()) {
            SpriteBase sprite = iter.next();

            if (sprite.isRemovable()) {
                sprite.removeFromLayer();

                iter.remove();
            }
        }
    }
}
