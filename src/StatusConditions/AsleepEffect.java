package StatusConditions;
import Pokemon.*;
public class AsleepEffect extends StatusEffect {
    int sleepCounter = 0;
    public AsleepEffect(){
        super(StatusCondition.ASLEEP);
    }
    public void effect(Pokemon pokemon){
        if(sleepCounter == 0){
            System.out.println(pokemon.getNickname() + " is asleep!");
            sleepCounter++;
        }else if(sleepCounter == 1){
            if(Math.random() <= (1/3f)){
                System.out.println(pokemon.getNickname() + "has woken up!");
                sleepCounter = 0;
                StatusEffect healthy = new Healthy();
                pokemon.setStatusCondition(healthy);
            }else{
                System.out.println(pokemon.getNickname() + " is asleep!");
                sleepCounter++;
            }
        }else if(sleepCounter == 2){
            if(Math.random() <= (1/3f)){
                System.out.println(pokemon.getNickname() + " has woken up!");
                sleepCounter = 0;
                StatusEffect healthy = new Healthy();
                pokemon.setStatusCondition(healthy);
            }else{
                System.out.println(pokemon.getNickname() + " is asleep!");
                sleepCounter++;
            }
        }else{
            System.out.println("sleepCounter: " + sleepCounter);
            sleepCounter = 0;
            System.out.println(pokemon.getNickname() + " has woken up!");
            StatusEffect healthy = new Healthy();
            pokemon.setStatusCondition(healthy);
        }
    }
    @Override
    public double statusModifier() {
        return 2.5;
    }
}
