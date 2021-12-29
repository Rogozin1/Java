package GUIApp.model;



public class Player {

    private String name;                          /**15.7 из 4-го урока  +    /** 17.2  делаем private */
    private int hp;                               /**15.7        +            /** 17.2  делаем private */
    private int str;                              /**15.7        +            /** 17.2  делаем private */
    private int x;                                /**15.7        +            /** 17.2  делаем private */
    private int y;                                /**15.7        +            /** 17.2  делаем private */
    private int exp;                              /**15.7    +    /** 17.2  делаем private */

    public static final int playerMoveUp = 8;    /**15.7 */
    public static final int playerMoveLeft = 4;  /**15.7 */
    public static final int playerMoveRight = 6; /**15.7 */
    public static final int playerMoveDown = 2;  /**15.7  + создаем класс Trap */

    public Player(String name) {        /** 17.3 */
        this.name = name;               /** 17.4 */
        hp = 100;                       /** 17.5 */
        str = 15;                       /** 17.6 */
    }

    public void moveUp() {              /** 17.8 */
        y -= 1;                         /** 17.9 */
    }

    public void moveDown() {            /** 18.0 */
        y += 1;                         /** 18.0 */
    }

    public void moveLeft() {            /** 18.1 */
        x -= 1;                         /** 18.1 */
    }

    public void moveRight() {           /** 18.2 */
        x += 1;                         /** 18.2 */
    }

    public void decreaseHP(int value) { /** 18.3 получает урон*/
        hp -= value;                    /** 18.3 */
    }

    public void increaseExp(int value) {     /**28.3 */
        exp += value;
    }

    public void setPosition(int x, int y) {  /** 17.7 принимает координаы и записывает в поля */
        this.x = x;                          /** 17.7 */
        this.y = y;                          /** 17.7 */
    }

    public boolean isAlive() {               /** 18.3.1*/
        return hp > 0;
    }

    public String getName() {                /** 18.4 если понадобится информация...*/
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getStr() {
        return str;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getPosition() {              /** 18.5 строка состоян. и вывод в панель*/
        return (x + 1) + ":" + (y + 1);        /** 18.5  где находится.*/
    }

    public int getExp() {
        return exp;
    }
}
