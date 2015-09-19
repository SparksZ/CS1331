import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
* This class generates random first and last names.
* @author Zack Sparks
* @version 1.0
*/
public class RandName {
    private String[] boysNames = new String[1000];
    private String[] girlsNames = new String[1000];
    private String[] lastNames = new String[1000];
    private int femCount = 0;
    private int malCount = 0;
    private int lastCount = 0;

    /**
    * Constructs a RandName object that is able to output a random array of boys
    * , girls and last names.
    * @param boysFileName this is carriage return separated file of boys names
    * @param girlsFileName this is carriage return separated file of girl names
    * @param lastFileName this is carriage return separated file of last names
    */
    public RandName(String boysFileName, String girlsFileName,
        String lastFileName) throws
        IOException {

        Scanner inBoys = new Scanner(new File(boysFileName)).useDelimiter("\n");
        Scanner inGirls = new Scanner(new File(girlsFileName)).
            useDelimiter("\n");
        Scanner inLasts = new Scanner(new File(lastFileName)).
            useDelimiter("\n");

        int count = 0;

        while (inBoys.hasNext()) {
            boysNames[count] = inBoys.next().trim();
            count++;
        }

        count = 0;

        while (inGirls.hasNext()) {
            girlsNames[count] = inGirls.next().trim();
            count++;
        }

        count = 0;

        while (inLasts.hasNext()) {
            String temp = inLasts.next().trim();
            lastNames[count] = temp.substring(0, 1)
                + temp.substring(1).toLowerCase();
            count++;
        }
    }

    /**
    * @param x number of names to randomly get
    * @return an array of size X of names of random gender (on average 33%
    *   female)
    */
    public String[] getXNames(int x) {
        Random rn = new Random();
        int count = 0;
        int[] shuffle = new int[x];
        String[] names = new String[x];

        while (count < x) {
            int temp = rn.nextInt(999);

            if (!(Arrays.asList(shuffle).contains(temp))) {
                shuffle[count] = temp;
                count++;
            }
        }

        int iName = 0;

        for (String name : names) {
            double monteRollo = Math.random();

            if (monteRollo < 0.34) {
                names[iName] = this.girlsNames[shuffle[iName]];
            } else {
                names[iName] = this.boysNames[shuffle[iName]];
            }

            iName++;
        }

        return names;
    }

    /**
    * @param x number of names to randomly get
    * @return an array of last names
    */
    public String[] getXLastNames(int x) {
        Random rn = new Random();
        int count = 0;
        int[] shuffle = new int[x];
        String[] names = new String[x];

        while (count < x) {
            int temp = rn.nextInt(999);

            if (!(Arrays.asList(shuffle).contains(temp))) {
                shuffle[count] = temp;
                count++;
            }
        }

        int iName = 0;

        for (String name : names) {
            names[iName] = this.lastNames[shuffle[iName]];
            iName++;
        }

        return names;
    }

    /**
    * @return a random female first name
    */
    public String getFemName() {
        if (femCount > 999) {
            femCount = 0;
        }
        return girlsNames[femCount++];
    }

    /**
    * @return a random male first name
    */
    public String getMalName() {
        if (malCount > 999) {
            malCount = 0;
        }
        return boysNames[malCount++];
    }

    /**
    * @return a random last name
    */
    public String getLastName() {
        if (lastCount > 999) {
            lastCount = 0;
        }
        return lastNames[lastCount++];
    }
}
