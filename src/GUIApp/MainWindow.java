package GUIApp;

import GUIApp.windowParts.GamePanel;
import GUIApp.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;



public class MainWindow extends JFrame {                         // 1.0 класс - фрейм

    private int widthW = 1024;                                   //1.8 вывели переменные из метода MainWindow в отдельный... - ширина
    private int heightW = 768;                                    //1.9 высота
    private int posXW = 300;                                      //2.0 положение окна - "отступ" окна(начальной точки графики(левая, верхняя))
    private int posYW = 200;                                      //2.0....
    private String titleW  = "Game Alive Player";                 //2.2 появление стартового окна

    private InfoPanel infoPanel;                                 //3.5
    private GamePanel map;                                       //3.6

    MainWindow() {                                                //1.1 конструктор. Собираем свое окно... Создаем класс, который окно запускает - Launcher
        setupWindow();                                            //2.5 метод, в котором вызовутся настроечные параметры из setupWindow

        //         JButton1 = new JButton( "JButton1");                   //2.6 созд. кнопку
//         JButton2 = new JButton( "JButton2");                   //2.7...

        // JPanel panel = new  JPanel();                          //3/3 можно создать панель, в нее можно поместить кнопки... и т.д.                    + ! создаем новый класс  InfoPanel
        // setLayout(new GridLayout(10, 5));                      //3.0 другой менедж. распол.(таблица)
//         add(JButton1, BorderLayot.NORTH);                      //2.8 сдвинули  (менеджер, способ- по умолчанию)
//         add(JButton2, BorderLayot.SOUTH);                      //2.9 сдвинули, (размер изменяется, в зависимости от содержимого)

        // for (int i = 0; i < 50; i++) {                         //3.1 можно циклом создать кучу кнопок
        //     add(new JButton( "Button#" +i));
        // }                                                      // 3.2 менеджеры можно комбинировать

        map = new GamePanel(this);                     //3.7 разместили панель
        infoPanel = new InfoPanel(this);               //3.8
        //  ctionContainer = new ActionContainer(infoPanel);      /**13.3 .... в ActionContainer */
        add(map);                                                 //3.9
        add(infoPanel, BorderLayout.EAST);                        //4.0           + ! переход в InfoPanel

        setVisible(true);                                         //1.5 команда отобразить окно
    }

    private void setupWindow() {                                  /**11.2 поставили (true)*/
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   //1.6 метод - что сделать по закрытию
        setSize(widthW,heightW);                                   //1.7 задали размер окна
        setLocation(posXW, posYW);                                 //2.1 положение ("отступ")
        setTitle(titleW);                                          //2.3
        setResizable(true);                                        //2.4 не хочу, чтобы размер изменяли (false)     /**11.2 поставили (true)*/
    }

    //    public ActionContainer getActionContainer() {            /** 12.6*/
//        return ActionContainer;                                  /** 12.6 в InfoPanel */
//    }


    public void launchGame() {                /** 15.1*/
        map.launchGame();                     /** 15.2*/
    }

    public void refreshInfo(GamePanel map) {  /**22.6       + 15.3*/
        infoPanel.refreshInfo(map);           /**22.6                 + 15.4*/
    }

    public void recordLog(String str) {       /**23.2 */
        infoPanel.recordLog(str);             /**23.2 */
    }

    public void updatePlayer(int key) {       /**27.6 принимает ключ*/
        map.updatePlayer(key);                /**27.7 передали ключ в мар. */
    }
}
