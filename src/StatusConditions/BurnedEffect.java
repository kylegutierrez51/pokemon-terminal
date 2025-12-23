package StatusConditions;
import Pokemon.*;
public class BurnedEffect extends StatusEffect {
    public BurnedEffect(){
        super(StatusCondition.BURNED);
    }
    public void effect(Pokemon pokemon){
        //half currentAttack with Math.floor(attack * 0.5)
        int hpLoss = pokemon.getMaxHP() / 16;
        pokemon.setCurrentHP(pokemon.getCurrentHP() - hpLoss);
    }

    @Override
    public double statusModifier() {
        return 1.5;
    }

}
