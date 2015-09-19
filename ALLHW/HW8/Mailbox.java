import java.util.ArrayList;

/**
* This class represents a Mailbox
* @author Zack Sparks
* @version 1.0
*/
public class Mailbox {
    private ArrayList<Message> messages = new ArrayList<Message>();
    private String name;

    /**
    * Constructs a Mailbox object.
    * @param name name of the mailbox
    * @param messages an ArrayList of Message of the messages in the mailbox
    */
    public Mailbox(String name, ArrayList<Message> messages) {
        this.name = name;
        this.messages = messages;
    }

    /**
    * @return the name of the Mailbox
    */
    public String getName() {
        return this.name;
    }

    /**
    * @return the ArrayList of Message of the messages
    */
    public ArrayList<Message> getMessages() {
        return this.messages;
    }

    /**
    * @param o the object that to be compared to this object
    * @return boolean value of equality
    */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Mailbox)) {
            return false;
        }
        Mailbox u = (Mailbox) o;
        return (this.name.equals(u.getName())
            && this.messages.equals(u.getMessages()));
    }

    /**
    * @return the hashCode of the person
    */
    public int hashCode() {
        int answer = 17;
        answer = answer * 31 + this.name.hashCode();
        answer = answer * 31 + this.messages.hashCode();

        return answer;
    }
}
