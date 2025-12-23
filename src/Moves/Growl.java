package Moves;

import Pokemon.Pokemon;

public class Growl extends Move{
    public Growl(){
        super("Growl", "Normal", "Status", 0, 100, 40);
        //remember, the parameters in super() must match the parameters of any constructor in Move
    }

    @Override
    public void moveDescription() {
        System.out.println("The user growls in an endearing way, making opposing Pokémon less wary. This lowers their Attack stats.");
    }

    @Override
    public void use(Pokemon pokemon, Pokemon opposingPokemon, int moveIndex) throws InterruptedException {
        if(Math.random() * 100 > pokemon.getBattleAccuracy()) {
            System.out.println("Ember missed!");
            Thread.sleep(1000);
        }
        int targetAttackModifier = opposingPokemon.getAttackModifier(); //default is 6 -> representing a 1x
        if(targetAttackModifier == 0){
            System.out.println(opposingPokemon.getName() + "'s attack can't be lowered anymore!");
        }else{
            opposingPokemon.setAttackModifier(targetAttackModifier--);
            double stageMultiplier = opposingPokemon.getStageMultipliers()[targetAttackModifier]; //reduces to 5, for ex.
            int newAttack = (int) (opposingPokemon.getBattleAttack() * stageMultiplier);
            opposingPokemon.setAttack(newAttack);
            System.out.println(opposingPokemon.getName() + "'s attack was lowered!");
        }
    }

}
