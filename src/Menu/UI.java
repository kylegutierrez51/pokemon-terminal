package Menu;

import CustomExceptions.IntegerException;
import CustomExceptions.NickNameException;
import Items.Item;
import Pokemon.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class UI {
    public static ArrayList<Pokemon> party = new ArrayList<>(6);
    public static ArrayList<ArrayList<Pokemon>> pcBox;
    public static ArrayList<ArrayList<Stack<Item>>> bag = new ArrayList<>(4);

    private static int totalPokemon;

    public static void viewPokemon(int pokemon, boolean viewingMember, ArrayList<Pokemon> p){
        Scanner scanner = new Scanner(System.in);
        while(viewingMember){
            System.out.println();
            String gender;
            if(p.get(pokemon).getGender() == Gender.MALE){
                gender = "♂";
            }else if(p.get(pokemon).getGender() == Gender.FEMALE){
                gender = "♀";
            }else{
                gender = "";
            }
            System.out.println("Name: " + p.get(pokemon).getName() + " " + p.get(pokemon).getShiny() + gender);
            if(!p.get(pokemon).getNickname().equals(p.get(pokemon).getName())){
                System.out.println("Nickname: " + p.get(pokemon).getNickname());
                //displays nickname if the pokemon name does not equal the nickname
            }
            System.out.println("Level: " + p.get(pokemon).getLevel());
            System.out.println("Type: " + p.get(pokemon).getType());
            //moves
            System.out.println("1. Change nickname");
            System.out.println("2. View Moves");
            System.out.println("3. View Base Stats");
            System.out.println("4. View Stats");
            System.out.println("5. View IVs");
            System.out.println("6. View EVs");
            System.out.println("Type Q to exit");
            int choose = 0;
            String chooser = "";
            try{
                //try is put in place here so that
                //if an exception is caught, it starts the while loop again
                chooser = scanner.next();
                boolean isNum = isNumeric(chooser);
                //checks if the String chooser is an Int
                if(isNum){
                    choose = Integer.parseInt(chooser);
                    //if chooser is an int, put its value in the int choose variable
                }
                String confirmLowerCase = chooser.toLowerCase();
                if(confirmLowerCase.equals("q")){
                    viewingMember = false;
                }else{
                    PartyOptions(choose); //if choose <= 0 || choose >= 7, IntegerException thrown
                }

                if(choose == 1){
                    changeNickname(pokemon, p);
                }
                else if(choose == 2){
                    System.out.println("Moves will be implemented later");
                }
                else if(choose == 3){
                    viewBaseStats(pokemon, p);
                }
                else if(choose == 4){
                    viewStats(pokemon, p);
                }
                else if(choose == 5){
                    viewIVs(pokemon, p);
                }
                else if(choose == 6){
                    viewEVs(pokemon, p);
                }

            }catch(Exception e){
                System.out.println(e);
                //if this is caught, redoes the viewingMember while loop
                //caught if user enters something that isn't q or a number
            }

        } //end of viewingMember while loop
    }

    //method adds newly caught pokemon to party, checks if there's space available
    public static String addToTeam(Pokemon pokemon){
        if(party.size() < Party.MAX_POKEMON_IN_PARTY){
            party.add(pokemon);
            return pokemon.getNickname() + " has been added to your party!";
        }else{
            int boxNumber = Box.addCaughtPokemon(pokemon);
            return pokemon.getNickname() + " has been sent to PC Box " + boxNumber;
        }
    }
    public static void changeNickname(int pokemonNumber, ArrayList<Pokemon> p){
        //use pokemonNumber to substitute for the get feature of arraylists
        //this is so we don't have to hardcode everything, making code efficient and easier to read
        Scanner scanner = new Scanner(System.in);

        boolean nicknameConfirmation = true;
        do{
            try{
                System.out.println("What would you like to change " + p.get(pokemonNumber).getName() + "'s nickname to?");
                String newNickname = scanner.nextLine();
                nicknameLimit(newNickname);
                System.out.println("Should " + p.get(pokemonNumber).getName() + "'s nickname be " + newNickname + "? (y/yes/n/no)");

                boolean confirmYesNo = false;
                do{
                    String nameConfirmation = scanner.next();
                    String confirmLowerCase = nameConfirmation.toLowerCase();
                    if(confirmLowerCase.equals("yes") || confirmLowerCase.equals("y")){
                        p.get(pokemonNumber).setNickname(newNickname.trim()); //trim() removes whitespaces at beginning and end
                        System.out.println("Your " + p.get(pokemonNumber).getName() + " is now named " + p.get(pokemonNumber).getNickname());
                        confirmYesNo = true;
                        nicknameConfirmation = false;
                        //ends while loop, ending method
                    }else if(confirmLowerCase.equals("no") || confirmLowerCase.equals("n")){
                        confirmYesNo = true;
                        nicknameConfirmation = false;
                        //ends while loop, ending method
                    }else{
                        System.out.println("Should " + p.get(pokemonNumber).getName() + "'s nickname be " + newNickname + "? (y/yes/n/no)");
                        //will keep prompting the user to enter y/yes/n/no
                    }
                }while(!confirmYesNo);
            }catch(NickNameException e){
                if(e.getMessage().isEmpty()){
                    nicknameConfirmation = false;
                }else{
                    System.out.println(e.getMessage());
                }
            }
        }while(nicknameConfirmation);
    }

    public static void viewBaseStats(int pokemonNumber, ArrayList<Pokemon> p){
        System.out.println("Base HP: " + p.get(pokemonNumber).getBaseHP());
        System.out.println("Base Attack: " + p.get(pokemonNumber).getBaseAttack());
        System.out.println("Base Defense: " + p.get(pokemonNumber).getBaseDefense());
        System.out.println("Base Sp Attack: " + p.get(pokemonNumber).getBaseSpAttack());
        System.out.println("Base Sp Defense: " + p.get(pokemonNumber).getBaseSpDef());
        System.out.println("Speed: " + p.get(pokemonNumber).getBaseSpeed());
        System.out.println("Type Q to exit");
        Scanner scanner = new Scanner(System.in);

        boolean viewingMember = true;
        while(viewingMember){
            String exit = scanner.next();
            if(exit.equals("Q") || exit.equals("q")){
                viewingMember = false;
            }else{
                System.out.println("Type Q to exit");
            }
        }
    }
    public static void viewStats(int pokemonNumber, ArrayList<Pokemon> p){
        System.out.println("Nature: " + p.get(pokemonNumber).getNature());
        System.out.println("HP: " + p.get(pokemonNumber).getHp());
        System.out.println("Attack: " + p.get(pokemonNumber).getAttack());
        System.out.println("Defense: " + p.get(pokemonNumber).getDefense());
        System.out.println("Sp Attack: " + p.get(pokemonNumber).getSpAttack());
        System.out.println("Sp Defense: " + p.get(pokemonNumber).getSpDef());
        System.out.println("Speed: " + p.get(pokemonNumber).getSpeed());
        System.out.println("Type Q to exit");
        Scanner scanner = new Scanner(System.in);

        boolean viewingMember = true;
        while(viewingMember){
            String exit = scanner.next();
            if(exit.equals("Q") || exit.equals("q")){
                viewingMember = false;
            }else{
                System.out.println("Type Q to exit");
            }
        }
    }
    public static void viewIVs(int pokemonNumber, ArrayList<Pokemon> p){
        System.out.println("IVS: ");
        System.out.println("HP: " + p.get(pokemonNumber).getHpIV());
        System.out.println("Attack: " + p.get(pokemonNumber).getAttackIV());
        System.out.println("Defense: " + p.get(pokemonNumber).getDefenseIV());
        System.out.println("Sp Attack: " + p.get(pokemonNumber).getSpAttackIV());
        System.out.println("Sp Defense: " + p.get(pokemonNumber).getSpDefIV());
        System.out.println("Speed: " + p.get(pokemonNumber).getSpeedIV());
        System.out.println("Type Q to exit");
        Scanner scanner = new Scanner(System.in);
        boolean viewingMember = true;
        while(viewingMember){
            String exit = scanner.next();
            if(exit.equals("Q") || exit.equals("q")){
                viewingMember = false;
            }else{
                System.out.println("Type Q to exit");
            }
        }
    }
    public static void viewEVs(int pokemonNumber, ArrayList<Pokemon> p){
        System.out.println("EVs: ");
        System.out.println("HP: " + p.get(pokemonNumber).getHpEVs());
        System.out.println("Attack: " + p.get(pokemonNumber).getAttackEVs());
        System.out.println("Defense: " + p.get(pokemonNumber).getDefenseEVs());
        System.out.println("Sp Attack: " + p.get(pokemonNumber).getSpAttackEVs());
        System.out.println("Sp Defense: " + p.get(pokemonNumber).getSpDefEVs());
        System.out.println("Speed: " + p.get(pokemonNumber).getSpeedEVs());
        System.out.println("Type Q to exit");
        Scanner scanner = new Scanner(System.in);

        boolean viewingMember = true;
        while(viewingMember){
            String exit = scanner.next();
            if(exit.equals("Q") || exit.equals("q")){
                viewingMember = false;
            }else{
                System.out.println("Type Q to exit");
            }
        }
    }
    public static void checkPartySize(int pokemonToView) throws IntegerException {
        if(pokemonToView < 0 || pokemonToView >= party.size()){
            if(party.size() == 1){
                throw new IntegerException("Try again, Enter 1.");
            }else{
                throw new IntegerException("Try again. Enter 1-" + party.size());
            }
        }
    }
    public static void PartyOptions(int pokemonToView) throws IntegerException {
        if (pokemonToView <= 0 || pokemonToView >= 7) {
            throw new IntegerException("Try again. Enter 1-6 or Q to quit.");
        }
    }
    public static void nicknameLimit(String nickname) throws NickNameException {
        if (nickname.length() > 18){
            throw new NickNameException("Max characters is 18. Please try again.");
        }else if(nickname.isEmpty()){
            throw new NickNameException("");
            //empty message. In Pokemon, if the nickname entered is empty, it just ends the changeNickname task.
        }
    }
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str); // Try parsing the string as a double
            return true; // If successful, it's a number
        } catch (NumberFormatException e) {
            return false; // If parsing fails, it's not a number
        }
    }

    public static int getTotalPokemon() {
        return totalPokemon;
    }
    public static void pokemonNickname(ArrayList<Pokemon> p){
        //accessed by boxes/parties
        Scanner scanner = new Scanner(System.in);
        boolean nicknameConfirmation = true;
        do{
            try{
                System.out.println("Would you like to nickname your pokemon? (y/yes/n/no)");
                String nameConfirmation = scanner.next();
                scanner.nextLine(); //this consumes newline character left by next()
                //so that the pokemon isn't named " " (a whitespace)
                String confirmLowerCase = nameConfirmation.toLowerCase();
                if(confirmLowerCase.equals("yes") || confirmLowerCase.equals("y")){
                    System.out.println("What should it be named?");
                    String nameOfPokemon = scanner.nextLine();
                    nicknameLimit(nameOfPokemon); //checks nickname characters
                    p.get(0).setNickname(nameOfPokemon.trim()); //trim() removes whitespaces at beginning and end
                    System.out.println("Your " + p.get(0).getName() + " is now named " + p.get(0).getNickname());
                    System.out.println(p.get(0).getNickname() + " was added to your party!" );
                    nicknameConfirmation = false;
                }else if(confirmLowerCase.equals("no") || confirmLowerCase.equals("n")){
                    System.out.println(p.get(0).getName() + " was added to your party!");
                    nicknameConfirmation = false;
                }
            }catch(NickNameException e){
                if(e.getMessage().isEmpty()){
                    nicknameConfirmation = false;
                }else{
                    System.out.println(e.getMessage());
                }
            }
        }while(nicknameConfirmation);
    }
    public static boolean holdingItem(Pokemon pokemon){
        return pokemon.getHeldItem() != null;
        //true if pokemon is holding item
        //false otherwise
    }
    public static void setTotalPokemon(int totalPokemon) {
        UI.totalPokemon = totalPokemon;
    }
//    public static void completelyFull(){
//        //checks if boxes and party are full when player attempts to catch a pokemon
//        boolean checkBoxSize = true;
//        int totalPokemon = 0;
//        while(checkBoxSize){
//            for(ArrayList<Pokemon> boxes : pcBox){
//                for(Pokemon pokemon : boxes){
//                    if(pokemon != null){
//                        totalPokemon++;
//                    }
//                }
//            }
//        }
//
//        if(party.size() == Party.MAX_POKEMON_IN_PARTY){
//            if()
//        }
//    }

}
