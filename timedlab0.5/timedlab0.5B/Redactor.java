import java.util.Arrays;
public class Redactor {

    String[] blacklist;

    public Redactor(String[] blacklist) {
        this.blacklist = blacklist;
    }
    public String generateBlackout(int length) {
        String blackout = "";
        for (int i = 0; i < length; i++) {
            blackout += "*";
        }
        return blackout;
    }

    public String redactDocument(String document) {
        String blackedOut = document;

        for (String word : blacklist) {
            blackedOut = blackedOut.replaceAll(word, generateBlackout(word.length()));
        }
        return blackedOut;
    }

    public String[] redactDocuments(String[] documents) {
        String[] docRedact = new String[documents.length];

        for (int i = 0; i < documents.length; i++) {
            docRedact[i] = redactDocument(documents[i]);
        }
        return docRedact;
    }

    public static void main(String... args) {
        String[] documents = {"Jason Bourne fell off a building into a river",
            "Aaron Cross was the next step up from Treadstone",
            "This is innocent text", "Can you tell I'm a huge Bourne fan?"};
        String[] blacklist = {"Jason", "Bourne", "Treadstone"};

        Redactor docuRedactor = new Redactor(blacklist);

        String[] docRedact = docuRedactor.redactDocuments(documents);

        System.out.println(Arrays.toString(docRedact));
    }
}
