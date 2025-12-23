package Menu;

import CustomExceptions.IntegerException;
import Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Scanner;

public class Party extends UI{

    public static final int MAX_POKEMON_IN_PARTY = 6;
    public static void viewParty(ArrayList<Pokemon> party) {
        Scanner scanner = new Scanner(System.in);
        boolean viewingParty = true;
        boolean viewingMember = true;
        boolean canSwitchMembers = false;
        do{
            try{
                boolean partyConfirm = true;
                int pokemon = 0;
                int pokemonInParty = 1;
                while(partyConfirm){
                    System.out.println("Which pokemon do you want to view?");
                    for(int i = 0; i < party.size(); i++){
                        //if(party.get(i) != null){
                        System.out.println(i+1 + ". " + party.get(i).getName());
                        pokemonInParty += i;
                        //iterates through the arraylist to see how many pokemon you have and lists them
                        //}
                    }
                    if(pokemonInParty == 1){
                        System.out.println("Enter 1. To exit, enter Q.");
                    }else{
                        System.out.println("Enter 1-" + pokemonInParty + ".");
                        //displays available Pokemon. Doesn't make sense to do pokemonInParty = 1 and have "Enter 1-1"
                        System.out.println("To switch pokemon, enter 's' first and a number (s1, s2)");
                        System.out.println("To exit, enter Q.");
                        canSwitchMembers = true;
                    }
                    String pokemonToView = scanner.next();
                    String confirmLowerCase = pokemonToView.toLowerCase();
                    if(confirmLowerCase.equals("q")) {
                        viewingParty = false;
                        partyConfirm = false;
                        viewingMember = false;

                    }else{
                        pokemon = Integer.parseInt(pokemonToView) - 1;
                        checkPartySize(pokemon);
                        partyConfirm = false;
                        viewingMember = true;
                    }
                    //if you choose to switch members
                    while(canSwitchMembers){
                        if(confirmLowerCase.length() == 2 && confirmLowerCase.charAt(0) == 's' && Character.isDigit(confirmLowerCase.charAt(1))){
                            //if switching format is valid, call method
                            int firstDigit = validatePartyMembers(confirmLowerCase, canSwitchMembers);
                            System.out.println("Using the same format, enter a second pokemon to switch: ");
                            String secondPokemon = scanner.next();
                            String secondPokemonLowerCase = secondPokemon.toLowerCase();
                            if(secondPokemonLowerCase.length() == 2 && secondPokemonLowerCase.charAt(0) == 's' && Character.isDigit(secondPokemonLowerCase.charAt(1))) {
                                //checks if secondPokemon is formatted correctly
                                int secondDigit = validatePartyMembers(secondPokemonLowerCase, canSwitchMembers);
                                Pokemon pokemon1 = party.get(firstDigit);
                                Pokemon pokemon2 = party.get(secondDigit);
                                party.set(firstDigit, pokemon2);
                                party.set(secondDigit, pokemon1);
                                canSwitchMembers = false;
                            }

                        }
                    }

                }
                viewPokemon(pokemon,viewingMember, party);
            }catch(IndexOutOfBoundsException e){
                System.out.println("Invalid Number.");
                scanner.nextLine();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                scanner.nextLine();
                //catches IntegerException and IllegalArguments
            }
        }while(viewingParty); //end of do while loop
    }
    public static int validatePartyMembers(String input, boolean canSwitchMembers){
        Scanner scanner = new Scanner(System.in);
        String oneLetter = "";
        int firstDigit = -1;
        try{
            oneLetter = String.valueOf(input.charAt(1));
            firstDigit = Integer.parseInt(oneLetter) - 1;
            //Subtract by 1 since Java starts at 0
            //if user puts in 6, it's equivalent to 5 in the ArrayList
            if(firstDigit < 0 || firstDigit > party.size()-1){
                //party.size()-1 = 5
                //5 is number of elements (starting from 0) in party ArrayList
                canSwitchMembers = false;
                throw new IntegerException("Invalid Number.");
            }
        }catch(IntegerException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e);
        }
        canSwitchMembers = true;
        return firstDigit;
    }
    public static void setParty(){
        for(int i = 0; i < 5; i++){
            party.add(null);
            //attempt to add null spaces to the party
            //at the start of the code
            //However, after further analysis it seems inefficient
        }
    }
}
