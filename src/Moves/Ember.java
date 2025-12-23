package Moves;

import Pokemon.Pokemon;
import StatusConditions.BurnedEffect;
import StatusConditions.Healthy;
import StatusConditions.StatusCondition;

public class Ember extends Move {
    public Ember(){
        super("Ember", "Fire", "Special", 40, 100, 25);
        //remember, the parameters in super() must match the parameters of any constructor in Move
    }

    @Override
    public void moveDescription() {
        System.out.println("The target is attacked with small flames. It may also leave the target with a burn.");
    }

    @Override
    public void use(Pokemon pokemon, Pokemon opposingPokemon, int moveIndex) throws InterruptedException {
        if(Math.random() * 100 > pokemon.getBattleAccuracy()){
            System.out.println("Ember missed!");
            Thread.sleep(1000);
        }

        calculateDamage(pokemon, opposingPokemon, pokemon.getMoves()[moveIndex]);
        //moveIndex is where Ember is located.
        //use damage calculation
        if(Math.random() * 100 < 10){
            //chance to miss
            opposingPokemon.setStatusCondition(new BurnedEffect()); //opposingPokemon gets Burned Condition
            Thread.sleep(1000);
            System.out.println(opposingPokemon.getName() + " was burned!");
        }
    }
}
