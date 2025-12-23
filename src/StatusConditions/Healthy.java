package StatusConditions;

import Pokemon.Pokemon;

public class Healthy extends StatusEffect {
    public Healthy(){
        super(StatusCondition.HEALTHY);
    }

    @Override
    public void effect(Pokemon pokemon) {
        //nothing.
    }

    @Override
    public double statusModifier() {
        return 1;
    }

}
