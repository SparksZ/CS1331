import java.util.Random;

public class ShuffleNIntegers {

    private int[] shuffleMe;

    /**
    * Constructs a ShuffleNIntegers with the set of integers from 0 to i - 1
    *
    * @param i the length of the int array to be shuffled
    */
    public ShuffleNIntegers(int i) {

        shuffleMe = new int[i];

        for (int j = 0; j < i; j++) {
            shuffleMe[j] = j;
        }

        shuffleIntArray();
    }

    /**
    * Shuffles the instance int array shuffleMe via Fisher–Yates shuffle
    */
    private void shuffleIntArray() {

        Random rn = new Random();

        for (int i = shuffleMe.length - 1; i > 0; i--) {
            int index = rn.nextInt(i + 1);

            int a = shuffleMe[index];
            shuffleMe[index] = shuffleMe[i];
            shuffleMe[i] = a;
        }
    }

    /**
    * returns the shuffleMe instance variable
    */
    public int[] getShuffled() {

        return shuffleMe;
    }
}
