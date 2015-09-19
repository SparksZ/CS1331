import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import java.util.ArrayList;
import java.time.Duration;
import java.io.IOException;

/**
* This class represents a Server which creates messages at random.
* @author Zack Sparks
* @version 1.0
*/
public class Server {
    private Random r = new Random();
    private RandName rn;

    /**
    * Constructs a Server object.
    */
    public Server() {
        try {
            rn = new RandName("boyNames.csv", "girlNames.csv",
                "lastNames.csv");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
    * @return a random first and last name
    */
    private String getName() {
        String fName;
        String lName;
        if (r.nextFloat() < 0.5) {
            fName = rn.getMalName();
        } else {
            fName = rn.getFemName();
        }

        lName = rn.getLastName();

        return (fName + " " + lName);
    }

    /**
    * @param name the first and last name of a person
    * @return email address from a given first and last name
    */
    private String getEmailAddress(String name) {
        int lStart = name.indexOf(" ") + 1;

        return name.substring(0, 1) + name.substring(lStart)
            + "@jacketRacketeering.us";
    }

    /**
    * @return returns random string of garbled text for a subject line.
    */
    private String getSubject() {
        return UUID.randomUUID().toString();
    }

    private String getBody() {
        String bod = "";

        for (int i = 0; i < r.nextInt(10) + 1; i++) {
            bod += UUID.randomUUID().toString();
        }

        return bod;
    }

    /**
    * @return a message object
    */
    public Message getMessage() {
        ArrayList<Person> recips = new ArrayList<Person>();
        String s = this.getName();
        Person sender = new Person(s, this.getEmailAddress(s));

        for (int i = 0; i < r.nextInt(10) + 1; i++) {
            String n = this.getName();
            recips.add(new Person(n,
                this.getEmailAddress(n)));
        }

        return new Message(sender, recips, this.getSubject(),
            LocalDateTime.now().minus(Duration.ofHours((long) r.nextInt(1000))),
            this.getBody());
    }

    /**
    * @param x the number of random message to generate.
    * @return a ArrayList of Message of random messages of length x
    */
    public ArrayList<Message> getMessages(int x) {
        int count = 0;
        ArrayList<Message> result = new ArrayList<>();

        while (count < x) {
            Message temp = this.getMessage();
            result.add(temp);
            count++;
        }

        return result;
    }
}
