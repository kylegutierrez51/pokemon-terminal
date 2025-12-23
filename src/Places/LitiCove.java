package Places;
import Menu.Box;
import Menu.Party;
import Pokemon.Liti_Cove.*;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import Pokemon.Mythical.Marshadow;
import Pokemon.Pokemon;


//----------------------------------------------------------------------
// Caterpie, Chandelure, Grubbin, Gulpin, Hippopotas, Litwick, Patrat,
// Rattata, Rookidee, Slugma, Snom, Weedle, Wiglett
//----------------------------------------------------------------------
public class LitiCove extends Places {
    private static boolean keepHunting = true;
    private static boolean hunting = true;
    private static int visits = 0;
    private static Pokemon pokemon;
    private static boolean inBattle;

    public static void huntPokemon(){
        //boolean hunting = true;
        //boolean keepHunting = true;
        try{
            Random random = new Random();

            //method that player uses to hunt with
            if(visits < 2){
                System.out.println("Liti Cove, a place fueled by a dumpster fire");
                System.out.println("who calls himself 'Liti.'\n");
                Thread.sleep(3000);
                System.out.println("Contains all sorts of");
                System.out.println("common Pokemon that he considers either 'cursed' or 'real'\n");
                Thread.sleep(4000);
                visits++;
                Places.discardInput();
            }
            if(outsideDialog == 0){
                System.out.println("Finally, you're outside for what's felt like a long time ");
                Thread.sleep(3000);
                outsideDialog++;
                Places.discardInput();
            }
            do{
                Scanner scanner = new Scanner(System.in);
                keepHunting = true;
                System.out.println("What Pokemon are you going to find?");
                System.out.println("Type any key to hunt. Type Q to stop.");
                //alternative: Make it so that you can only write in alphabets
                String input = scanner.next();
                String inputLowerCase = input.toLowerCase();
                if(inputLowerCase.equals("q")){
                    keepHunting = false;
                    hunting = false;
                }
                while(keepHunting){
                    Places.randomDots();
                    pokemon = pokemonRarity();
                    System.out.println("A wild " + pokemon.getName() + " appeared!");
                    checkShinyStatus(pokemon);
                    keepHunting = false; //so you can get out of while loop
                    inBattle = true;
                    //try catch discards any entered input
                    Places.discardInput();
                }
                while(inBattle){
                    System.out.println("1. Fight");
                    System.out.println("2. Bag");
                    System.out.println("3. Switch");
                    System.out.println("4. Run");
                    String userInput = scanner.next();
                    switch(userInput){
                        case "1" -> System.out.println("fighting");
                        case "2" -> System.out.println("opening bag");
                        case "3" -> System.out.println("switching pokemon..");
                        case "4" -> {
                            if(pokemon.isShiny() || pokemon.getName().equals("Marshadow")){
                                boolean confirmRun = true;
                                while(confirmRun){
                                    System.out.println("Are you sure you want to run? (y/yes/n/no)");
                                    String run = scanner.next();
                                    if(run.equalsIgnoreCase("yes") || run.equalsIgnoreCase("y")){
                                        System.out.println("You have successfully ran away!");
                                        System.out.println();
                                        confirmRun = false;
                                        inBattle = false;

                                    }else if(run.equalsIgnoreCase("no") || run.equalsIgnoreCase("n")){
                                        break;
                                    }
                                }
                            }else{
                                System.out.println("You have successfully ran away!");
                                System.out.println();
                                inBattle = false;
                            }
                        }
                        default -> System.out.println("Choose 1-4");
                    }
                }
            }while(hunting);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static Pokemon pokemonRarity(){
        Random random = new Random();
        double mythical = random.nextDouble();
        double shiny = random.nextDouble();
        double randomPokemon = random.nextDouble() * 100; //or random.nextDouble(100)
        boolean shinyFound = false;
        int level;
        if(shiny <= 0.0078125){
            shinyFound = true;
        }
        if(mythical <= 0.0078125){
            Pokemon marshadow = new Marshadow(10);
            marshadow.setShinyStatus(shinyFound);
            return marshadow;
        }
        else {
            if(randomPokemon >= 0 && randomPokemon < 1){ //<- chandelure - 1%
                level = determineLevel(41, 45);
                Pokemon chandelure = new Chandelure(level);
                chandelure.setShinyStatus(shinyFound);
                return chandelure;
            }else if(randomPokemon >= 1 && randomPokemon < 10){ //<- litwick - 9%
                level = determineLevel(5, 9);
                Pokemon litwick = new Litwick(level);
                litwick.setShinyStatus(shinyFound);
                return litwick;
            }else if(randomPokemon >= 10 && randomPokemon < 20){ //<- Snom: 10%
                level = determineLevel(5, 9);
                Pokemon snom = new Snom(level);
                snom.setShinyStatus(shinyFound);
                return snom;
            }else if(randomPokemon >= 20 && randomPokemon < 30){ //<- Wiglett: 10%
                level = determineLevel(5, 9);
                Pokemon wiglett = new Wiglett(level);
                wiglett.setShinyStatus(shinyFound);
                return wiglett;
            }else if(randomPokemon >= 30 && randomPokemon < 40){ //<- Weedle: 10%
                level = determineLevel(5, 9);
                Pokemon weedle = new Weedle(level);
                weedle.setShinyStatus(shinyFound);
                return weedle;
            }else if(randomPokemon >= 40 && randomPokemon < 50){ //<- Grubbin: 10%
                level = determineLevel(5, 9);
                Pokemon grubbin = new Grubbin(level);
                grubbin.setShinyStatus(shinyFound);
                return grubbin;
            }else if(randomPokemon >= 50 && randomPokemon < 60){ //<- Hippopotas: 10%
                level = determineLevel(5, 9);
                Pokemon hippopotas = new Hippopotas(level);
                hippopotas.setShinyStatus(shinyFound);
                return hippopotas;
            }else if(randomPokemon >= 60 && randomPokemon < 65){ //<- Patrat: 5%
                level = determineLevel(5, 9);
                Pokemon patrat = new Patrat(level);
                patrat.setShinyStatus(shinyFound);
                return patrat;
            }else if(randomPokemon >= 65 && randomPokemon < 70){ //<- Rattata: 5%
                level = determineLevel(5, 9);
                Pokemon rattata = new Rattata(level);
                rattata.setShinyStatus(shinyFound);
                return rattata;
            }else if(randomPokemon >= 70 && randomPokemon < 80){ //<- Rookidee: 10%
                level = determineLevel(5, 9);
                Pokemon rookidee = new Rookidee(level);
                rookidee.setShinyStatus(shinyFound);
                return rookidee;
            }else if(randomPokemon >= 80 && randomPokemon < 90){ //<- Caterpie: 10%
                level = determineLevel(5, 9);
                Pokemon caterpie = new Caterpie(level);
                caterpie.setShinyStatus(shinyFound);
                return caterpie;
            }else if(randomPokemon >= 90 && randomPokemon < 95){ //<- Slugma: 5%
                level = determineLevel(5, 9);
                Pokemon slugma = new Slugma(level);
                slugma.setShinyStatus(shinyFound);
                return slugma;
            }else{ //<- Gulpin: 5%
                level = determineLevel(5, 9);
                Pokemon gulpin = new Gulpin(level);
                gulpin.setShinyStatus(shinyFound);
                return gulpin;
            }
        }
    }
    public static int getVisits(){
        return visits;
    }
    public void setVisits(int visits){
        //this.visits = visits;
        //code above displays "Static member visits accessed via instance reference"
        LitiCove.visits = visits;
    }
}
