package StatusConditions;

import Pokemon.Pokemon;

public class Fainted extends StatusEffect{
    //Nothing much here, just used to display if a Pokemon is fainted

    public Fainted(StatusCondition condition) {
        super(StatusCondition.FAINTED);
    }

    @Override
    public void effect(Pokemon pokemon) {

    }

    @Override
    public double statusModifier() {
        return 0;
    }
    //cant catch a fainted pokemon, statusModifier is practically useless
}
