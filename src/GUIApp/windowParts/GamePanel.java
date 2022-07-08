package GUIApp.windowParts;

import GUIApp.MainWindow;
import GUIApp.model.Player;
import GUIApp.model.Trap;
import GUIApp.tools.Tools;

import javax.swing.*;
import java.awt.*;



public class GamePanel extends JPanel {              //3.4

    private MainWindow mainWindow;

    private int[][] map;          /**15.6 можно скопировать из 4-го урока, меняем на private   + 19.5 переименов. на int[][] */
    private int[][] invisibleMap; /**15.6  + 19.6 переименов. на int[][]  */
    private int mapWight;        /**15.6 */
    private int mapHeight;       /**15.6 */
    private int mapSizeMin = 3;  /**15.6 */
    private int mapSizeMax = 6;  /**15.6 создали папку model и класс Player */
                                 /**15.9 создали пакет tools и class Tools  */
    private int cellPlayer = 1;  /** 19.1 */
    private int cellTrap = 2;    /** 19.2 */
    private int cellEmpty = 0;   /** 19.3 */
    private int cellReady = 99;  /** 19.4 */

    private int levelCount;      /**17.0 меняем на private */

    private Player player;       /** 18.6 */
    private Trap trap;           /**21.1 */

    private int cellWidth;       /**23.5 */
    private int cellHeight;      /**23.6 */

    private boolean isMapExist;  /**24.1 чтобы как-бы "карты нет...." */
    private boolean isGameOver;  /**27.6 наступил ли конец игры */

    public GamePanel(MainWindow mainWindow) {  /**16.5 */
        this.mainWindow = mainWindow;          /**16.5 */
        setBackground(Color.BLACK);            //3.5 задали цвет панели   +   16.5
        isMapExist = false;                    /**16.5    +     24.1 ... не создавалась...." */
    }

    public void launchGame() {                 /**15.0       +      16.6 */
        player = new Player("Boris");    /** 18.7 создание игрока*/
        levelCount = 0;                        /**21.9  сброс уровня*/
        levelCycle();                          /**22.5 */
        mainWindow.refreshInfo(this);     /**22.5 */
        isGameOver = false;                    /**27.7 */
    }

    private void levelCycle() {  /**22.0 */
        createMap();             /**22.0 */
        spawnPlayer();           /**22.0 */
        spawnTrap();             /**22.0 */
        ++levelCount;            /**22.0 повысить уровень */
        repaint();               /**24.8 обновить... */
        mainWindow.recordLog("Start Level " + levelCount); /**28.9 новый уровень */
    }

    private void render(Graphics g) {             /**23.4 */
        if (!isMapExist) {                        /**23.4     + 23.7 если карта не существует- выход из метода*/
            return;                               /**23.4 */
        }

        paintGameMap(g);                          /**24.0 */

        for (int y = 0; y < mapHeight; y++) {     /**23.8 */
            for (int x = 0; x < mapWight; x++) {  /**24.9 созд. игрока */

                if (map[y][x] == cellEmpty) {     /**25.0 если пустая ячейка */
                    continue;
                }

                if (map[y][x] == cellPlayer) {    /**25.1 если игрок в ячейке */
                    g.setColor(Color.GREEN);      /**23.7 */
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);     /**25.2 игрок */
                }

                if (map[y][x] == cellReady) {     /**25.3 ячейка, где побывали */
                    g.setColor(Color.GRAY);
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);      /**25.3  */
                }
            }
        }
    }

    public void updatePlayer(int key) {       /**25.4 начнем заставлять ходить */
        if (!isMapExist) {                    /**25.5 если карты нет...то нет */
            return;
        }

        if (isGameOver) {                     /**28.6 если игра закончилась...то закончилась */
            return;
        }

        int currentPlayerX = player.getX();   /**25.6 запомним координаты */
        int currentPlayerY = player.getY();   /**25.6 запомним координаты */

        switch (key) {                        /**25.7 */
            case Player.playerMoveUp:         /**25.8 */
                player.moveUp();              /**25.9 игрок сдвигается вверх */
                break;
            case Player.playerMoveDown:       /**26.0...вниз */
                player.moveDown();            /**26.1 */
                break;
            case Player.playerMoveLeft:       /**26.2 */
                player.moveLeft();            /**26.3 */
                break;
            case Player.playerMoveRight:      /**26.4 */
                player.moveRight();           /**26.5 */
                break;
        }

        if (!checkValidMove(currentPlayerX, currentPlayerY, player.getX(), player.getY())) {  /**26.6 если вываливается, то...ничего */
            return;
        }

        playerMoveAction(currentPlayerX, currentPlayerY, player.getX(), player.getY());       /**26.7 если сходил норм., то...пошел */
        mainWindow.refreshInfo(this);                     /**26.8 */
        repaint();                                             /**26.9 перерисовывает положение объекта*/
    }

    private void paintGameMap(Graphics g) {
        int widthSelf = getWidth();
        int heightSelf = getHeight();

        cellWidth = widthSelf / mapWight;
        cellHeight = heightSelf / mapHeight;

        g.setColor(Color.WHITE);

        for (int i = 0; i <= mapHeight ; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, widthSelf, y);
        }

        for (int i = 0; i <= mapWight ; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, heightSelf);
        }
    }

    private void createMap() {                                 /**19.7 */
        mapWight = Tools.randomValue(mapSizeMin, mapSizeMax);  /** 17.1  + Tools.  */
        mapHeight = Tools.randomValue(mapSizeMin, mapSizeMax); /** 17.1  + Tools.  */
        map = new int[mapHeight][mapWight];                    /**19.7 */
        invisibleMap = new int[mapHeight][mapWight];           /**19.7 */

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWight; x++) {
                map[y][x] = cellEmpty;
                invisibleMap[y][x] = cellEmpty;
            }
        }
        isMapExist = true;                                                                 /**24.7 */
    }

    private void spawnPlayer() {                                                           /** 18.8  + чиним 19.8 */
        player.setPosition(Tools.randomValue(0, mapWight - 1), Tools.randomValue(0, mapHeight - 1));                    /** 18.9 */
        map[player.getY()][player.getX()] = cellPlayer;                                    /** 19.0 */
    }

    private void spawnTrap() {                                                             /**19.9  + чиним   +   16.7 */
        trap = new Trap((mapWight + mapHeight) / 2);                                 /**16.7     +   21.3 */

        int trapX;                                                                         /**16.7    +   21.3  */
        int trapY;                                                                         /**16.7     +   21.3 */

        for (int i = 1; i <= trap.getCount(); i++) {                                       /**16.7 */

            do {                                                                           /**16.7 */
                trapX = Tools.random.nextInt(mapWight);                                    /**16.7 */
                trapY = Tools.random.nextInt(mapHeight);                                   /**16.7 */
            } while (!isEmpty(map, trapX, trapY) || !isEmpty(invisibleMap, trapX, trapY)); /**16.7 */

            invisibleMap[trapY][trapX] = cellTrap;                                         /**16.7    +   21.3  */
        }
    }

    private boolean isEmpty(int[][] inputMap, int x, int y) {                              /**16.8    + чиним  21.3  с ловушками закончили!!! */
        return inputMap[y][x] == cellEmpty;                                                /**16.8 */
    }

    private boolean checkValidMove(int pastX, int pastY, int nextX, int nextY) {  /**16.8 */
        if (nextX >= 0 && nextX < mapWight && nextY >= 0 && nextY < mapHeight) {  /**16.8 */
            return true;                                                          /**16.8 */
        } else {                                                               /**16.8 */
            player.setPosition(pastX, pastY);                                  /**16.8  + 21.4  */
            mainWindow.recordLog(player.getName() + " get invalid move");  /**16.8  +  28.8 исключить случай "погиб и перешел на сл. уровень" */
            return false;                                                      /**16.8 */
        }
    }

    private void playerMoveAction(int pastX, int pastY, int nextX, int nextY) { /**16.9 */
        if (invisibleMap[nextY][nextX] == cellTrap) {                           /**16.9 */
            player.decreaseHP(trap.getAttack());                                /**16.9 + 21.5 отнять здоровье */
            trap.decreaseTrapCount();                                           /**21.6 */
            invisibleMap[nextY][nextX] = cellEmpty;                             /**27.4  чтобы видеть ячейки*/
            mainWindow.recordLog(player.getName() + " get damage is " + trap.getAttack());                           /**28.7 исключить случай "погиб и перешел на сл. уровень" */
        }

        map[nextY][nextX] = cellPlayer;       /**21.7 */
        map[pastY][pastX] = cellReady;        /**21.8 */

        if (!player.isAlive()) {              /**27.5 если игрок умер */
            isGameOver = true;                /**27.8 ...то конец игы */
            JOptionPane.showMessageDialog(this, player.getName() + " is dead. Game Over");        /**27.9 сообщ. о трагедии */
            mainWindow.recordLog(player.getName() + " is dead. Game Over");                                         /**29.0 пользователь умер */
        }

        if (!trap.isExistTrap()) {            /**28.0 если ловушки кончились... */
            player.increaseExp(300);     /**28.1 если ловушки кончились... начислить очки   +     28.4 */
            levelCycle();                      /**28.2 если ловушки кончились... новый уровень */
            JOptionPane.showMessageDialog(this, player.getName() + " go to Level " + levelCount); /**16.9  + 28.5 */
        }
    }

    public Player getPlayer() {          /**22.1 */
        return player;
    }

    public int getLevelCount() {         /**22.2 узнать текущий уровень */
        return levelCount;
    }

    public int getCountTrap(){           /**22.3 колич. ловушек */
        return trap.getCount();
    }

    public String getMapSize() {          /**22.4 информ. о карте */
        return mapWight + ":" + mapHeight;
    }

    @Override
    protected void paintComponent(Graphics g) {      /**23.3 перешли к "проявлению" карты и "рисованию" */
        super.paintComponent(g);                     /**23.3 */
        render(g);                                   /**23.3 */
    }
}
