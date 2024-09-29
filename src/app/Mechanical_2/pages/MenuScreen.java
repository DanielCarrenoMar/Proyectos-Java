package app.Mechanical_2.pages;

import app.Mechanical_2.pages.components.CardReparation;
import app.Mechanical_2.pages.components.PlaceholderTextField;
import app.Mechanical_2.reparations.*;
import app.Mechanical_2.reparations.Paint;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MenuScreen extends JPanel {
    private final LinkedList<Reparation> reparations = new LinkedList<>();
    private TypeReparation typeReparation = TypeReparation.MECHANIC;

    private final JLabel labelType;
    private final JPanel scrollContent;

    private final PlaceholderTextField textFieldDescription;

    public MenuScreen (){
        setLayout(null);

        JButton buttonMechanic = new JButton("Reparacion Mecanica");
        buttonMechanic.addActionListener(e -> setTypeEmployee(TypeReparation.MECHANIC));
        buttonMechanic.setBounds(0,0,266,50);
        add(buttonMechanic);

        JButton buttonPaint = new JButton("Reparacion de chapa y pintura");
        buttonPaint.addActionListener(e -> setTypeEmployee(TypeReparation.PAINT));
        buttonPaint.setBounds(266,0,266,50);
        add(buttonPaint);

        JButton buttonReview = new JButton("Revision");
        buttonReview.addActionListener(e -> setTypeEmployee(TypeReparation.REVIEW));
        buttonReview.setBounds(532,0,266,50);
        add(buttonReview);

        labelType = new JLabel("Tipo", SwingConstants.CENTER);
        labelType.setBounds(0,50,800,75);
        Font currentFont = labelType.getFont();
        Font newFont = new Font(currentFont.getFontName(), currentFont.getStyle(), 45);
        labelType.setFont(newFont);
        add(labelType);

        textFieldDescription = new PlaceholderTextField("Descripccion");
        textFieldDescription.setBounds(25,125,350,50);
        add(textFieldDescription);

        scrollContent = new JPanel();
        scrollContent.setLayout(new BoxLayout(scrollContent, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(scrollContent);
        scrollPane.setBounds(400,125,375,325);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

        JButton buttonAdd = new JButton("Agregar");
        buttonAdd.setBounds(25,200,350,75);
        buttonAdd.addActionListener(e -> {
            Reparation newReparation = switch (typeReparation){
                case MECHANIC -> new Mechanic(textFieldDescription.getText());
                case PAINT -> new Paint(textFieldDescription.getText());
                case REVIEW -> new Review(textFieldDescription.getText());
            };
            addReparation(newReparation);

        });
        add(buttonAdd);

        JButton buttonPlay = new JButton("Imprimir");
        buttonPlay.addActionListener(e -> showReparations());
        buttonPlay.setBounds(0,500,800,100);
        add(buttonPlay);

        setTypeEmployee(TypeReparation.MECHANIC);
    }

    private enum TypeReparation {
        MECHANIC, PAINT, REVIEW
    }

    private void setTypeEmployee(TypeReparation type){
        switch (type){
            case MECHANIC -> {
                typeReparation = TypeReparation.MECHANIC;
                labelType.setText("Reparacion Mecanica");
            }
            case PAINT -> {
                typeReparation = TypeReparation.PAINT;
                labelType.setText("Reparacion de chapa y pintura");
            }
            case REVIEW -> {
                typeReparation = TypeReparation.REVIEW;
                labelType.setText("Revision");
            }
        }
    }

    private void addReparation(Reparation reparation){
        textFieldDescription.focusLostAction();
        reparations.add(reparation);
        scrollContent.add(new CardReparation(reparation));
        int height = scrollContent.getComponentCount() * 100;
        scrollContent.setPreferredSize(new Dimension(scrollContent.getWidth(), height));
        scrollContent.revalidate();
        scrollContent.repaint();
    }

    private void showReparations(){
        for (Reparation reparation : reparations){
            reparation.show();
        }
    }
}
