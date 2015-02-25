import java.io.File;
import java.util.Scanner;

public class GradeHistogram {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String fileName;
        int binSize = 0;
        int argsFlag = 0;

        fileName = args[0];

        String fullCSV = csvToString(fileName);
        int lines = countLines(fullCSV);
        int[] grades = stringToIntArray(fullCSV, lines);
        System.out.println("Grades loaded!");

        if (args.length == 1) {
            System.out.println("What bucket size would you like?");
            System.out.print(">>> ");
            binSize = in.nextInt();
        } else {
            binSize = Integer.parseInt(args[1]);
        }

        int[] histogramData = createHistoArray(grades, binSize);
        printHistoArray(histogramData, binSize);
    }

    private static String csvToString(String fileName) throws Exception {
        File file = new File(fileName);
        Scanner fileIn = new Scanner(file);
        String fullCSV = fileIn.nextLine();
        while (fileIn.hasNext()) {
            String currentLine = fileIn.nextLine();
            fullCSV = fullCSV + "\n" + currentLine;
        }

        return fullCSV;
    }

    private static int countLines(String str) {
        String[] lines = str.split("\n");
        return lines.length;
    }

    private static int[] stringToIntArray(String nameGrades, int lines) {
        String csvSplitBy = ", ";
        int[] grades = new int[lines];

        Scanner s = new Scanner(nameGrades);

        for (int i = 0; i < lines; i++) {
            String currentLine = s.nextLine();
            String[] lineArray = currentLine.split(csvSplitBy);
            grades[i] = Integer.parseInt(lineArray[1]);
        }

        return grades;
    }

    private static int[] createHistoArray(int[] grades, int binSize) {
        int binNumber = 100 / binSize + 1;
        int lastBinSize = 101 % binSize;

        int[] histogramData = new int[binNumber];
        for (int grade: grades) {
            int bin = (int) Math.ceil((((double) grade - lastBinSize) / binSize)
                + 1);
            if (((grade - lastBinSize) % binSize) == 0 && binSize != 1) {
                histogramData[bin]  += 1;
            } else {
                histogramData[bin - 1] += 1;
            }
        }

        return histogramData;
    }

    private static void printHistoArray(int[] histoArray, int binSize) {
        int hLength = histoArray.length;
        System.out.println(); // Matching the example format!

        for (int i = hLength - 1; i >= 0; i--) {
            System.out.printf("%3s", (100 - binSize * (hLength - i - 1)));
            System.out.print(" - ");
            if ((100 - binSize * (hLength - i) + 1) < 0)  {
                System.out.printf("%3s | ", "0");
            } else {
                System.out.printf("%3s | ", 100 - binSize * (hLength - i) + 1);
            }

            for (int j = 0; j < histoArray[i]; j++) {
                System.out.print("[]");
            }
            System.out.println();
        }
    }
}
