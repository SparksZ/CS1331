import java.io.IOException;
/**
* The driver for ImageProcessor, Pic and Pixel classes
* @author Zack Sparks
* @version 1.0
*/
public class Photoslop {

    /**
    * A method that allows you to either add, multiply or greenscreen an image
    * @param args 1) Either "-a" for add mode, "-m" for multiply mode or
    * "c" for greenscreen mode. 2) ImageFile Specify the filename of image to be
    * altered. 3) if -a or -m are used is the increment or multiple, or if -c
    * mode is used specify the filename of the background image that the first
    * is to be superimposed upon. 4) specify output filename for the altered
    * image.
    */
    public static void main(String... args) throws IOException {
        if (args.length < 4) {
            printUsage();
            System.exit(0);
        }
        try {
            Pic thisPic = new Pic(args[1]);
            ImageProcessor thisProcessor = new ImageProcessor(thisPic);

            if (args[0].equals("-a")) {
                thisPic = thisProcessor.add(Integer.parseInt(args[2]));
                thisPic.save(args[3]);
            } else if (args[0].equals("-m")) {
                thisPic = thisProcessor.multiply(Double.parseDouble(args[2]));
                thisPic.save(args[3]);
            } else if (args[0].equals("-c")) {
                Pixel chromaKey = new Pixel(26, 185, 19, 1);
                Pic backlessFront;
                Pic backImage = new Pic(args[2]);

                backlessFront = thisProcessor.chroma(chromaKey, 20, 40, 20);
                thisPic = thisProcessor.background(backImage);

                thisPic.save(args[3]);
            } else {
                printUsage();
            }
        } catch (IOException ex) {
            System.out.println("One of the files you referenced does not exist,"
                + " or is corrupted. Double-check and try again.");
        }
    }

    private static void printUsage() {
        System.out.println("Add mode: ");
        System.out.println("java -a imageFile n outputFile");
        System.out.println("");
        System.out.println("Multiply mode: ");
        System.out.println("java -m imageFile n outputFile");
        System.out.println("");
        System.out.println("Greenscreen mode: ");
        System.out.println("java -c imageFile backgroundFile outputFile");
    }
}
