/* UNFINISHED BATTLE SYSTEM */

package BattleSystem;
import Moves.Move;
import Places.Places;
import Pokemon.Pokemon;
import StatusConditions.Fainted;
import StatusConditions.StatusCondition;

import java.util.Scanner;



public class Battle {
    Scanner scanner = new Scanner(System.in);
    public Battle(){

    }
    public void damageOpponent(Pokemon pokemon, Pokemon opposingPokemon, int moveIndex) throws InterruptedException {
        System.out.println(pokemon + " used " + pokemon.getMoves()[moveIndex].getName() + "!");
        Thread.sleep(1000);
        pokemon.getMoves()[moveIndex].use(pokemon, opposingPokemon, moveIndex);
        //calculateDamage (inside use) accounts for whether the move is a Status one. It decrements opposing pokemon's HP.
        Places.discardInput();
    }

    public boolean pokemonFainted(Pokemon pokemon){
        if(pokemon.getHp() <= 0){
            pokemon.setStatusCondition(new Fainted(StatusCondition.FAINTED));
            return true;
        }
        return false;
    }
    public boolean chooseMove(Pokemon pokemon, Pokemon opposingPokemon) throws InterruptedException {
        boolean choosingMove = true;
        int numberOfMoves = 0;
        while(choosingMove){
            for(int i = 0; i < pokemon.getMoves().length; i++){
                if (pokemon.getMoves()[i] != null){
                    System.out.println((i+1) + ". " + pokemon.getMoves()[i]);
                    numberOfMoves++;
                }
            }
            System.out.println("Type Q to exit.");
            String userInput = scanner.next();

            if(userInput.equals("1") && numberOfMoves >= 1){
                fight(pokemon, opposingPokemon, 0);

            }else if(userInput.equals("2") && numberOfMoves >= 2){
                fight(pokemon, opposingPokemon, 1);
            }else if(userInput.equals("3") && numberOfMoves >= 3){
                fight(pokemon, opposingPokemon, 2);
            }else if(userInput.equals("4") && numberOfMoves >= 4){
                fight(pokemon, opposingPokemon, 3);
            }else if(userInput.equalsIgnoreCase("q")){
                choosingMove = false;
            }

            if(opposingPokemon.getStatusEffect().getCondition() == StatusCondition.FAINTED){
                Thread.sleep(1000);
                System.out.println("Opposing " + opposingPokemon.getName() + " has fainted!");
                return false;
            }else if(pokemon.getStatusEffect().getCondition() == StatusCondition.FAINTED){
                Thread.sleep(1000);
                System.out.println(pokemon.getName() + " has fainted!");
                return false;
            }
        }
        return true;
    }

    public void initializeOrFinishBattle(Pokemon pokemon, Pokemon opposingPokemon){
        pokemon.setBattleAttack(pokemon.getAttack());
        pokemon.setBattleDefense(pokemon.getDefense());
        pokemon.setBattleSpAttack(pokemon.getSpAttack());
        pokemon.setBattleSpDef(pokemon.getSpDef());
        pokemon.setBattleSpeed(pokemon.getSpeed());
        pokemon.setBattleAccuracy(pokemon.getAccuracy());
        opposingPokemon.setBattleAttack(pokemon.getAttack());
        opposingPokemon.setBattleDefense(pokemon.getDefense());
        opposingPokemon.setBattleSpAttack(pokemon.getSpAttack());
        opposingPokemon.setBattleSpDef(pokemon.getSpDef());
        opposingPokemon.setBattleSpeed(pokemon.getSpeed());
        opposingPokemon.setBattleAccuracy(pokemon.getAccuracy());
    }

    public void chooseOption(Pokemon pokemon, Pokemon opposingPokemon) throws InterruptedException {
        initializeOrFinishBattle(pokemon, opposingPokemon);
        boolean inBattle = true; //boolean for the while loop for choosing an option
        while(inBattle){
            System.out.println("1. Fight");
            System.out.println("2. Bag");
            System.out.println("3. Switch");
            System.out.println("4. Run");
            String userInput = scanner.next();
            switch(userInput){
                case "1" -> inBattle = chooseMove(pokemon, opposingPokemon);
                case "2" -> System.out.println("opening bag");
                case "3" -> System.out.println("switching pokemon..");
                case "4" -> inBattle = runAway(opposingPokemon);
                default -> System.out.println("Choose 1-4");
            }
        }
        //if pokemon levels up during battle, call both calculateStats() and calculateBattleStats() to update battle stats
        initializeOrFinishBattle(pokemon, opposingPokemon);
    }

    //for code to determine what move the opponent uses
    public int opponentChooseMove(Pokemon opposingPokemon){
        int numberOfMoves = 0;
        for(int i = 0; i < opposingPokemon.getMoves().length; i++){
            if (opposingPokemon.getMoves()[i] != null){
                numberOfMoves++;
            }
            //check if moves aren't null
        }
        return (int)(Math.random() * numberOfMoves); //0 - 3.99 for 4 moves. Rounds down. Properly selects from 0 to 3
    }



    public void fight(Pokemon pokemon, Pokemon opposingPokemon, int moveIndex) throws InterruptedException {
        if(pokemon.getSpeed() > opposingPokemon.getSpeed()){
            //lets you attack first if faster
            damageOpponent(pokemon, opposingPokemon, moveIndex);
            boolean battleOver = pokemonFainted(opposingPokemon);
            if(battleOver){
                return;
            }
            //checks if pokemon fainted. if so, exit this function

            //lets opponent attack if not fainted
            int randomIndex = opponentChooseMove(opposingPokemon);
            damageOpponent(opposingPokemon, pokemon, randomIndex);
            pokemonFainted(opposingPokemon);


        }else if(pokemon.getSpeed() < opposingPokemon.getSpeed()){
            //lets opponent attack first if faster
            int randomIndex = opponentChooseMove(opposingPokemon);
            damageOpponent(opposingPokemon, pokemon, randomIndex);
            boolean battleOver = pokemonFainted(pokemon);
            if(battleOver){
                return;
            }

            //lets you attack if not fainted
            damageOpponent(pokemon, opposingPokemon, moveIndex);
            pokemonFainted(opposingPokemon);
        }else{
            //if equal
            double coinFlip = Math.random(); //between 0 and 1
            if(coinFlip < 0.5){
                //lets you attack first
                damageOpponent(pokemon, opposingPokemon, moveIndex);
                boolean battleOver = pokemonFainted(opposingPokemon);
                if(battleOver){
                    return;
                }
                //lets opponent attack if not fainted
                int randomIndex = opponentChooseMove(opposingPokemon);
                damageOpponent(opposingPokemon, pokemon, randomIndex);
                pokemonFainted(pokemon);
            }else{
                //lets opponent attack first
                int randomIndex = opponentChooseMove(opposingPokemon);
                damageOpponent(opposingPokemon, pokemon, randomIndex);
                boolean battleOver = pokemonFainted(pokemon);
                if(battleOver){
                    return;
                }
                //lets you attack if not fainted
                damageOpponent(pokemon, opposingPokemon, moveIndex);
                pokemonFainted(opposingPokemon);
            }
        }
    }

    //boolean determines whether player is in battle or not
    public boolean runAway(Pokemon opposingPokemon){
        if(opposingPokemon.isShiny()){
            while(true){
                System.out.println("Are you sure you want to run? (y/yes/n/no)");
                String run = scanner.next();
                if(run.equalsIgnoreCase("yes") || run.equalsIgnoreCase("y")){
                    System.out.println("You have successfully ran away!");
                    System.out.println();
                    return false;

                }else if(run.equalsIgnoreCase("no") || run.equalsIgnoreCase("n")){
                    return true; //player did not run away, still in battle
                }
            }
        }else{
            System.out.println("You have successfully ran away!");
            System.out.println();
            return false;
        }
    }


}
