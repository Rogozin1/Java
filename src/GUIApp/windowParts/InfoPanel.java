package GUIApp.windowParts;

import GUIApp.MainWindow;
import GUIApp.windowParts.infoPanelParts.GameControlArea;
import GUIApp.windowParts.infoPanelParts.GameInfoArea;
import GUIApp.windowParts.infoPanelParts.PlayerControlArea;
import GUIApp.windowParts.infoPanelParts.PlayerInfoArea;

import javax.naming.spi.DirectoryManager;
import javax.swing.*;
import java.awt.*;



public class InfoPanel extends JPanel {          //3.3      +! создадим GamePanel
                                                 //4.1 создали папку windowParts и переместили...., + infoPanelParts  + GameControlArea + GameInfoArea + PlayerInfoArea + PlayerControlArea
    private int panelWidth = 200;                /**11.3 задали ширину*/

    private GameControlArea gameControlArea;     //4.2
    private GameInfoArea gameInfoArea;           //4.3
    private PlayerInfoArea playerInfoArea;       //4.4
    private PlayerControlArea playerControlArea; //4.5

    private JTextArea log;                       //5.2 созд. части с текстом
    private JScrollPane scroll;                 //5.3 созд части с

    private MainWindow mainWindow;              //7.9

    public InfoPanel(MainWindow mainWindow) {    //4.6          + //7.8 прописываем MainWindow mainWindow
        this.mainWindow = mainWindow;            //8.0
        preparePanel();                          //4.9
        createParts();                           //5.7
        prepareLogs();                           //5.8

        add(gameControlArea);                    //5.9 располагаем. Добавили зону с ....
        add(gameInfoArea);                       //6.0....
        add(playerInfoArea);                     //6.1....
        add(playerControlArea);                  //6.2..... глючит - надо в GameControlArea extends JPanel, GameInfoArea extends....  (делается правка)
        add(scroll);                             //6.3 .. всё равно глючит... надо в public GamePanel - отсутствовали зоны доступа- исправить...     + ! в GameControlArea
    }
                                                                             /**11.1 применен "полуручной" размер панельки */
    private void preparePanel() {                                            //4.7
        setPreferredSize(new Dimension(panelWidth, mainWindow.getHeight())); //4.8
        setLayout(new GridLayout(5, 1));                           //5.0 разбиваем на 5 частей
    }

    private void createParts() {                                             //5.1 создание частей
        gameControlArea = new GameControlArea(this);                 //5.1    + //8.1 mainWindow     + ! в
        gameInfoArea = new GameInfoArea();                                   //5.1
        playerInfoArea = new PlayerInfoArea();                               //5.1
        playerControlArea = new PlayerControlArea(this);            //5.1
    }                                                                        /**14.4 */

    private void prepareLogs() {                                             // 5.4
        log = new JTextArea();                                               //5.5
        log.setEditable(false);                                              /**12.0 запрет печати пользоват. */
        log.setLineWrap(true);                                               /**12.1 */
        scroll = new JScrollPane(log);                                       //5.6 отдаем контроль...
    }
                                                                             /**12.5 */
    public void recordLog(String msg) {
        log.append(msg + "\n");
    }
                                                                             /**13.5 */
    public void launchGame() {
        mainWindow.launchGame();
    }

    public void refreshInfo(GamePanel map) {                                               /**23.0  */
        gameInfoArea.refresh(map.getMapSize(), map.getLevelCount(), map.getCountTrap());   /**23.0  */
        playerInfoArea.refresh(map.getPlayer());                                           /**23.0 обновить инф. */
    }

    public void updatePlayer(int key) {   /**27.4 поступил сигнал о обновл. пользователя */
        mainWindow.updatePlayer(key);     /**27.5 */
    }
}
