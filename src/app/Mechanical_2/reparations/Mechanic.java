package app.Mechanical_2.reparations;

public class Mechanic extends Reparation {

    public Mechanic(String description) {
        super(description, 294);
    }

    @Override
    protected void calculatePrice(Integer hoursAmount){
            super.calculatePrice(hoursAmount);
            setPrice(getPrice() + getMaterialPrice() * 20);
    }
}
