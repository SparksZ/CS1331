import java.util.Arrays;

public class HowToPass {

    private int[] exams;
    private double examAverage;
    private int[] timedLabs;
    private double timedLabAverage;
    private int[] homeworks;
    private double homeworkAverage;
    private int percentRemaining;
    private double currentAverage;


    public HowToPass(String currentScores) {
        exams = extractScores("Exams", currentScores);
        examAverage = average(exams);

        homeworks = extractScores("Homeworks", currentScores);
        homeworkAverage = average(homeworks);

        timedLabs = extractScores("Timed Labs", currentScores);
        timedLabAverage = average(timedLabs);

        percentRemaining = 100
            - (exams.length * 15)
            - (homeworks.length * 2)
            - (timedLabs.length * 5)
            - 20;

        currentAverage =
            examAverage * (45.0 / 80)
            + timedLabAverage * (15.0 / 80)
            + homeworkAverage * (20.0 / 80);
    }

    String report() {
        String report = "Given your current scores:" + System.lineSeparator()
            + "Exams: " + Arrays.toString(exams) + System.lineSeparator()
            + "TLs:   " + Arrays.toString(timedLabs) + System.lineSeparator()
            + "HWs:   " + Arrays.toString(homeworks) + System.lineSeparator()
            + String.format("and current average of %4.1f%n",
                            currentAverage)
            + String.format("On remaining assignments you need:%n");

        for (int desired: Arrays.asList(90, 80, 70, 60)) {
            report += String.format("a %4.1f average to finish with a %d.%n",
                requiredRemaining(currentAverage, desired, percentRemaining),
                desired);
        }
        return report;
    }

    double requiredRemaining(double current,
                             double desired,
                             int pctRemaining) {
        double remaining = pctRemaining / 100.0;
        return (desired - ((1 - remaining) * current))
               / remaining;
    }

    // Don't touch anything above this line.
    // Finish implementing all the remaining methods below this line.
    // Don't modify the method signatures.
    // Methods have dummy return values so code compiles.  Modify as necessary.

    static double average(int ... nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }



        return (sum / nums.length);
    }


    int[] extractScores(String label, String currentScores) {
        String clause = extractClause(label, currentScores).replace(label +
         ": ", "");


         String[] scores = clause.split(",");

         int[] scoresInt = new int[scores.length];

         int count = 0;

         for (String score: scores) {
             scoresInt[count] = Integer.parseInt(score.trim());
         }

        return scoresInt;
    }

    String extractClause(String label, String text) {
        String[] clauses = text.split(";");
        String[] trimmed = new String[clauses.length];
        String clause = "";

        for (int i = 0; i < clauses.length; i++) {
            trimmed[i] = clauses[i].trim();
        }


        for (int i = 0; i < trimmed.length; i++) {
            if (trimmed[i].trim().startsWith(label.substring(0,1))) {
                clause += trimmed[i].trim();
            }
        }

        return clause;
    }

    public static void main(String ... args) {
        HowToPass thisSemester = new HowToPass(args[0]);
        System.out.println(thisSemester.report());

    }
}
