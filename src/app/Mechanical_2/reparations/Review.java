package app.Mechanical_2.reparations;

public class Review extends Reparation{

    public Review(String description) {
        super(description, 168);
    }

    @Override
    protected void calculatePrice(Integer hoursAmount){
        super.calculatePrice(hoursAmount);
        setPrice(getPrice() + 10);
    }
}
