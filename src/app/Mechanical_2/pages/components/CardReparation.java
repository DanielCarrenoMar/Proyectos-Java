package app.Mechanical_2.pages.components;

import app.Mechanical_2.pages.MenuScreen;
import app.Mechanical_2.reparations.Reparation;

import javax.swing.*;
import java.awt.*;

public class CardReparation extends JPanel {
    private Reparation reparation;

    private final JLabel labelTitle;
    private final JLabel labelDescription;
    private final JLabel labelHours;
    private final JLabel labelPrice;
    private final PlaceholderTextField textFieldMaterialHours;
    private final PlaceholderTextField textFieldMaterialPrice;
    private final JButton buttonSummit;
    private final JButton buttonClose;

    public CardReparation(Reparation reparation) {
        this.reparation = reparation;

        Color color = switch (reparation.getClass().getSimpleName()) {
            case "Mechanic" -> Color.RED;
            case "Paint" -> Color.CYAN;
            case "Review" -> Color.GREEN;
            default -> Color.BLACK;
        };
        setBackground(color);
        setMaximumSize(new Dimension(375, 100));

        String title = switch (reparation.getClass().getSimpleName()) {
            case "Mechanic" -> "Mecanica";
            case "Paint" -> "Chapa y pintura";
            case "Review" -> "Revision";
            default -> "Tipo";
        };
        labelTitle = new JLabel(title);
        labelDescription = new JLabel(reparation.getDescription());
        labelDescription.setPreferredSize(new Dimension(200, 25));
        labelDescription.setMaximumSize(new Dimension(200, 25));
        labelDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelHours = new JLabel("Horas: 0");
        labelPrice = new JLabel("Precio: 0");
        textFieldMaterialHours = new PlaceholderTextField("Horas");
        textFieldMaterialPrice = new PlaceholderTextField("Precio material");
        buttonSummit = new JButton("Agregar");
        buttonSummit.addActionListener(e -> summit());
        buttonClose = new JButton("Cerrar");
        buttonClose.addActionListener(e -> {
            reparation.closeReparation();
            setBackground(Color.GRAY);
            buttonSummit.setEnabled(false);
            labelTitle.setText(labelTitle.getText() + " (CERRADA)");
        });

        Box boxV = Box.createVerticalBox();
        Box boxH = Box.createHorizontalBox();
        Box boxH2 = Box.createHorizontalBox();
        boxH2.setAlignmentX(Component.CENTER_ALIGNMENT);

        boxV.add(labelTitle);
        boxV.add(labelDescription);
        boxH.add(labelHours);
        boxH.add(Box.createHorizontalStrut(10));
        boxH.add(labelPrice);
        boxV.add(boxH);
        boxH2.add(textFieldMaterialHours);
        if(!reparation.getClass().getSimpleName().equals("Review")) boxH2.add(textFieldMaterialPrice);
        boxH2.add(buttonSummit);
        boxH2.add(buttonClose);
        boxV.add(boxH2);
        add(boxV);
    }

    private void summit(){
        if(!reparation.getClass().getSimpleName().equals("Review")) reparation.setMaterialPrice(Integer.parseInt(textFieldMaterialPrice.getText()));
        reparation.addHour(Integer.parseInt(textFieldMaterialHours.getText()));
        labelHours.setText("Horas: " + reparation.getHours());
        labelPrice.setText("Precio: " + reparation.getPrice());
        if (reparation.getClosed()){
            setBackground(Color.GRAY);
            buttonSummit.setEnabled(false);
            labelTitle.setText(labelTitle.getText() + " (CERRADA)");
        }
        textFieldMaterialHours.focusLostAction();
        textFieldMaterialPrice.focusLostAction();
        revalidate();
    }
}
