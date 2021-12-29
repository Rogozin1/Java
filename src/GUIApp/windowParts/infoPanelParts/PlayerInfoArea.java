package GUIApp.windowParts.infoPanelParts;

import GUIApp.model.Player;

import javax.swing.*;
import java.awt.*;

                                                                     /**10.5 по аналогии */

public class PlayerInfoArea extends JPanel {

    private String prefixHP = "Health: ";                             /** 10.9 префиксы - то, что увидит пользователь при запуске*/
    private String prefixStr = "Str: ";
    private String prefixPosition = "Position: ";

    private JLabel playerHP;
    private JLabel playerStr;
    private JLabel playerPosition;

    public PlayerInfoArea() {
        setLayout(new GridLayout(4,1));                       /** 10.6*/
        setBorder(BorderFactory.createLineBorder(Color.BLACK));         /** 10.7 добавляется*/

        playerHP = new JLabel(prefixHP + "-");                      /** 10.8 */
        playerStr = new JLabel(prefixStr + "-");
        playerPosition = new JLabel(prefixPosition + "-:-");

        add(new JLabel("= Player Info =", SwingConstants.CENTER));  /**10.9 динамич. лейбл*/
        add(playerHP);                                                  /** 11.0 - на панель*/
        add(playerStr);
        add(playerPosition);
    }

    public void refresh(Player player) {                                /**23.2  */
        playerHP.setText(prefixHP + player.getHp());                    /**23.2  */
        playerStr.setText(prefixStr + player.getStr());                 /**23.2  */
        playerPosition.setText(prefixPosition + player.getPosition());  /**23.2  */
    }

}
