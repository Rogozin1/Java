package GUIApp.windowParts.infoPanelParts;

import GUIApp.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GameControlArea extends JPanel {

    private JButton startGame;                                  //6.4 делаем 2 кнопки
    private JButton exitGame;                                   //6.5 ...

    private InfoPanel infoPanel;                                //7.7 ....  + ! в infoPanel = new InfoPanel(this);  (//3.8) дописываем this          + ! в InfoPanel
    //private MainWindow mainWindow;                            //8.3
    private int STATUS_OK = 0;
    //this.mainWindow = mainWindow;                             //8.4
    public GameControlArea(InfoPanel infoPanel) {               //6.6 созд. конструктор...    + //7.6 добавили InfoPanel infoPanel  +//8.2 MainWindow mainWindow
        this.infoPanel = infoPanel;                             //7.8
        setLayout(new GridLayout(3, 1));              //6.8 настроим панель
        setBorder(BorderFactory.createLineBorder(Color.BLACK)); /** 10.0 задает границы*/

        startGame = new JButton("START GAME");             //6.7
        startGame.addActionListener(new ActionListener() {     //7.3
            @Override          //  7.4
            public void actionPerformed(ActionEvent e) {       //7.5 изменить лейбл окна, находится в  gameControlArea = new GameControlArea(this, mainWindow); (//5.1)
                infoPanel.launchGame();                        /**15.5 */
                                                               /** 11.4 заглушка */
                //System.out/println("Start Game")
                //mainWindow.setTitle("Privet Ivan");          //8.5
            }
        });
                                                               /**11.5 */
        exitGame = new JButton("EXIT GAME");              //6.8   + /**10.5*/
        exitGame.addActionListener(new ActionListener() {      /**11.5*/
            @Override                                          /**11.5*/
            public void actionPerformed(ActionEvent e) {
                System.exit(STATUS_OK);
            }
        });

        add(new JLabel("=Game Controls=", SwingConstants.CENTER));   //7.1 оповещение, что панель нужна для контроля
        add(startGame);                                                   //6.9 добавь кнопку...
        add(exitGame);                                                    //7.0 добавь кнопку...
    }
}
