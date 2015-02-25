/**
* This class modifies a single Pic object
* @author Zack Sparks
* @version 1.0
*/
public class ImageProcessor {

    private Pic myPic;
    private int width;
    private int height;
    private Pixel[][] myPixArray;

    /**
    * Constructs an ImageProcessor for a Pic object
    *
    * @param myPic Pic object to be altered
    */
    public ImageProcessor(Pic myPic) {

        myPixArray = myPic.getPixels();
        this.myPic = myPic;
        this.width = myPic.getWidth();
        this.height = myPic.getHeight();
    }

    /**
    * Adds the specified value to each of the RGB channels in each pixel of
    * myPic.
    * @param increment Value to be added to each of the RGB channels in myPic
    * @return altered Pic object
    */
    public Pic add(int increment) {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                myPixArray[i][j] = incrementRGB(myPixArray[i][j], increment);
            }
        }

        return myPic.deepCopy();
    }

    /**
    * Multiplies the specified value by each of the RGB channels in each pixel
    * of myPic.
    * @param multiple Value to be multiplies by each of the RGB channels in
    * myPic
    * @return altered Pic object
    */
    public Pic multiply(double multiple) {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                myPixArray[i][j] = scaleRGB(myPixArray[i][j], multiple);
            }
        }

        return myPic.deepCopy();
    }

    /**
    * Loops through each pixel in myPic and sets all channels, RGBA, to 0 if
    * the Pixel's values are within the tolerance specified by the user
    * @param key Pixel object to compare each pixel in myPic to
    * @param dr red tolerence (+/-)
    * @param dg green tolerence (+/-)
    * @param db blue tolerence (+/-)
    * @return altered Pic object
    */
    public Pic chroma(Pixel key, int dr, int dg, int db) {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                myPixArray[i][j] = modifyChroma(myPixArray[i][j], key, dr, dg,
                db);
            }
        }

        return myPic.deepCopy();
    }

        /**
        * Loops through each pixel in myPic and copies the pixel from the given
        * bg Pic object if the alpha value is 0
        * @param bg Pic object that myPic is to be superimposed onto
        * @return altered Pic object
        */
    public Pic background(Pic bg) {
        Pixel[][] bgArray = bg.getPixels();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Pixel thisPixel = myPixArray[i][j];

                if (thisPixel.getAlpha() == 0 && thisPixel.getRed() == 0
                    && thisPixel.getRed() == 0 && thisPixel.getGreen() == 0) {
                    myPixArray[i][j] = bgArray[i][j];
                }
            }
        }

        return myPic.deepCopy();
    }

    private Pixel incrementRGB(Pixel p, int modifier) {

        if (modifier + p.getRed() > 255) {
            p.setRed(255);
        } else if (modifier + p.getRed() < 0) {
            p.setRed(0);
        } else {
            p.setRed(p.getRed() + modifier);
        }

        if (modifier + p.getGreen() > 255) {
            p.setGreen(255);
        } else if (modifier + p.getGreen() < 0) {
            p.setGreen(0);
        } else {
            p.setGreen(p.getGreen() + modifier);
        }

        if (modifier + p.getBlue() > 255) {
            p.setBlue(255);
        } else if (modifier + p.getBlue() < 0) {
            p.setBlue(0);
        } else {
            p.setBlue(p.getBlue() + modifier);
        }

        return p;
    }

    private Pixel scaleRGB(Pixel p, double multiple) {

        if (multiple * p.getRed() > 255) {
            p.setRed(255);
        } else if (multiple * p.getRed() < 0) {
            p.setRed(0);
        } else {
            p.setRed((int) (p.getRed() * multiple));
        }

        if (multiple * p.getGreen() > 255) {
            p.setGreen(255);
        } else if (multiple * p.getGreen() < 0) {
            p.setGreen(0);
        } else {
            p.setGreen((int) (p.getGreen() * multiple));
        }

        if (multiple * p.getBlue() > 255) {
            p.setBlue(255);
        } else if (multiple * p.getBlue() < 0) {
            p.setBlue(0);
        } else {
            p.setBlue((int) (p.getBlue() * multiple));
        }

        return p;
    }

    private Pixel modifyChroma(Pixel pixTemp, Pixel key, int dr, int dg, int
        db) {

        boolean r = Math.abs(pixTemp.getRed() - key.getRed()) < dr;
        boolean g = Math.abs(pixTemp.getGreen() - key.getGreen()) < dg;
        boolean b = Math.abs(pixTemp.getBlue() - key.getBlue()) < db;

        if (r && b && g) {
            pixTemp.setRed(0);
            pixTemp.setGreen(0);
            pixTemp.setBlue(0);
            pixTemp.setAlpha(0);
        }

        return pixTemp;
    }
}
