import java.util.Scanner;
import java.util.Random;

/**
* This is the driver for the Battlefront simulation
* @author Zack Sparks
* @version 1.0
*/
public class Battlefront {
    private static Scanner in = new Scanner(System.in);
    private static int[] soldiers;

    private static Random rn = new Random();

    /**
    * Drives the simulation
    * @param args Command-line args
    */
    public static void main(String[] args) throws Exception {

        boolean battleOn = true;

        PlayMidiAudio playMe = new PlayMidiAudio();

        printWelcome();

        drawBattleLines();

        Rebel nerfHerder = new Rebel(rn.nextInt(70) + 30, rn.nextInt(100),
            rn.nextInt(100), generateRandomIdentifier());

        Trooper banthaBreath = new Trooper(rn.nextInt(70) + 30, rn.nextInt(100),
            rn.nextInt(100), generateRandomIdentifier());

        Simulation deathToTheEmpire = new Simulation(soldiers[0], soldiers[1],
            soldiers[2], soldiers[3], nerfHerder, banthaBreath);

        while (battleOn) {
            System.out.println("Press enter to begin skirmish");
            in.nextLine();
            battleOn = deathToTheEmpire.simulateSkirmish(false);
        }

        printWinner(deathToTheEmpire);
    }

    /**
    * Asks user to input number of each type of soldiers
    */
    private static void drawBattleLines() {
        soldiers = new int[4];
        System.out.println("Howdy flyboy! You've surveyed the battle lines"
            + " now input your counts of the forces on each side...");

        System.out.println("How many Rebel Soldiers?");
        soldiers[0] = querySoldierNumber();
        System.out.println();

        System.out.println("How many Jedi?");
        soldiers[1] = querySoldierNumber();
        System.out.println();

        System.out.println("How many Stormtoopers?");
        soldiers[2] = querySoldierNumber();
        System.out.println();

        System.out.println("How many Sith?");
        soldiers[3] = querySoldierNumber();
        System.out.println();
    }

    private static int querySoldierNumber() {

        while (!(in.hasNextInt())) {
            System.out.println("Soldier number must be an Integer! "
                + "Try again Bantha Poodoo!");
            in.next();
        }

        return in.nextInt();
    }


    /**
     * Generates a RANDOM identifer with the form XX-##. (e.g. AQ-72).
     *
     * @return The identifier.
     */
    private static String generateRandomIdentifier() {
        return "" + (char) (rn.nextInt(26) + 'A')
                + (char) (rn.nextInt(26) + 'A')
               + "-" + rn.nextInt(9) + +rn.nextInt(9);
    }

    private static void printWinner(Simulation deathToTheEmpire) {
        int rebelsRem = deathToTheEmpire.getNumRebellionRemaining();
        int empRem = deathToTheEmpire.getNumEmpireRemaining();
        int rebRem = deathToTheEmpire.getNumRebelsRemaining();
        int jediRem = deathToTheEmpire.getNumJediRemaining();
        int troopRem = deathToTheEmpire.getNumTroopersRemaining();
        int sithRem = deathToTheEmpire.getNumSithRemaining();


        if (rebelsRem > empRem) {
            printRebelsWin();

            if (empRem == 0) {
                System.out.println("All empire scum have been eviscerated!");
            } else {
                System.out.println("Ha! Those sissy empire poodoos are retreat"
                    + "ing!");
            }
        } else {
            printEmpireWins();

            if (rebelsRem == 0) {
                System.out.println("We've been obliterated, none of our kind"
                    + " survived!");
            } else {
                System.out.println("Retreat! We need to save what we have left,"
                    + " regroup and go at it again!");
            }
        }

        System.out.printf("%3d of %3d Rebel Soldiers remain!\n", rebRem,
            soldiers[0]);
        System.out.printf("%3d of %3d Jedi remain!\n", jediRem,
            soldiers[1]);
        System.out.printf("%3d of %3d Stormtroopers remain!\n", troopRem,
            soldiers[2]);
        System.out.printf("%3d of %3d Sith remain!\n", sithRem,
            soldiers[3]);
    }

    /**
    * Prints a welcome in ASCII Word ART
    */
    private static void printWelcome() {

        String welcome = "_____________________________________________________"
            + "___ \n"
            + "         __       __)                          \n"
            + "        (, )  |  /          /)                 \n"
            + "           | /| /       _  //   _  ______    _ \n"
            + "           |/ |/      _(/_(/_  (__(_) // (__(/_\n"
            + "           /  | \n";

        String to = "                  \n"
            + "                        _/_  ___\n"
            + "                        (__ (_) \n"
            + "                        \n"
            + "                                \n";

        String battlefront = "   ______                                        "
            + "       \n"
            + "  (, /    )               /)         /)                 \n"
            + "    /---(    _  _/_ _/_  //    _    //   __  _____  _/_ \n"
            + " ) / ____)  (_(_(__ (__ (/_  _(/_  /(_  / (_(_) / (_(__ \n"
            + "(_/ (                             /)                    \n"
            + "                                 (/                     \n";

        String simulator = "            __                                   \n"
            + "        (__/__)   ,            /)                 \n"
            + "          /         ___       //   _  _/_  ___ __ \n"
            + "       ) /      _(_ // (_(_(_(/_  (_(_(__ (_) / (_\n"
            + "      (_/                                         \n"
            + "_____________________________________________________"
            + "___";

        System.out.println(welcome);
        try {
            Thread.sleep(333);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        System.out.println(to);

        try {
            Thread.sleep(333);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        System.out.println(battlefront);

        try {
            Thread.sleep(333);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        System.out.println(simulator);
    }

    private static void printRebelsWin() {

        String rebels = ""
            + "            .___________. __    __   _______                \n"
            + "            |           ||  |  |  | |   ____|               \n"
            + "            `---|  |----`|  |__|  | |  |__                  \n"
            + "                |  |     |   __   | |   __|                 \n"
            + "                |  |     |  |  |  | |  |____                \n"
            + "                |__|     |__|  |__| |_______|               \n"
            + "                                                           \n"
            + ".______       _______ .______    _______  __           _______."
            + "\n"
            + "|   _  \\     |   ____||   _  \\  |   ____||  |         /       "
            + "|\n"
            + "|  |_)  |    |  |__   |  |_)  | |  |__   |  |        |   (----`"
            + "\n"
            + "|      /     |   __|  |   _  <  |   __|  |  |         \\   \\   "
            + " \n"
            + "|  |\\  \\----.|  |____ |  |_)  | |  |____ |  `----..----)   |  "
            + "\n"
            + "| _| `._____||_______||______/  |_______||_______||_______/    "
            + "\n"
            + "                                                               ";
        String win = ""
            + "             ____    __    ____  __  .__   __. \n"
            + "             \\   \\  /  \\  /   / |  | |  \\ |  | \n"
            + "              \\   \\/    \\/   /  |  | |   \\|  | \n"
            + "               \\            /   |  | |  . `  | \n"
            + "                \\    /\\    /    |  | |  |\\   | \n"
            + "                 \\__/  \\__/     |__| |__| \\__| \n"
            + "                                               ";

        System.out.println(rebels);
        System.out.println(win);
    }

    private static void printEmpireWins() {
        String empire = ""
            + "         .___________. __    __   _______                \n"
            + "         |           ||  |  |  | |   ____|               \n"
            + "         `---|  |----`|  |__|  | |  |__                  \n"
            + "             |  |     |   __   | |   __|                 \n"
            + "             |  |     |  |  |  | |  |____                \n"
            + "             |__|     |__|  |__| |_______|               \n"
            + "                                                         \n"
            + " _______ .___  ___. .______    __  .______       _______ \n"
            + "|   ____||   \\/   | |   _  \\  |  | |   _  \\     |   ____|\n"
            + "|  |__   |  \\  /  | |  |_)  | |  | |  |_)  |    |  |__   \n"
            + "|   __|  |  |\\/|  | |   ___/  |  | |      /     |   __|  \n"
            + "|  |____ |  |  |  | |  |      |  | |  |\\  \\----.|  |____ \n"
            + "|_______||__|  |__| | _|      |__| | _| `._____||_______|\n"
            + "                                                         \n"
            + "    ____    __    ____  __  .__   __.      _______.       \n"
            + "    \\   \\  /  \\  /   / |  | |  \\ |  |     /       |       \n"
            + "     \\   \\/    \\/   /  |  | |   \\|  |    |   (----`       \n"
            + "      \\            /   |  | |  . `  |     \\   \\           \n"
            + "       \\    /\\    /    |  | |  |\\   | .----)   |          \n"
            + "        \\__/  \\__/     |__| |__| \\__| |_______/           \n"
            + "                                                          ";

        System.out.println(empire);
    }

}
