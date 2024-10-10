package app.TroyanWar_3.app.warrior;

public class Troyan extends Warrior {
    public Troyan(String name, Integer old, Integer strength) {
        super(name, old, strength);
    }

    @Override
    public Boolean isRetreat(){
        return false;
    }

    @Override
    public Warrior clone(String name){
        return new Troyan(name, getOld(), getStrength());
    }

    @Override
    public String withdrawal(){
        return "No se puede retirar. Guerrero troyano no se retira";
    }
}
