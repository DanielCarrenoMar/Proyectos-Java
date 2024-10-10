package app.TroyanWar_3.app.pages.components.dialogs;

import app.TroyanWar_3.app.pages.MenuScreen;
import app.TroyanWar_3.app.pages.components.PlaceholderTextField;
import app.TroyanWar_3.app.warrior.*;

import javax.swing.*;
import java.awt.*;

public class DialogCreateWarrior extends JDialog {
    private MenuScreen parent;
    private PlaceholderTextField textFieldName;
    private PlaceholderTextField textFieldOld;
    private PlaceholderTextField textFieldStrength;
    private Boolean isGreek = true;

    public DialogCreateWarrior(MenuScreen parent) {
        super(parent.manager, "Crear Guerrero", true);
        this.parent = parent;
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        Label labelTitle = new Label("Crear Guerrero", SwingConstants.CENTER);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 25));
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        add(labelTitle, gbc);

        JButton buttonType = new JButton("Griego");
        buttonType.addActionListener(e -> {
            isGreek = !isGreek;
            buttonType.setText(isGreek ? "Griego" : "Troyano");
        });
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 5, 10, 5);
        add(buttonType, gbc);

        textFieldName = new PlaceholderTextField("Nombre");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(textFieldName, gbc);

        textFieldOld = new PlaceholderTextField("Edad (5-60)");
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(textFieldOld, gbc);

        textFieldStrength = new PlaceholderTextField("Fuerza (1-10)");
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(textFieldStrength, gbc);

        JLabel labelHelp = new JLabel("Si no se rellena los campos se creara con valores por defecto");
        labelHelp.setFont(new Font("Arial", Font.PLAIN, 10));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(labelHelp, gbc);

        JButton buttonCreate = new JButton("Crear");
        buttonCreate.addActionListener(e -> create());
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 0;
        gbc.gridheight = 2;
        gbc.weighty = 3.0;
        add(buttonCreate, gbc);

        setVisible(true);
    }

    public void create(){
        String name = textFieldName.isEmpty() ? "GuerreroX" : textFieldName.getText();
        int old = textFieldOld.isEmpty() ? 15 : Integer.parseInt(textFieldOld.getText());
        int strength = textFieldStrength.isEmpty() ? 1 : Integer.parseInt(textFieldStrength.getText());

        parent.addWarrior(isGreek ? new Greek(name, old, strength) : new Troyan(name, old, strength));
        setVisible(false);
    }
}