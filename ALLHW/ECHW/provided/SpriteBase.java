import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * This is the abstract Sprite that all sprites extend
 * @version 1.0
 * @author Zack Sparks
 */
public abstract class SpriteBase {
    private Image image;
    private ImageView imageView;

    private Pane layer;

    private double x;
    private double y;

    private double dx;
    private double dy;

    private double w;
    private double h;

    private boolean removable = false;
    private boolean canMove = true;

    /**
     * Constructs a new SpriteBase object
     * @param layer the Pane that the new SpriteBase will be added to
     * @param image the Image object that will be the sprite in the game
     * @param x the center x coordinate of the SpriteBase object
     * @param y the center y coordinate of the SpriteBase object
     * @param dx the x velocity of the SpriteBase
     * @param dy the y velocity of the SpriteBase
     */
    public SpriteBase(Pane layer, Image image, double x, double y,
        double dx, double dy) {

        this.layer = layer;
        this.image = image;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;

        this.imageView = new ImageView(image);
        this.imageView.relocate(x, y);

        this.w = image.getWidth();
        this.h = image.getHeight();

        addToLayer();
    }

    /**
     * Adds this SpriteBase's ImageView to the Pane
     */
    public void addToLayer() {
        this.layer.getChildren().add(this.imageView);
    }

    /**
     * Removes this SpriteBase's ImageView to the Pane
     */
    public void removeFromLayer() {
        this.layer.getChildren().remove(this.imageView);
    }

    /**
     * @return this SpriteBase's Pane, layer
     */
    public Pane getLayer() {
        return layer;
    }

    /**
     * Sets this SpriteBase's Pane, layer
     * @param layer the Pane that layer is to be set to
     */
    public void setLayer(Pane layer) {
        this.layer = layer;
    }

    /**
     * @return the left edge x coordinate
     */
    public double getX() {
        return x + w * 0.5;
    }

    /**
     * @return the top edge y coordinate
     */
    public double getY() {
        return y + h * 0.5;
    }

    /**
     * Set the left edge x coordinate
     * @param x the new left edge x coordinate
     */
    public void setX(double x) {
        this.x = x + w * 0.5;
    }

    /**
     * Set the top edge y coordinate
     * @param y the new top edge y coordinate
     */
    public void setY(double y) {
        this.y = y + h * 0.5;
    }

    /**
     * @return the x direction velocity
     */
    public double getDX() {
        return dx;
    }

    /**
     * @return the y direction velocity
     */
    public double getDY() {
        return dy;
    }

    /**
     * Sets a new x direction velocity
     * @param dXNew the new x direction velocity
     */
    public void setDX(double dXNew) {
        this.dx = dXNew;
    }

    /**
     * Sets a new y direction velocity
     * @param dYNew the new y direction velocity
     */
    public void setDY(double dYNew) {
        this.dy = dYNew;
    }

    /**
     * @return whether or not this should be removed from the stage
     */
    public boolean isRemovable() {
        return removable;
    }

    /**
     * Sets the removability of the object
     * @param removable whether or not this should be removed from the stage
     */
    public void setRemovable(boolean removable) {
        this.removable = removable;
    }

    /**
     * Moves the object on frame based on dx and dy
     */
    public void move() {
        if (!canMove) {
            return;
        }

        x += dx;
        y += dy;
    }

    /**
     * @return the ImageView for this object
     */
    public ImageView getView() {
        return imageView;
    }

    /**
     * relocates the sprite based on the current x, y coordinates
     *  is called after move()
     */
    public void updateUI() {
        imageView.relocate(x, y);
    }

    /**
     * @return the width for this object
     */
    public double getWidth() {
        return w;
    }

    /**
     * @return the height for this object
     */
    public double getHeight() {
        return h;
    }

    /**
     * @return the center x coordinate for this object
     */
    public double getCenterX() {
        return x + w * 0.5;
    }

    /**
     * @return the center y coordinate for this object
     */
    public double getCenterY() {
        return y + h * 0.5;
    }

    /**
     * Sets the removability to true and will be removed at the end of this
     *  frame
     */
    public void remove() {
        setRemovable(true);
    }

    /**
     * Checks whether this Sprite should be removed
     */
    public abstract void checkRemovability();
}
