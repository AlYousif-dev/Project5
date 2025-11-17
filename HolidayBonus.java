/* 
 * Class: CMSC203  
 * Instructor: Gary Thai
 * Description: Calculates holiday bonuses for stores based on sales
 * Due: 11/21/2025 
 * Platform/compiler: Eclipse: Java 21
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source.  
 * I have not given my code to any student. 
 * Print your Name here: Yousif Aluobaidy
 */

public class HolidayBonus {

    // bonus amounts for different cases
    public static final double BONUS_HIGH = 5000.0;   // highest in category
    public static final double BONUS_LOW = 1000.0;    // lowest in category
    public static final double BONUS_OTHER = 2000.0;  // all other eligible

    /**
     * Calculates the holiday bonus for each store.
     * The returned array index matches the store index in the sales array.
     * 
     * Rules:
     * - Highest positive sales in a category: 5000
     * - Lowest positive sales in a category: 1000
     * - All other positive sales in a category: 2000
     * - 0 or negative sales in a category: no bonus for that category
     * - If only one store has positive sales in a category, it only gets 5000
     * 
     * @param data ragged 2D array of store sales
     * @return array of bonuses for each store
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        // bonus per store, same number of rows as data
        double[] bonuses = new double[data.length];

        // find the max number of columns among all rows (ragged array)
        int maxCols = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].length > maxCols) {
                maxCols = data[i].length;
            }
        }

        // loop through each category (column)
        for (int col = 0; col < maxCols; col++) {

            double highest = Double.NEGATIVE_INFINITY;
            double lowest = Double.POSITIVE_INFINITY;
            int countPositive = 0; // number of stores with > 0 sales in this column

            // find highest and lowest positive sales in this column
            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length) { // make sure this row has this column
                    double value = data[row][col];

                    if (value > 0) { // only positive values are eligible
                        countPositive++;
                        if (value > highest) {
                            highest = value;
                        }
                        if (value < lowest) {
                            lowest = value;
                        }
                    }
                }
            }

            // if no store sold anything positive in this category, skip bonuses
            if (countPositive == 0) {
                continue;
            }

            // assign bonuses
            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length) {
                    double value = data[row][col];

                    if (value > 0) {
                        if (countPositive == 1) {
                            if (Math.abs(value - highest) < 0.00001)
                                bonuses[row] += BONUS_HIGH;
                        } else {
                            if (Math.abs(value - highest) < 0.00001) {
                                bonuses[row] += BONUS_HIGH;
                            } else if (Math.abs(value - lowest) < 0.00001) {
                                bonuses[row] += BONUS_LOW;
                            } else {
                                bonuses[row] += BONUS_OTHER;
                            }
                        }
                    }

                }
            }
        }

        return bonuses;
    }

    /**
     * Calculates the total of all holiday bonuses for the district.
     * 
     * @param data ragged 2D array of store sales
     * @return total holiday bonus amount
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double total = 0;

        // add up all store bonuses
        for (int i = 0; i < bonuses.length; i++) {
            total += bonuses[i];
        }

        return total;
    }
}
