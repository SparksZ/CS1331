public class Dog extends Animal {

    private static final String[] SPEAKPHRASES =
        {"You know you're ugly when it comes to a group picture and they hand"
            + " you the camera!",
        "Hi I'm Dog!",
        "I think it’s wrong that only one company makes the game Monopoly",
        "The worst time to have a heart attack is during a game of charades",
        "I had to stop drinking, cause I got tired of waking up in my car "
            + "driving 90",
        "The New England Journal of Medicine reports that 9 out of 10 doctors "
            + "agree that 1 out of 10 doctors is an idiot",
        "I had a wonderful childhood, which is tough because it`s hard to "
            + "adjust to a miserable adulthood",
        "Isn't Disney World a People Trap Operated by a Mouse?",
        "A metaphor is like a simile"
    };

    /**
    * Constructs a Dog with a name
    *
    * @param name The name of the pooch
    */
    public Dog(String name) {

        super(name);
    }

    /**
    * Returns a unique random saying while count.length < SPEAKPHRASES.length
    * otherwise shuffles the random array again by constructing new
    * ShufflNIntegers object.
    */
    @Override public String speak(int index) {

        return SPEAKPHRASES[index];
    }

    /**
    * Gets the Dog's name
    */
    public String getName() {

        return super.getName();
    }

    /**
    * Gets the length of the String array with available phrases
    */
    public static int getPhraseLength() {

        return SPEAKPHRASES.length;
    }
}
