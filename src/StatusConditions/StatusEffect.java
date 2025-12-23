package StatusConditions;
import Pokemon.*;
public abstract class StatusEffect {
    protected StatusCondition condition;
    //protected only allows access to same package and subclasses
    public StatusEffect(StatusCondition condition){
        this.condition = condition;
    }
    public StatusCondition getCondition(){
        return condition;
    }
    public abstract void effect(Pokemon pokemon);


    //used for catch rates.
    public abstract double statusModifier();
}
