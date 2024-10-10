package app.TroyanWar_3.app.pages.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PlaceholderTextField extends JTextField {
    private final String placeholder;

    public PlaceholderTextField(String placeholder) {
        this.placeholder = placeholder;
        setText(placeholder);
        setForeground(Color.GRAY);

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeholder)) {
                    focusGainedAction();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    focusLostAction();
                }
            }
        });
    }

    public void focusGainedAction(){
        setText("");
        setForeground(Color.BLACK);
    }

    public void focusLostAction(){
        setText(placeholder);
        setForeground(Color.GRAY);
    }

    public Boolean isEmpty(){
        return getText().equals(placeholder);
    }
}
