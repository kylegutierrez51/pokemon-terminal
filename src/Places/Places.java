package Places;

import CustomExceptions.IntegerException;
import Menu.UI;
import Pokemon.Pokemon;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import Menu.Party;

public abstract class Places {
    protected static int outsideDialog = 0;
    public static void checkShinyStatus(Pokemon pokemon){
        if(pokemon.getShiny().equals("*")){
            System.out.println("Looks pretty sparkly...");
        }
    }
    public static int determineLevel(int min, int max){
        Random random = new Random();
        //Includes the min and excludes the max. So add max by 1
        return random.nextInt(min, max+1);
    }
    public static int partyAverageLevel(){
        int sum = 0;
        int pokemonInParty = Party.party.size();
        for(Pokemon pokemon : Party.party){
            sum += pokemon.getLevel();
            pokemonInParty++;
        }
        return sum / pokemonInParty;
    }
    public static void placeList(){
        boolean quit = false;
        do{
            Scanner scanner = new Scanner(System.in);
            try{
                System.out.println("1. Liti Cove");
                System.out.println("2. Sunny Isles");
                System.out.println("3. Lemur Resort");
                System.out.println("4. ThereOnce");
                System.out.println("Type Q to quit");
                String input = scanner.next();
                int intInput = 0;
                boolean isNum = UI.isNumeric(input);
                if(isNum){
                    intInput = Integer.parseInt(input);
                }
                String confirmLowerCase = input.toLowerCase();
                if(confirmLowerCase.equals("q")){
                    quit = true;
                }else{
                    placeLimit(intInput);
                }
                if(intInput == 1){
                    LitiCove.huntPokemon();
                }else if(intInput == 2){
                    System.out.println("Sunny Isles is not available yet");
                }else if(intInput == 3){
                    System.out.println("Lemur Resort is not available yet");
                }else if(intInput == 4){
                    System.out.println("ThereOnce is not available yet");
                }
            }catch(IntegerException e){
                System.out.println(e.getMessage());
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }while(!quit);

    }
    public static void randomDots() throws InterruptedException{
        Random random = new Random();
        System.out.println();
        //Thread.sleep(500);
        int randomDots = random.nextInt(1, 7);
        for(int i = 1; i <= randomDots; i++){
            System.out.print(". ");
            Thread.sleep(random.nextInt(200, 500));
        }
        System.out.println();
    }
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

    public static void placeLimit(int selectedPlace) throws IntegerException {
        if(selectedPlace <= 0 || selectedPlace > 4){
            throw new IntegerException("Invalid place.");
        }
    }
}
