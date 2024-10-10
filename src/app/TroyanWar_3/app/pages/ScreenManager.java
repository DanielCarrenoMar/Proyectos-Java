package app.TroyanWar_3.app.pages;

import javax.swing.*;
import java.awt.*;

public class ScreenManager extends JFrame{
    private final CardLayout cardLayout;
    private final JPanel cardPanel;

    public enum Page{
        MENU
    }

    public ScreenManager(String title) {
        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        this.add(cardPanel);

        MenuScreen menuScreen = new MenuScreen(this);
        cardPanel.add(menuScreen, Page.MENU.toString());

        setTitle(title);
        setSize(816, 639);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void showPage(Page page) {
        cardLayout.show(cardPanel, page.toString());
    }
}
