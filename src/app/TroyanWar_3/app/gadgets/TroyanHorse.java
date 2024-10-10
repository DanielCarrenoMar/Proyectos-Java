package app.TroyanWar_3.app.gadgets;

import app.TroyanWar_3.app.warrior.Greek;
import app.TroyanWar_3.app.warrior.Warrior;
import java.util.ArrayList;

public class TroyanHorse {
    private final ArrayList<Greek> greeks;
    private Integer amount;
    private final Integer max;
    
    public TroyanHorse(Integer max){
        greeks = new ArrayList<>();
        amount = 0;
        this.max = max;
    }

    public ArrayList<Greek> getGreeks() {
        return greeks;
    }
    
    public Integer mount(Warrior warrior){
       if (!(warrior instanceof Greek greek)) return -2;
       if (amount >= max) return -1;

       greeks.add(greek);
       amount++;
       return amount;
    }
    
    public Boolean getDown(String name){
        if (amount == 0) return false;
        Integer index = searchWarrior(name);
        if (index == -1) return false;

        greeks.remove(greeks.get(index));
        amount--;
        return true;
    }
    
    public Integer searchWarrior(String name){
        for (int i = 0; i < amount; i++) {
            if (greeks.get(i).getName().equals(name)) return i;
        }
        return -1;
    }
}
