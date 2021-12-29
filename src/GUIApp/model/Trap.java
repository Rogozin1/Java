package GUIApp.model;

import GUIApp.tools.Tools;



public class Trap {                  /**15.8  + 20.0 переделка на*/

    private int x;                  /**15.8 + 20.0 переделка на private */
    private int y;                  /**15.8 + 20.0 переделка на private */
    private int attack;             /**15.8 + 20.0 переделка на private */
    private int count;             /**15.8 + 20.0 переделка на private */

    private int valueMin = 5;      /**15.8 + 20.0 переделка на private */
    private int valueMax = 15;     /**15.8 + 20.0 переделка на private */

    public Trap(int count) {                                 /**20.1 конструктор, ловушки */
        this.attack = Tools.randomValue(valueMin, valueMax); /**20.3 */
        this.count = count;                                  /**20.2 */
    }

    public void decreaseTrapCount() {      /**20.8 уменьшение ловушек */
        --count;                           /**20.8 */
    }

    public void setPosition(int x, int y) { /**20.4 */
        this.x = x;                         /**20.5 */
        this.y = y;                         /**20.6 */
    }

    public int getCount() {                 /**21.2 кол. ловушек */
        return count;
    }

    public boolean isExistTrap() {
        return count > 0;
    }

    public int getAttack() {               /**20.7 ловушка может атаковать */
        return attack;                     /**20.7 */
    }

    public int getX() {                    /**20.9 */
        return x;
    }

    public int getY() {                    /**21.0 */
        return y;
    }
}
