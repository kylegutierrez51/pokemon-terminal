package StatusConditions;

import Pokemon.Pokemon;

public class PoisonedEffect extends StatusEffect {
    public PoisonedEffect(){
        super(StatusCondition.POISONED);
    }

    @Override
    public void effect(Pokemon pokemon) {
        int hpLost = pokemon.getMaxHP() /16;
        pokemon.setCurrentHP(pokemon.getCurrentHP() - hpLost);

        //pokemon.getCurrentHP() = pokemon.getCurrentHP() - hpLost;
        //Wrong because it sets a method equal to something even though the methods return int variables

    }

    @Override
    public double statusModifier() {
        return 1.5;
    }
}
