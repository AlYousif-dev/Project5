import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class represents Student test cases for a HolidayBonus class.
 * 
 * @author Yousif Aluobaidy
 * @version 11/17/2025
 * 
 */
public class HolidayBonusTestStudent {

    @Test
    public void testBasicBonusCalculation() {
        double[][] data = {
                {5, 2, 9, 3},
                {1, 4},
                {7, 8, 2, 6, 5},
                {10}
        };

        double[] bonuses = HolidayBonus.calculateHolidayBonus(data);

        // Expected per manual calculation:
        // Store 0 → 9000
        // Store 1 → 3000
        // Store 2 → 18000
        // Store 3 → 5000

        assertEquals(9000, bonuses[0], 0.001);
        assertEquals(3000, bonuses[1], 0.001);
        assertEquals(18000, bonuses[2], 0.001);
        assertEquals(5000, bonuses[3], 0.001);
    }

    @Test
    public void testIncludesZeroPositiveCategory() {
        double[][] data = {
                {-2, -5},
                {-1, 0},
                {-3, -4}
        };

        double[] bonuses = HolidayBonus.calculateHolidayBonus(data);

        // No positive numbers - all bonuses zero
        for (double d : bonuses) {
            assertEquals(0, d, 0.001);
        }
    }

    @Test
    public void testSinglePositiveSeller() {
        double[][] data = {
                {0, 0, 0},
                {5, -3, 0},
                {-2, -4, -1}
        };

        double[] bonuses = HolidayBonus.calculateHolidayBonus(data);

        // Only store 1 has positives - gets 5000 for each category it participates in
        assertEquals(5000, bonuses[1], 0.001);

        // others must be zero
        assertEquals(0, bonuses[0], 0.001);
        assertEquals(0, bonuses[2], 0.001);
    }

    @Test
    public void testTotalHolidayBonus() {
        double[][] data = {
                {5, 2},
                {1, 4},
                {7, 8}
        };

        double total = HolidayBonus.calculateTotalHolidayBonus(data);

        // Bonuses:
        // Books → high=7-5000, low=1-1000, mid=5-2000
        // Tsum → high=8-5000, low=2-1000, mid=4-2000
        //
        // Total = 5000+1000+2000 + 5000+1000+2000 = 16000

        assertEquals(16000, total, 0.001);
    }
}
