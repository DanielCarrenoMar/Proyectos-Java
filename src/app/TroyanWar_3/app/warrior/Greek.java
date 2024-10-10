package app.TroyanWar_3.app.warrior;

public class Greek extends Warrior {
    private Boolean retreat;

    public Greek(String name, Integer old, Integer strength) {
        super(name, old, strength);
        retreat = false;
    }

    public Boolean getRetreat() {
        return retreat;
    }

    @Override
    public Boolean isRetreat(){
        return retreat;
    }

    @Override
    public Warrior clone(String name){
        return new Greek(name, getOld(), getStrength());
    }

    @Override
    public String withdrawal(){
        if (retreat) return "No se puede retirar. Guerrero retirado";

        return switch (getHealth()) {
            case OK -> {
                retreat = true;
                yield "Retirada en curso";
            }
            case WOUNDED -> "No se puede retirar. Guerrero herido";
            case DEAD -> "No se puede retirar. Guerrero muerto";
            default -> "No se puede retirar. Error desconocido";
        };
    }
}
