import CustomExceptions.IntegerException;
import Items.Potions.*;
import Menu.*;
import Pokemon.*;
import Pokemon.Starters.*;
import Pokemon.ThereOnce.*;
import Pokemon.Mythical.*;
import Places.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public final class Controller {
    public static void main(String[] args) throws IntegerException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to Pokemon Simulator,");
        System.out.println("A small program where you can hunt, catch, and battle Pokemon!");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        discardInput();


        System.out.println("\nChoose your Pokemon");
        //Party.setParty();
        //sets first 6 elements of party arraylist to null. [unused function]

        ChooseYourStarter(Party.party);
        UI.pokemonNickname(Party.party);

        System.out.println();
        System.out.println("Hmmmm... what should you do now?");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        Box.addInitialBoxes();
        Bag.initializeBag();
        String gameOptions;
        while(true){
            try {
                discardInput();
                System.out.println("1. Check Party");
                System.out.println("2. Check Bag");
                System.out.println("3. Check Box");
                System.out.println("4. HUNT!");
                System.out.println("5. Quit");
                System.out.println("Enter 1-4");
                //System.out.println("type Q to save.");
                gameOptions = scanner.next();
                switch (gameOptions) {
                    case "1" -> Party.viewParty(Party.party);
                    case "2" -> Bag.viewBag();
                    case "3" -> Box.viewBoxes();
                    case "4" -> Places.placeList();
                    case "5" -> System.exit(0);
                    default -> System.out.println("Choose 1-5.");
                }
            }catch(Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void ChooseYourStarter(ArrayList<Pokemon> party) {
        Scanner scanner = new Scanner(System.in);
        boolean chosePokemon = false;
        while (!chosePokemon) {
            System.out.println("1. Charmander");
            System.out.println("2. Bulbasaur");
            System.out.println("3. Squirtle");
            System.out.println("4. Pikachu");
            System.out.println("Enter 1-4.");
            String starter = scanner.next();
            if(starter.equals("1")){
                System.out.println("Are you sure you want Charmander? (y/yes/n/no)");
                String confirm = scanner.next();
                String confirmLowerCase = confirm.toLowerCase();
                if(confirmLowerCase.equals("yes") || confirmLowerCase.equals("y")){
                    Pokemon charmander = new Charmander(5);
                    //moves are added in constructor
                    System.out.println("You have chosen Charmander!");
                    shinyStarterCheck(charmander);
                    party.add(charmander);
                    UI.setTotalPokemon(1);
                    chosePokemon = true;
                }
            }
            else if(starter.equals("2")){
                System.out.println("Are you sure you want Bulbasaur? (y/yes/n/no)");
                String confirm = scanner.next();
                String confirmLowerCase = confirm.toLowerCase();
                if(confirmLowerCase.equals("yes") || confirmLowerCase.equals("y")){
                    //Bulbasaur bulbasaur = new Bulbasaur("Bulbasaur", "Bulbasaur", 5);
                    Pokemon bulbasaur = new Bulbasaur(5);
                    System.out.println("You have chosen Bulbasaur!");
                    shinyStarterCheck(bulbasaur);
                    party.add(bulbasaur);
                    UI.setTotalPokemon(1);
                    chosePokemon = true;
                }
            }
            else if(starter.equals("3")){
                System.out.println("Are you sure you want Squirtle? (y/yes/n/no)");
                String confirm = scanner.next();
                String confirmLowerCase = confirm.toLowerCase();
                if(confirmLowerCase.equals("yes") || confirmLowerCase.equals("y")){
                    //Squirtle squirtle = new Squirtle("Squirtle", "Squirtle", 5);
                    Pokemon squirtle = new Squirtle(5);
                    System.out.println("You have chosen Squirtle!");
                    shinyStarterCheck(squirtle);
                    party.add(squirtle);
                    UI.setTotalPokemon(1);
                    chosePokemon = true;
                }
            }
            else if(starter.equals("4")){
                System.out.println("Are you sure you want Pikachu? (y/yes/n/no)");
                String confirm = scanner.next();
                String confirmLowerCase = confirm.toLowerCase();
                if(confirmLowerCase.equals("yes") || confirmLowerCase.equals("y")){
                    //Pikachu pikachu = new Pikachu("Pikachu", "Pikachu", 5);
                    Pokemon pikachu = new Pikachu(5);
                    System.out.println("You have chosen Pikachu!");
                    shinyStarterCheck(pikachu);
                    party.add(pikachu);
                    UI.setTotalPokemon(1);
                    chosePokemon = true;
                }
            }
        }
    }
    public static void shinyStarterCheck(Pokemon pokemon){
        Random random = new Random();
        double shiny = random.nextDouble();
        boolean isShiny = false;
        if(shiny <= 0.0078125){
            isShiny = true;
        }
        if(isShiny){
            System.out.println("Looks pretty sparkly...");
            pokemon.setShinyStatus(isShiny);
        }
    }

    //"discardInput()" is used to discard any letters the user types in when unnecessary.
    //For example, if you typed in a key, maybe "4", with the keyboard when the ". . ." animation plays when hunting,
    //the game would take that and run away from the pokemon before the battle even starts. This discardInput() makes sure
    //that doesn't happen and is used throughout the program.
    public static void discardInput(){
        try{
            while(System.in.available() > 0){
                //checks if there are any bytes available in the input stream.
                System.in.read();
                //reads and discards the input.
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
