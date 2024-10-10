package app.TroyanWar_3.app.pages.components;

import javax.swing.*;
import java.awt.*;

public class ScrollPanel {
    private final JPanel scrollContent;

    public ScrollPanel(JPanel parent,Rectangle bounds) {
        scrollContent = new JPanel();
        scrollContent.setLayout(new BoxLayout(scrollContent, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(scrollContent);
        scrollPane.setBounds(bounds);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        parent.add(scrollPane);
    }

    public void addComponent(Component component) {
        scrollContent.add(component);
        scrollContent.revalidate();
        scrollContent.repaint();
    }

    public void removeComponent(Component component) {
        scrollContent.remove(component);
        scrollContent.revalidate();
        scrollContent.repaint();
    }
}
