package app.Salary_1.pages;

import app.Salary_1.employees.*;
import app.Salary_1.pages.components.PlaceholderTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.LinkedList;

public class MenuScreen extends JPanel {
    private final LinkedList<Employee> employees = new LinkedList<>();
    private TypeEmployee typeEmployee = TypeEmployee.SALARIED;

    private final JPanel scrollContent;

    private final JLabel labelType;
    private final PlaceholderTextField textFieldSalarie;
    private final PlaceholderTextField textFieldPerce;
    private final PlaceholderTextField textFieldSales;
    private final PlaceholderTextField textFieldSalarieHour;
    private final PlaceholderTextField textFieldSalarieHourExtra;
    private final PlaceholderTextField textFieldHour;

    public MenuScreen (){
        setLayout(null);

        JButton buttonSalaried = new JButton("Asalariado");
        buttonSalaried.addActionListener(e -> setTypeEmployee(TypeEmployee.SALARIED));
        buttonSalaried.setBounds(0,0,200,50);
        add(buttonSalaried);

        JButton buttonHourly = new JButton("Por Hora");
        buttonHourly.addActionListener(e -> setTypeEmployee(TypeEmployee.HOURLY));
        buttonHourly.setBounds(200,0,200,50);
        add(buttonHourly);

        JButton buttonCommission = new JButton("Por Comision");
        buttonCommission.addActionListener(e -> setTypeEmployee(TypeEmployee.COMMISSION));
        buttonCommission.setBounds(400,0,200,50);
        add(buttonCommission);

        JButton buttonSalariedCommission = new JButton("Asalariado por Comision");
        buttonSalariedCommission.addActionListener(e -> setTypeEmployee(TypeEmployee.SALARIED_COMMISSION));
        buttonSalariedCommission.setBounds(600,0,200,50);
        add(buttonSalariedCommission);

        labelType = new JLabel("Tipo", SwingConstants.CENTER);
        labelType.setBounds(0,50,800,75);
        Font currentFont = labelType.getFont();
        Font newFont = new Font(currentFont.getFontName(), currentFont.getStyle(), 45);
        labelType.setFont(newFont);
        add(labelType);

        PlaceholderTextField textFieldName = new PlaceholderTextField("Nombre");
        textFieldName.setBounds(25,125,200,50);
        add(textFieldName);

        PlaceholderTextField textFieldLastName = new PlaceholderTextField("Apellido");
        textFieldLastName.setBounds(250,125,200,50);
        add(textFieldLastName);

        textFieldSalarie = new PlaceholderTextField("Salario");
        textFieldSalarie.setBounds(25,200,200,50);
        add(textFieldSalarie);

        textFieldPerce = new PlaceholderTextField("Porcentaje");
        textFieldPerce.setBounds(250,200,200,50);
        add(textFieldPerce);

        textFieldSales = new PlaceholderTextField("Ventas");
        textFieldSales.setBounds(25,275,200,50);
        add(textFieldSales);

        textFieldSalarieHour = new PlaceholderTextField("Paga por hora");
        textFieldSalarieHour.setBounds(25,200,200,50);
        add(textFieldSalarieHour);

        textFieldSalarieHourExtra = new PlaceholderTextField("Paga por hora extra");
        textFieldSalarieHourExtra.setBounds(250,200,200,50);
        add(textFieldSalarieHourExtra);

        textFieldHour = new PlaceholderTextField("Horas Trabajadas");
        textFieldHour.setBounds(25,275,200,50);
        add(textFieldHour);

        scrollContent = new JPanel();
        scrollContent.setLayout(new BoxLayout(scrollContent, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(scrollContent);
        scrollPane.setBounds(500,125,275,275);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

        JButton buttonAdd = new JButton("Agregar");
        buttonAdd.addActionListener(e -> {
            Employee newEmployee = switch (typeEmployee){
                case SALARIED -> new Salaried(textFieldName.getText(), textFieldLastName.getText(), Double.parseDouble(textFieldSalarie.getText()));
                case HOURLY -> new Hourly(textFieldName.getText(), textFieldLastName.getText(), Double.parseDouble(textFieldSalarieHour.getText()), Double.parseDouble(textFieldSalarieHourExtra.getText()), Integer.parseInt(textFieldHour.getText()));
                case COMMISSION -> new Commission(textFieldName.getText(), textFieldLastName.getText(), Double.parseDouble(textFieldSales.getText()), Double.parseDouble(textFieldPerce.getText()));
                case SALARIED_COMMISSION -> new SalariedCommission(textFieldName.getText(), textFieldLastName.getText(), Double.parseDouble(textFieldSalarie.getText()), Double.parseDouble(textFieldSales.getText()), Double.parseDouble(textFieldPerce.getText()));
            };
            addEmployee(newEmployee);

        });
        buttonAdd.setBounds(0,450,800,75);
        add(buttonAdd);

        JButton buttonPlay = new JButton("Imprimir");
        buttonPlay.addActionListener(e -> showSalaries());
        buttonPlay.setBounds(0,525,800,75);
        add(buttonPlay);

        setTypeEmployee(TypeEmployee.SALARIED);

    }

    private enum TypeEmployee{
        SALARIED, HOURLY, COMMISSION, SALARIED_COMMISSION
    }

    private void setTypeEmployee(TypeEmployee type){
        switch (type){
            case SALARIED -> {
                typeEmployee = TypeEmployee.SALARIED;
                labelType.setText("Asalariado");
                textFieldSalarie.setVisible(true);
                textFieldPerce.setVisible(false);
                textFieldSales.setVisible(false);
                textFieldSalarieHour.setVisible(false);
                textFieldSalarieHourExtra.setVisible(false);
                textFieldHour.setVisible(false);
            }
            case HOURLY -> {
                typeEmployee = TypeEmployee.HOURLY;
                labelType.setText("Por hora");
                textFieldSalarie.setVisible(false);
                textFieldPerce.setVisible(false);
                textFieldSales.setVisible(false);
                textFieldSalarieHour.setVisible(true);
                textFieldSalarieHourExtra.setVisible(true);
                textFieldHour.setVisible(true);
            }
            case COMMISSION -> {
                typeEmployee = TypeEmployee.COMMISSION;
                labelType.setText("Por comision");
                textFieldSalarie.setVisible(false);
                textFieldPerce.setVisible(true);
                textFieldSales.setVisible(true);
                textFieldSalarieHour.setVisible(false);
                textFieldSalarieHourExtra.setVisible(false);
                textFieldHour.setVisible(false);
            }
            case SALARIED_COMMISSION -> {
                typeEmployee = TypeEmployee.SALARIED_COMMISSION;
                labelType.setText("Asalariado por comision");
                textFieldSalarie.setVisible(true);
                textFieldPerce.setVisible(true);
                textFieldSales.setVisible(true);
                textFieldSalarieHour.setVisible(false);
                textFieldSalarieHourExtra.setVisible(false);
                textFieldHour.setVisible(false);
            }
        }
    }

    private void addEmployee(Employee employee){
        employees.add(employee);
        JPanel rectanglePanel = new JPanel();

        Color color = switch (employee.getClass().getSimpleName()) {
            case "Salaried" -> Color.RED;
            case "Hourly" -> Color.CYAN;
            case "Commission" -> Color.GREEN;
            case "SalariedCommission" -> Color.YELLOW;
            default -> Color.BLACK;
        };

        rectanglePanel.setBackground(color);
        rectanglePanel.setMaximumSize(new Dimension(250, 25));
        rectanglePanel.add(new JLabel(employee.name + " " + employee.lastName));
        scrollContent.add(rectanglePanel);
        int height = scrollContent.getComponentCount() * 25;
        scrollContent.setPreferredSize(new Dimension(scrollContent.getWidth(), height));
        scrollContent.revalidate();
        scrollContent.repaint();
    }

    private void showSalaries(){
        for (Employee employee : employees){
            employee.print();
        }
    }
}
