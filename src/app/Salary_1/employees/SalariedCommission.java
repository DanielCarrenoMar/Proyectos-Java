package app.Salary_1.employees;

/*
* Reciben un salario base más un porcentaje de sus ventas
*/
public class SalariedCommission  extends Commission{
    private Double baseSalary;
    
    public SalariedCommission(String name, String lastName, Double salary, Double sales, Double perce){
        super(name, lastName, sales, perce);
        baseSalary = salary;
    }
    
    @Override
    public void calculateSalary(){
        super.calculateSalary();
        salary += baseSalary;
    }
    
}

