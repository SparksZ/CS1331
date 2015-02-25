public class Animal {

    private String name;

    /**
    * Constructs an Animal with a name
    *
    * @param name The name of the pooch
    */
    public Animal(String name) {

        setName(name);
    }

    /**
    * sets the name
    *
    * @param name name of dog
    */
    public void setName(String name) {

        this.name = name;
    }

    /**
    * gets the name
    */
    public String getName() {

        return name;
    }

    /**
    * @return string representation of Animal sound
    */
    public void speak() {

        return "Hi I'm an Animal!";
    }
}
