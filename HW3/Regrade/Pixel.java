/**
* This class represents a Pixel.
* @author Zack Sparks
* @version 1.0
*/
public class Pixel {

    private int red;
    private int green;
    private int blue;
    private int alpha;

    /**
    * Constructs a Pixel with RGBA values.
    *
    * @param red value of red between 0 and 255
    * @param green value of green between 0 and 255
    * @param blue value of blue between 0 and 255
    * @param alpha value of alph between 0 and 255
    */
    public Pixel(int red, int green, int blue, int alpha) {
        if (isValid(red) && isValid(green) && isValid(blue) && isValid(alpha)) {
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.alpha = alpha;
        } else {
            String msg = "Please enter a valid number for each parameter 0 to"
                + " 255";
            throw new IllegalArgumentException(msg);
        }
    }

    private static boolean isValid(int someParameter) {
        return (someParameter >= 0 && someParameter <= 255);
    }

    /**
    * Returns the value of red for an instance of Pixel
    * @return the value of red
    */
    public int getRed() {
        return this.red;
    }

    /**
    * Returns the value of green for an instance of Pixel
    * @return the value of green
    */
    public int getGreen() {
        return this.green;
    }

    /**
    * Returns the value of blue for an instance of Pixel
    * @return the value of blue
    */
    public int getBlue() {
        return this.blue;
    }

    /**
    * Returns the value of alpha for an instance of Pixel
    * @return the value of alpha
    */
    public int getAlpha() {
        return this.alpha;
    }

    /**
    * Updates the value of red for an instance of Pixel
    * @param red value of red between 0 and 255
    */
    public void setRed(int red) {
        if (isValid(red)) {
            this.red = red;
        } else {
            String msg = "Please enter a valid number 0 to 255";
            throw new IllegalArgumentException(msg);
        }
    }

    /**
    * Updates the value of green for an instance of Pixel
    * @param green value of green between 0 and 255
    */
    public void setGreen(int green) {
        if (isValid(green)) {
            this.green = green;
        } else {
            String msg = "Please enter a valid number 0 to 255";
            throw new IllegalArgumentException(msg);
        }
    }

    /**
    * Updates the value of blue for an instance of Pixel
    * @param blue value of blue between 0 and 255
    */
    public void setBlue(int blue) {
        if (isValid(blue)) {
            this.blue = blue;
        } else {
            String msg = "Please enter a valid number 0 to 255";
            throw new IllegalArgumentException(msg);
        }
    }

    /**
    * Updates the value of alpha for an instance of Pixel
    * @param alpha value of alpha between 0 and 255
    */
    public void setAlpha(int alpha) {
        if (isValid(alpha)) {
            this.alpha = alpha;
        } else {
            String msg = "Please enter a valid number 0 to 255";
            throw new IllegalArgumentException(msg);
        }
    }
}
