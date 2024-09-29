package app.Salary_1.employees;

/*
* Reciben un sueldo por hora y pago por tiempo extra 
* por todas las horas trabajadas que excedan a 40 horas.
*/
public class Hourly  extends Employee{
    private Double payHour;
    private Double payExtraHour;
    private Integer hour;
    
    public Hourly(String name, String lastName, Double payHour, Double payExtraHour, Integer hour){
        super(name, lastName);
        this.payHour = payHour;
        this.payExtraHour = payExtraHour;
        this.hour = hour;
    }
    
    @Override
    public void calculateSalary(){
        if (hour <=  40){
            salary = hour * payHour;
            return;
        }        
        Integer extraHour =  hour - 40;
        salary = (40 * payHour) + extraHour * payExtraHour;
    }
}
