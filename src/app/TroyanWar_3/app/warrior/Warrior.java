package app.TroyanWar_3.app.warrior;


public abstract class Warrior {
    private String name;
    private Integer old;
    private Integer strength;
    private Health health;

    public enum Health {
        DEAD, WOUNDED, OK
    }

    public Warrior(String name, Integer old, Integer strength) {
        this.name = name;
        this.old = validateOld(old);
        this.strength = validateStrength(strength);
        this.health = Health.OK;
    }

    public Warrior() {
        this.name = "GuerreroX";
        this.old = 15;
        this.strength = 1;
        this.health = Health.OK;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public Integer getOld() {
        return old;
    }

    public Integer getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    private Integer validateStrength(Integer value) {
        if (value < 1 || value > 10) return 5;
        return  value;
    }

    private Integer validateOld(Integer value) {
        if (value < 5 || value > 60) return 25;
        return  value;
    }

    public void changeHealth(){
        switch (health){
            case DEAD -> health = Health.WOUNDED;
            case WOUNDED -> health = Health.OK;
            case OK -> health = Health.DEAD;
        }
    }

    public abstract Boolean isRetreat();

    public abstract Warrior clone(String name);

    public abstract String withdrawal();
}
