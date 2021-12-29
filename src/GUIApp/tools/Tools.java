package GUIApp.tools;

import java.util.Random;



public class Tools {                                          /**16.0 */

    public static Random random = new Random();               /**16.1 */

    public static int randomValue(int min, int max) {        /**16.2 */
        return min + random.nextInt(max - min + 1);    /**16.3 */
    }


}
