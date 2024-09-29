package app.Salary_1.employees;

import javax.swing.JOptionPane;

public abstract class Employee {
    public String name;
    public String lastName;
    public Integer socialId;
    public static Integer socialIdCount = 0;
    protected Double salary;

    public Employee (String name, String lastName){
        this.name = name;
        this.lastName = lastName;
        socialId = socialIdCount++;
        salary = 0.0;
    }
    
    public abstract void calculateSalary();
    
    public void print(){
        calculateSalary();
        JOptionPane.showMessageDialog(null,
            name+" "+ lastName + "\nSeguro social: " + socialId + "\nSalario: " + salary,
            name + " " + lastName,
            JOptionPane.QUESTION_MESSAGE);
        salary = 0.0;
    }
}
