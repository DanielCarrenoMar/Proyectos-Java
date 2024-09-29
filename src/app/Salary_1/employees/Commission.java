package app.Salary_1.employees;

/*
* Reciben un porcentaje de sus ventas
*/
public class Commission  extends Employee{
    private Double sales;
    private Double perce;
    
    public Commission(String name, String lastName, Double sales, Double perce){
        super(name, lastName);
        this.sales = sales;
        
        if (perce > 1) perce = 1.0;
        else if (perce < 0) perce = 0.0;
        this.perce = perce;
    }
    
    @Override
    public void calculateSalary(){
        salary = sales * perce;
    }
}
