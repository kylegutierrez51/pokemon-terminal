package StatusConditions;
import Pokemon.*;
public class FrozenEffect extends StatusEffect {
    public FrozenEffect(){
        super(StatusCondition.FROZEN);
    }
    public void effect(Pokemon pokemon){
        if(Math.random() > 0.2){
            System.out.println("Your " + pokemon.getNickname() + " is frozen!");
        }else{
            System.out.println(pokemon.getNickname() + " has thawed!");
            //update status condition to healthy
            StatusEffect healthy = new Healthy();
            pokemon.setStatusCondition(healthy);
        }
    }

    @Override
    public double statusModifier() {
        return 2.5;
    }
}
