import java.util.Scanner;
import java.util.Arrays;

public class PracticeTL {
    public static void main(String[] args) {
        String[] sentences = {"Jason Bourne fell off a building into a river",
            "Aaron Cross was the next step up from Treadstone",
            "This is innocent text", "Can you tell I'm a huge Bourne fan?"};
        String[] blacklist = {"Jason", "Bourne", "Treadstone"};

        System.out.println(java.util.Arrays.toString(
            redactSentences(sentences, blacklist)));
    }

    public static String generateBlackout(int length) {
        String blackout = "";

        for(int i = 0; i < length; i++) {
            blackout = blackout + "*";
        }

        return blackout;
    }

    public static String[] redactSentences(String[] sentences,
        String[] blacklist) {

        String redacted[] = sentences;

        for(int i = 0; i < sentences.length; i++) {
            for(int j = 0; j < blacklist.length; j++) {
                redacted[i] = sentences[i].replaceAll(blacklist[j],
                generateBlackout(blacklist[j].length()));
            }
        }

        return redacted;
    }
}
