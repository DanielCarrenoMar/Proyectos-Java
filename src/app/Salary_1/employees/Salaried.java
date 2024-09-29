package app.Salary_1.employees;

/*
* Reciben un salario semanal fijo sin importar las horas trabajadas
*/
public class Salaried extends Employee{
    public Salaried(String name, String lastName, Double salary){
        super(name, lastName);
        this.salary = salary;
    }
    
    @Override
    public void calculateSalary(){}
}
