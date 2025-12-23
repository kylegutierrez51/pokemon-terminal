package StatusConditions;
import Pokemon.*;
public class ParalyzedEffect extends StatusEffect{

    public ParalyzedEffect() {
        super(StatusCondition.PARALYZED);
    }
    public void effect(Pokemon pokemon){
        //set Pokemon currentSpeed to Math.floor(speed * 0.5)
        //25% chance
        //Math.random() goes from (and includes) 0 to 1 (1 is excluded) and returns an int
        if(Math.random() < 0.25){
            System.out.println(pokemon.getNickname() + "is paralyzed and can't move!");
        }else{
            //proceed with normal turn
        }
    }

    @Override
    public double statusModifier() {
        return 1.5;
    }
}
