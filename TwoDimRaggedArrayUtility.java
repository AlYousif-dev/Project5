import java.util.*;
import java.io.*;

/* 
 * Class: CMSC203  
 * Instructor: Gary Thai
 * Description: Utility class for working with ragged 2D arrays  
 * Due: 11/21/2025 
 * Platform/compiler: Eclipse: Java 21
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source.  
 * I have not given my code to any student. 
 * Print your Name here: Yousif Aluobaidy
*/

public class TwoDimRaggedArrayUtility {

    /** Calculates the average of all elements in a ragged 2D array. */
    public static double getAverage(double[][] data) {
        double sum = 0;
        int count = 0;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j];
                count++;
            }
        }
        return sum / (double) count;
    }

    /** Returns the sum of all values in a particular column. */
    public static double getColumnTotal(double[][] data, int col) {
        double sum = 0;

        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {   // IMPORTANT: skip missing columns
                sum += data[i][col];
            }
        }
        return sum;
    }

    /** Finds the highest value in the array. */
    public static double getHighestInArray(double[][] data) {
        double max = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] > max) {
                    max = data[i][j];
                }
            }
        }
        return max;
    }

    /** Gets the highest value in a specific column. */
    public static double getHighestInColumn(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {   // REQUIRED for ragged arrays
                if (data[i][col] > max) {
                    max = data[i][col];
                }
            }
        }
        return max;
    }

    /** Gets the row index of the highest value in a column. */
    public static int getHighestInColumnIndex(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;
        int index = 0;

        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {  // check row has column
                if (data[i][col] > max) {
                    max = data[i][col];
                    index = i;
                }
            }
        }
        return index;
    }

    /** Gets highest in a row. */
    public static double getHighestInRow(double[][] data, int row) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > max) max = data[row][i];
        }
        return max;
    }

    /** Gets column index of highest value in a row. */
    public static int getHighestInRowIndex(double[][] data, int row) {
        double max = Double.NEGATIVE_INFINITY;
        int index = 0;

        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > max) {
                max = data[row][i];
                index = i;
            }
        }
        return index;
    }

    /** Lowest in whole array. */
    public static double getLowestInArray(double[][] data) {
        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] < min) {
                    min = data[i][j];
                }
            }
        }
        return min;
    }

    /** Lowest in column. */
    public static double getLowestInColumn(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {  // required
                if (data[i][col] < min) {
                    min = data[i][col];
                }
            }
        }
        return min;
    }

    /** Row index of lowest value in a column. */
    public static int getLowestInColumnIndex(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;
        int index = 0;

        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {  // required
                if (data[i][col] < min) {
                    min = data[i][col];
                    index = i;
                }
            }
        }
        return index;
    }

    /** Lowest in row. */
    public static double getLowestInRow(double[][] data, int row) {
        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < min) min = data[row][i];
        }
        return min;
    }

    /** Column index of lowest in row. */
    public static int getLowestInRowIndex(double[][] data, int row) {
        double min = Double.POSITIVE_INFINITY;
        int index = 0;

        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < min) {
                min = data[row][i];
                index = i;
            }
        }
        return index;
    }

    /** Row total. */
    public static double getRowTotal(double[][] data, int row) {
        double sum = 0;
        for (int i = 0; i < data[row].length; i++) sum += data[row][i];
        return sum;
    }

    /** Total of all elements. */
    public static double getTotal(double[][] data) {
        double sum = 0;
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[i].length; j++)
                sum += data[i][j];
        return sum;
    }

    /** Reads file into ragged array. */
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        ArrayList<double[]> rows = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) continue;

            // IMPORTANT FIX: handle multiple spaces
            String[] tokens = line.split("\\s+");

            double[] row = new double[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                row[i] = Double.parseDouble(tokens[i]);
            }
            rows.add(row);
        }

        input.close();

        double[][] data = new double[rows.size()][];
        for (int i = 0; i < rows.size(); i++) data[i] = rows.get(i);

        return data;
    }

    /** Writes ragged array to file. */
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(outputFile);

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                pw.print(data[i][j]);
                if (j < data[i].length - 1) pw.print(" ");
            }
            pw.println();
        }

        pw.close();
    }
}
