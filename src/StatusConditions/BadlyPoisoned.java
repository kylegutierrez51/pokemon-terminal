package StatusConditions;

import Pokemon.Pokemon;

public class BadlyPoisoned extends StatusEffect {
    protected int increaseOverTime = 1;
    public BadlyPoisoned(){
        super(StatusCondition.BADLY_POISONED);
    }

    @Override
    public void effect(Pokemon pokemon) {
        int hpLost = pokemon.getMaxHP() * increaseOverTime/16;
        pokemon.setCurrentHP(pokemon.getCurrentHP() - hpLost);
        increaseOverTime++;
    }

    @Override
    public double statusModifier() {
        return 1.5;
    }
}
