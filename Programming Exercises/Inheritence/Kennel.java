public class Kennel {

    private int count = 0;
    private Dog[] doggies;
    private ShuffleNIntegers index = new
        ShuffleNIntegers(Dog.getPhraseLength());
    private int[] shuffledIndex = index.getShuffled();

    /**
    * Constructs a Kennel with variable String inputs of dog names
    *
    * @param doges String of dog name.
    */
    public Kennel(String ... doges) {

        doggies = new Dog[doges.length];
        for (int i = 0; i < doggies.length; i++) {
            doggies[i] = new Dog(doges[i]);
        }
    }

    /**
    * Loops through all doges and has them say a random phrase from a phrasebank
    * if there are more doges than phrases then a new ShuffleNIntegers
    * object is constructed to start the indexing all over again.
    */
    public void soundOff() {

        for (Dog dog : doggies) {

            if (count > Dog.getPhraseLength() - 1) {

                count = 0;
                index = new ShuffleNIntegers(Dog.getPhraseLength());
                shuffledIndex = index.getShuffled();
            }

            System.out.println();
            System.out.println();

            System.out.println(dog.getName() + " says, \""
                + dog.speak(shuffledIndex[count]) + "!\" ");
            count++;
        }
    }

    public static void main(String ... args) {
        Kennel puppyHouse = new Kennel(args);

        puppyHouse.soundOff();
    }
}
