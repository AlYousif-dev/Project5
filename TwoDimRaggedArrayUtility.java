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

    /**
     * Calculates the average of all elements in a ragged 2D array.
     * @param data the ragged array
     * @return the average of all values
     */
    public static double getAverage(double[][] data) {
        double sum = 0;
        int count = 0; // counting all elements

        // go through every row and column
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j];
                count++;
            }
        }
        return sum / (double) count;
    }

    /**
     * Returns the sum of all values in a particular column.
     * @param data ragged array
     * @param col the column index to total
     * @return column sum
     */
    public static double getColumnTotal(double[][] data, int col) {
        double sum = 0;

        // iterating down the rows in that column
        for (int i = 0; i < data.length; i++) {
            sum += data[i][col];
        }
        return sum;
    }

    /**
     * Finds the highest value in the whole ragged array.
     * @param data ragged array
     * @return the highest value found
     */
    public static double getHighestInArray(double[][] data) {
        double max = Double.NEGATIVE_INFINITY;

        // check every element
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] > max) {
                    max = data[i][j];
                }
            }
        }
        return max;
    }

    /**
     * Gets the highest value in a particular column.
     * @param data ragged array
     * @param col column index
     * @return highest value in that column
     */
    public static double getHighestInColumn(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < data.length; i++) {
            if (data[i][col] > max) {
                max = data[i][col];
            }
        }
        return max;
    }

    /**
     * Returns the row index of the highest value in a column.
     * @param data ragged array
     * @param col column index
     * @return row index of highest value
     */
    public static int getHighestInColumnIndex(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;
        int index = 0;

        // track which row has the biggest value
        for (int i = 0; i < data.length; i++) {
            if (data[i][col] > max) {
                max = data[i][col];
                index = i;
            }
        }
        return index;
    }

    /**
     * Gets the highest value in a specific row.
     * @param data ragged array
     * @param row row index
     * @return highest value
     */
    public static double getHighestInRow(double[][] data, int row) {
        double max = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > max) {
                max = data[row][i];
            }
        }
        return max;
    }

    /**
     * Gets the column index of the highest value in a row.
     * @param data ragged array
     * @param row row index
     * @return column index of highest value
     */
    public static int getHighestInRowIndex(double[][] data, int row) {
        double max = Double.NEGATIVE_INFINITY;
        int index = 0;

        // iterate across columns in row
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > max) {
                max = data[row][i];
                index = i;
            }
        }
        return index;
    }

    /**
     * Finds the lowest value in the whole ragged array.
     * @param data ragged array
     * @return lowest value
     */
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

    /**
     * Gets the lowest value in a column.
     * @param data ragged array
     * @param col column index
     * @return lowest value in that column
     */
    public static double getLowestInColumn(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < data.length; i++) {
            if (data[i][col] < min) {
                min = data[i][col];
            }
        }
        return min;
    }

    /**
     * Gets the row index of the lowest value in a column.
     * @param data ragged array
     * @param col column index
     * @return row index
     */
    public static int getLowestInColumnIndex(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;
        int index = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i][col] < min) {
                min = data[i][col];
                index = i;
            }
        }
        return index;
    }

    /**
     * Gets the lowest value in a row.
     * @param data ragged array
     * @param row row index
     * @return lowest value
     */
    public static double getLowestInRow(double[][] data, int row) {
        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < min) {
                min = data[row][i];
            }
        }
        return min;
    }

    /**
     * Gets the column index of lowest value in a row.
     * @param data ragged array
     * @param row row index
     * @return column index
     */
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

    /**
     * Returns the total of a specific row.
     * @param data ragged array
     * @param row the row index
     * @return sum of that row
     */
    public static double getRowTotal(double[][] data, int row) {
        double sum = 0;

        for (int i = 0; i < data[row].length; i++) {
            sum += data[row][i];
        }
        return sum;
    }

    /**
     * Totals every element in the ragged array.
     * @param data ragged array
     * @return total sum
     */
    public static double getTotal(double[][] data) {
        double sum = 0;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j];
            }
        }
        return sum;
    }

    /**
     * Reads a file and converts it into a ragged 2D array.
     * Each line is a row; values separated by spaces.
     * @param file the file to read
     * @return ragged 2D array of doubles
     * @throws FileNotFoundException
     */
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);

        // store rows temporarily since we don't know the size
        ArrayList<double[]> rows = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();

            if (line.isEmpty()) continue; // ignore blank lines

            // split by spaces and convert to doubles
            String[] tokens = line.split(" ");
            double[] row = new double[tokens.length];

            for (int i = 0; i < tokens.length; i++) {
                row[i] = Double.parseDouble(tokens[i]);
            }

            rows.add(row);
        }

        input.close();

        // now convert list to array
        double[][] data = new double[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            data[i] = rows.get(i);
        }

        return data;
    }

    /**
     * Writes a ragged array to a file.
     * Each row on a new line, values separated by spaces.
     * @param data ragged 2D array
     * @param outputFile file to write to
     * @throws FileNotFoundException
     */
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(outputFile);

        // print each row
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                pw.print(data[i][j]);

                // add space between numbers
                if (j < data[i].length - 1) {
                    pw.print(" ");
                }
            }
            pw.println(); // go to next line
        }

        pw.close();
    }
}
