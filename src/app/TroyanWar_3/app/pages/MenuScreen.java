package app.TroyanWar_3.app.pages;

import app.TroyanWar_3.app.gadgets.TroyanHorse;
import app.TroyanWar_3.app.pages.components.ResizeImage;
import app.TroyanWar_3.app.pages.components.ScrollPanel;
import app.TroyanWar_3.app.pages.components.cards.*;
import app.TroyanWar_3.app.pages.components.dialogs.DialogCreateWarrior;
import app.TroyanWar_3.app.warrior.Greek;
import app.TroyanWar_3.app.warrior.Warrior;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuScreen extends JPanel {
    private final ArrayList<Warrior> warriors = new ArrayList<>();
    private final TroyanHorse troyanHorse = new TroyanHorse(50);
    public ScreenManager manager;

    public JLabel labelMessages;
    private final ScrollPanel scrollWarrior;
    private ScrollPanel scrollInTroyanGreeks;

    public MenuScreen (ScreenManager manager){
        this.manager = manager;
        setLayout(null);

        JLabel labelTitle = new JLabel("Guerra de Troya", SwingConstants.CENTER);
        labelTitle.setBounds(0, 10, 800, 40);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 40));
        add(labelTitle);

        labelMessages = new JLabel("", SwingConstants.CENTER);
        labelMessages.setBounds(0, 70, 800, 40);
        labelMessages.setFont(new Font("Arial", Font.PLAIN, 25));
        add(labelMessages);

        JLabel imageTroyan = ResizeImage.resizeImage("src/app/TroyanWar_3/resources/images/troya.png", 450,120, 100, 100, true);
        add(imageTroyan);

        JLabel imageWarrior = ResizeImage.resizeImage("src/app/TroyanWar_3/resources/images/warrior.png", 50,130, 80, 80);
        add(imageWarrior);

        JLabel imageArrow = ResizeImage.resizeImage("src/app/TroyanWar_3/resources/images/arrow.png", 350,345, 100, 100);
        add(imageArrow);

        scrollWarrior = new ScrollPanel(this, new Rectangle(50, 220, 300, 350));
        scrollInTroyanGreeks = new ScrollPanel(this, new Rectangle(450, 220, 300, 350));

        JButton buttonAddWarrior = new JButton("Agregar Guerrero");
        buttonAddWarrior.setBounds(140, 180, 200, 30);
        buttonAddWarrior.addActionListener(e -> new DialogCreateWarrior(this));
        add(buttonAddWarrior);
    }

    public void addWarrior(Warrior warrior){
        warriors.add(warrior);
        scrollWarrior.addComponent(new CardWarrior(this, warrior));
        labelMessages.setText("Se ha agregado un guerrero");
    }

    public void cloneWarrior(){

    }

    public void mountTroyan(CardWarrior card,Warrior warrior){
        Integer result = troyanHorse.mount(warrior);
        labelMessages.setText(
                switch (result) {
                    case -1 -> "El caballo de Troya está lleno";
                    case -2 -> "No es un guerrero griego";
                    default -> "Se ha montado un guerrero. Cantidad: " + result;
                }
        );
        if (result < 0) return;
        scrollWarrior.removeComponent(card);
        scrollInTroyanGreeks.addComponent(new CardInTroyanGreek(this, warrior));
    }

    public void dismountTroyan(CardInTroyanGreek card, Greek greek){
        scrollInTroyanGreeks.removeComponent(card);
        labelMessages.setText(troyanHorse.getDown(greek.getName()) ? "Se ha desmontado un guerrero" : "No se ha encontrado el guerrero");
        scrollWarrior.addComponent(new CardWarrior(this, greek));
    }
}
