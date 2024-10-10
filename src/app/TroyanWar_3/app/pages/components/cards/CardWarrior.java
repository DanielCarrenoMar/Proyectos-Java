package app.TroyanWar_3.app.pages.components.cards;

import app.TroyanWar_3.app.pages.MenuScreen;
import app.TroyanWar_3.app.pages.components.dialogs.DialogCloneWarrior;
import app.TroyanWar_3.app.warrior.*;

import javax.swing.*;
import java.awt.*;

public class CardWarrior extends JPanel {
    private final MenuScreen parent;
    private final Warrior warrior;

    private final JLabel labelTitle;
    private final JButton buttonHealth;
    private final JButton buttonWithdrawal;

    public CardWarrior(MenuScreen parent, Warrior warrior){
        this.parent = parent;
        this.warrior = warrior;
        setMaximumSize(new Dimension(300, 100));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(Color.LIGHT_GRAY);

        labelTitle = new JLabel("Guerrero", SwingConstants.CENTER);
        if (warrior instanceof Greek) {
            labelTitle.setText("Griego");
            setBackground(Color.CYAN);
        } else if (warrior instanceof Troyan) {
            labelTitle.setText("Troyano");
            setBackground(Color.ORANGE);
        }
        labelTitle.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 5, 0);
        add(labelTitle, gbc);

        JLabel labelName = new JLabel(warrior.getName());
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(labelName, gbc);

        JLabel labelOld = new JLabel("Edad: " + warrior.getOld());
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(labelOld, gbc);

        JLabel labelStrength = new JLabel("Fuerza: " + warrior.getStrength(), SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        add(labelStrength, gbc);

        buttonHealth = new JButton(switch (warrior.getHealth()){
            case DEAD -> "Muerto";
            case WOUNDED -> "Herido";
            case OK -> "Vivo";
        });
        buttonHealth.addActionListener(e -> changeHealth());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(buttonHealth, gbc);

        buttonWithdrawal = new JButton("Retirada");
        buttonWithdrawal.addActionListener(e -> withdrawal());
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(buttonWithdrawal, gbc);

        JButton buttonClone = new JButton("Clonar");
        buttonClone.addActionListener(e -> new DialogCloneWarrior(parent, warrior));
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(buttonClone, gbc);

        JButton buttonMount = new JButton(">");
        buttonMount.addActionListener(e -> mount());
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = 4;
        add(buttonMount, gbc);

        if (warrior.isRetreat()){
            buttonWithdrawal.setEnabled(false);
            labelTitle.setText(labelTitle.getText() + " (Retirado)");
            setBackground(Color.GRAY);
        }
    }

    public void changeHealth(){
        warrior.changeHealth();
        buttonHealth.setText(switch (warrior.getHealth()){
            case DEAD -> "Muerto";
            case WOUNDED -> "Herido";
            case OK -> "Vivo";
        });
    }

    public void withdrawal(){
        parent.labelMessages.setText(warrior.withdrawal());
        if (!warrior.isRetreat()) return;
        buttonWithdrawal.setEnabled(false);
        labelTitle.setText(labelTitle.getText() + " (Retirado)");
        setBackground(Color.GRAY);
    }

    public void mount(){
        parent.mountTroyan(this,warrior);
    }
}
