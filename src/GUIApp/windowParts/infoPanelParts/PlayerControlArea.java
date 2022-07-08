package GUIApp.windowParts.infoPanelParts;

import GUIApp.model.Player;
import GUIApp.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class PlayerControlArea extends JPanel {

    private JButton btnMoveUp;                                    /** 10.1 управление пользователем */
    private JButton btnMoveLeft;
    private JButton btnMoveRight;
    private JButton btnMoveDown;

    private InfoPanel infoPanel;                                  /**13.8 ссылка на infoPanel */

    public PlayerControlArea(InfoPanel infoPanel) {               /**10.2 для панели разделение строки, столбцы*/
        this.infoPanel = infoPanel;                               /**13.9 */
        setLayout(new GridLayout(2,3));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        btnMoveUp = new JButton("⮝"); //\uD83E\uDC45         - можно скопир. с юникода     /** 10.3 создали кнопки*/
        btnMoveUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {          /**11.5.1 добавили на кнопки*/
                                                                  // 11.6System.out/println("UP")
                infoPanel.updatePlayer(Player.playerMoveUp);      /**14.0   +   27.0 сюда должны передать ключ */
            }
        });

        btnMoveLeft = new JButton("⮜"); //\uD83E\uDC44
        btnMoveLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.updatePlayer(Player.playerMoveLeft);    /**27.1 сюда должны передать ключ */
            }
        });

        btnMoveRight = new JButton("⮞"); //\uD83E\uDC46
        btnMoveRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                                                  //11.9 System.out/println("DOWN")
                infoPanel.updatePlayer(Player.playerMoveRight);   /**14.2 */
            }                                                     /**27.2 сюда должны передать ключ */
        });

        btnMoveDown = new JButton("⮟"); //\uD83E\uDC47
        btnMoveDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                                                  //11.9 System.out/println("DOWN")
                infoPanel.updatePlayer(Player.playerMoveDown);    /**14.3 */
            }                                                     /**27.3 сюда должны передать ключ */
        });

        add(new JPanel());                                        /**10.4   добавили на панель....... в PlayerInfoArea */
        add(btnMoveUp);
        add(new JPanel());
        add(btnMoveLeft);
        add(btnMoveDown);
        add(btnMoveRight);
    }

}
