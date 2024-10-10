package app.TroyanWar_3.app.pages.components;

import javax.swing.*;
import java.awt.*;

public class ResizeImage {

    public static JLabel resizeImage(String path, int x, int y, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedImageIcon);
        imageLabel.setBounds(x, y, resizedImageIcon.getIconWidth(), resizedImageIcon.getIconHeight());
        return imageLabel;
    }

    public static JLabel resizeImage(String path, int x, int y, int width, int height, Boolean flipX) {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedImageIcon);
        imageLabel.setBounds(x, y, resizedImageIcon.getIconWidth(), resizedImageIcon.getIconHeight());
        if (flipX) {
            imageLabel.setIcon(new ImageIcon(resizedImage.getScaledInstance(-width, height, Image.SCALE_SMOOTH)));
        }
        return imageLabel;
    }
}
