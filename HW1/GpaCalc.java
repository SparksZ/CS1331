import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class GpaCalc {
    public static void main(String[] args) throws Exception {
        // This initializes a Scanner object "in"
        Scanner in = new Scanner(System.in);

        // Initialize variable
        char semAgain;

        do {
            // Call the info gathering method!
            processInput();

            // Ask if user wants to put in another semester
            System.out.print("Would you like to enter another semester? (y/"
                + "n): ");
            semAgain = in.next().charAt(0);
            in.nextLine(); // Catch that pesky newline character
        } while (semAgain == 'y');
    }

    public static void processInput() throws Exception {
        // This initializes a Scanner object "in"
        Scanner in = new Scanner(System.in);

        // Get the current directory
        String current = new File(".").getCanonicalPath();

        // Initialize variable
        char courseAgain;

        // Initialize the GPA info for new semester
        double gpaNumerator = 0;
        double gpaDenomenator = 0;

        // Gather the name of the semester and write new file
        System.out.print("Enter the semester: ");
        String semester = in.nextLine();

        // Formats the filename to be all lowercase and no spaces
        semester = semester.toLowerCase();
        semester = semester.replaceAll(" ", "");

        // Creates the semester's file and opens the PrintWriter
        File file = new File(current + "\\" + semester + ".txt");
        PrintWriter out = new PrintWriter(semester + ".txt");

        do {
            // Gather the information
            System.out.print("Enter the course title: ");
            String course = in.nextLine();

            System.out.print("Enter the number of credits: ");
            int creds = in.nextInt();
            in.nextLine();

            System.out.print("Enter the grade (A = 4, B = 3, etc.): ");
            int grade = in.nextInt();

            in.nextLine(); // Catch that pesky newline character

            // Update GPA variables
            gpaNumerator += grade * creds;
            gpaDenomenator += creds;

            // Writes the course info to the semester file
            out.println(course + " - " + creds + " credits. Grade: " + grade
                + "");

            // Checks for more courses and continues if !'y' is inputted
            System.out.print("Would you like to enter another course? (y/n)"
                + ": ");
            courseAgain = in.next().charAt(0); // Just grabs 1st char
            in.nextLine(); // Catch that pesky newline character

        } while (courseAgain == 'y');

        // Calculate the current semester's GPA and writes it to the file
        double totalGPA = gpaNumerator / gpaDenomenator;
        out.printf("GPA: %.2f", totalGPA);
        out.println();
        out.close(); // Close the PrintWriter

        System.out.printf("Overall GPA: %.2f", totalGPA);
        System.out.println();
    }
}
