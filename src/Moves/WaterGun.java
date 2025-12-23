package Moves;

import Pokemon.Pokemon;
import StatusConditions.BurnedEffect;

public class WaterGun extends Move{
    public WaterGun(){
        super("Water Gun", "Water", "Special", 40, 100, 25);
        //remember, the parameters in super() must match the parameters of any constructor in Move
    }

    @Override
    public void moveDescription() {
        System.out.println("The target is blasted with a forceful shot of water.");
    }

    @Override
    public void use(Pokemon pokemon, Pokemon opposingPokemon, int moveIndex) {
        if(Math.random() * 100 > pokemon.getBattleAccuracy()){
            System.out.println("Water Gun missed!");
        }

        calculateDamage(pokemon, opposingPokemon, pokemon.getMoves()[moveIndex]);
        //moveIndex is where Water Gun is located.
        //use damage calculation
    }
}
