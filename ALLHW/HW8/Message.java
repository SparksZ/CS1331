import java.util.ArrayList;
import java.time.LocalDateTime;

/**
* This class represents a Message
* @author Zack Sparks
* @version 1.0
*/
public class Message implements Comparable<Message> {
    private Person sender;
    private ArrayList<Person> recipients;
    private String subject;
    private LocalDateTime date;
    private String mBody;

    /**
    * Constructs a Message object.
    * @param sender Person object representing the sender
    * @param recipients ArrayList of Person of the recipients
    * @param subject the String representation of the subject line.
    * @param date LocalDateTime of the message's origin
    * @param mBody The String representation of the message's body
    */
    public Message(Person sender, ArrayList<Person> recipients, String subject,
        LocalDateTime date, String mBody) {

        this.sender = sender;
        this.recipients = recipients;
        this.subject = subject;
        this.date = date;
        this.mBody = mBody;
    }

    /**
    * @param m the Message that to be compared to this object
    * @return int value of comparison.
    */
    public int compareTo(Message m) {
        return -1 * (this.getDate().compareTo(m.getDate()));
    }

    /**
    * @param o the object that to be compared to this object
    * @return boolean value of equality.
    */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Message)) {
            return false;
        }
        Message u = (Message) o;
        return (this.sender.equals(u.getSender())
            && this.subject.equals(u.getSubject())
            && this.recipients.equals(u.getRecipients())
            && this.date.equals(u.getDate())
            && this.mBody.equals(u.getBody()));
    }

    /**
    * @return the hashCode of the Message
    */
    public int hashCode() {
        int answer = 17;
        answer = answer * 31 + this.sender.hashCode();
        answer = answer * 31 + this.subject.hashCode();
        answer = answer * 31 + this.recipients.hashCode();
        answer = answer * 31 + this.mBody.hashCode();
        answer = answer * 31 + this.date.hashCode();

        return answer;
    }

    /**
    * @return the sender of the Message
    */
    public Person getSender() {
        return this.sender;
    }

    /**
    * @return the recipients of the Message
    */
    public ArrayList<Person> getRecipients() {
        return this.recipients;
    }

    /**
    * @return the subject of the Message
    */
    public String getSubject() {
        return this.subject;
    }

    /**
    * @return the body of the Message
    */
    public String getBody() {
        return this.mBody;
    }

    /**
    * @return the datetime of the Message
    */
    public LocalDateTime getDate() {
        return this.date;
    }
}
