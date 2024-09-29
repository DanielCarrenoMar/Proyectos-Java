package app.Mechanical_2.reparations;

public class Paint extends Reparation{

    public Paint(String description) {
        super(description, 504);
    }

    @Override
    protected void calculatePrice(Integer hoursAmount){
        super.calculatePrice(hoursAmount);
        setPrice(getPrice() + getMaterialPrice() * 15);
    }
}
