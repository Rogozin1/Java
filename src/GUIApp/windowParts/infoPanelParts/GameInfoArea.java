package GUIApp.windowParts.infoPanelParts;

import javax.swing.*;
import java.awt.*;



public class GameInfoArea extends JPanel {

    private String prefixTrapCount = "Traps: ";
    private String prefixLevel = "Level: ";
    private String prefixSizeMap = "Size map: ";

    private JLabel trapCount;
    private JLabel levelGame;
    private JLabel sizeMap;

    public GameInfoArea() {
        setLayout(new GridLayout(4,1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        sizeMap = new JLabel(prefixSizeMap + "-:-");
        levelGame = new JLabel(prefixLevel + "-");
        trapCount = new JLabel(prefixTrapCount + "-");

        add(new JLabel("= Game Info =", SwingConstants.CENTER));
        add(sizeMap);
        add(levelGame);
        add(trapCount);
    }

    public void refresh(String sizeMapInfo, int countLevel, int countTraps) {  /**23.1  */
        sizeMap.setText(prefixSizeMap + sizeMapInfo);                          /**23.1  */
        levelGame.setText(prefixLevel + countLevel);                           /**23.1  */
        trapCount.setText(prefixTrapCount + countTraps);                       /**23.1  */
    }
}
