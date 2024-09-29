package app.Mechanical_2.reparations;

import javax.swing.*;

public abstract class Reparation {
    private String description;
    private Integer hours;
    private Integer maxHours;
    private Integer price;
    private Integer materialPrice;
    private Boolean closed = false;

    private Integer id = 0;
    private static Integer idCount = 0;

    public Reparation(String description, Integer maxHours) {
        this.description = description;
        this.maxHours = maxHours;
        this.hours = 0;
        price = 0;
        id = idCount++;
        this.materialPrice = 0;
    }
    public void setMaterialPrice(Integer materialPrice) {
        if (getClosed()) return;
        this.materialPrice = materialPrice;
    }

    public Integer getMaterialPrice() {
        return materialPrice;
    }

    public void setPrice(Integer price){
        if (closed) return;
        this.price = price;
    }

    public Integer getPrice(){
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Integer getHours() {
        return hours;
    }

    public Boolean getClosed(){
        return closed;
    }

    public void closeReparation(){
        closed = true;
    }

    protected void calculatePrice(Integer hoursAmount){
            price += hoursAmount * 30;
    }

    public void addHour(Integer hoursAmount){
        if (closed) return;
        hours += hoursAmount;
        if (hours > maxHours) closeReparation();
        calculatePrice(hoursAmount);
    }

    public void show(){
        JOptionPane.showMessageDialog(null, "ID: " + id + "\nDescripccion: " + description + "\nHoras trabajadas: " + hours + "\nPrecio: " + price + "\nCerrado: " + closed);
    }
}
