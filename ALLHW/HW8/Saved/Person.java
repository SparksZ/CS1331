/**
* This class represents a Person with a Email address
* @author Zack Sparks
* @version 1.0
*/
public class Person implements Comparable<Person> {
    private String name;
    private String email;

    /**
    * Constructs a Person object.
    * @param name First and Last Name od the person
    * @param email email of the person
    */
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
    * Equals method to test equality of possibly equal or unequal objects
    * @param o the object that to be compared to this object
    * @return boolean value of equality.
    */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Person)) {
            return false;
        }
        Person u = (Person) o;

        return (this.getName().equals(u.getName())
            && this.email.equals(u.getEmail()));
    }

    /**
    * @return the name of the person
    */
    public String getName() {
        return this.name;
    }

    /**
    * @return the email of the person
    */
    public String getEmail() {
        return this.email;
    }

    /**
    * @return the hashCode of the person
    */
    public int hashCode() {
        int answer = 17;
        answer = answer * 31 + this.name.hashCode();
        answer = answer * 31 + this.email.hashCode();
        return answer;
    }

    /**
    * @param o the Person that to be compared to this object
    * @return int value of comparison.
    */
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }
}
