import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
/**
 * This class represents Student test cases for a TwoDimRaggedArrayUtility object.
 * 
 * @author Yousif Aluobaidy
 * @version 11/17/2025
 * 
 */
public class TwoDimRaggedArrayUtilityTestStudent {

    @Test
    public void testGetTotal() {
        double[][] data = {
                {1, 2, 3},
                {4, 5},
                {6}
        };

        assertEquals(21, TwoDimRaggedArrayUtility.getTotal(data), 0.001);
    }

    @Test
    public void testGetAverage() {
        double[][] data = {
                {2, 2},
                {2},
                {2, 2, 2}
        };

        // six values total: sum=12 - average=2
        assertEquals(2, TwoDimRaggedArrayUtility.getAverage(data), 0.001);
    }

    @Test
    public void testColumnTotalRagged() {
        double[][] data = {
                {1, 2, 3},
                {4},
                {5, 6}
        };

        // Column 0: 1 + 4 + 5 = 10
        assertEquals(10, TwoDimRaggedArrayUtility.getColumnTotal(data, 0), 0.001);

        // Column 1: 2 + 6 = 8
        assertEquals(8, TwoDimRaggedArrayUtility.getColumnTotal(data, 1), 0.001);
    }

    @Test
    public void testHighestInRow() {
        double[][] data = {
                {1, 9, 3}
        };

        assertEquals(9, TwoDimRaggedArrayUtility.getHighestInRow(data, 0), 0.001);
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRow(data, 0), 0.001);
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 0));
    }

    @Test
    public void testHighestInColumnRagged() {
        double[][] data = {
                {1, 2, 3},
                {5},
                {4, 8}
        };

        // Column 0: 1,5,4 - highest=5
        assertEquals(5, TwoDimRaggedArrayUtility.getHighestInColumn(data, 0), 0.001);
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 0));

        // Column 1: 2,8 - highest=8
        assertEquals(8, TwoDimRaggedArrayUtility.getHighestInColumn(data, 1), 0.001);
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 1));
    }

    @Test
    public void testReadAndWriteFile() throws FileNotFoundException {
        double[][] data = {
                {1, 2, 3},
                {4, 5},
                {6}
        };

        File temp = new File("tempTest.txt");
        TwoDimRaggedArrayUtility.writeToFile(data, temp);

        double[][] loaded = TwoDimRaggedArrayUtility.readFile(temp);

        // Validate structure
        assertEquals(3, loaded.length);
        assertEquals(3, loaded[0].length);
        assertEquals(2, loaded[1].length);
        assertEquals(1, loaded[2].length);

        assertEquals(5, loaded[1][1], 0.001);

        temp.delete();
    }
}
