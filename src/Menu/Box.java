package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import CustomExceptions.IntegerException;
import Pokemon.Pokemon;

public class Box extends UI {
    //idea: boxcheck method that makes sure arraylist isn't over 6
    //runs everytime you catch a pokemon

    private static final int MAX_POKEMON_PER_BOX = 30;
    public static int currentBox = 1;
    //UPDATE TO PROTECTED

    //ArrayList<Pokemon> p = new ArrayList<Pokemon>(initialCapacity: 8); initialCapacity equals the size
    //ArrayList can contain "any number of items" (as long you have the memory for it)
    // and when doing large initial insertions you can tell ArrayList to allocate a larger storage
    // to begin with as to not waste CPU cycles when it tries to allocate more space for the next item.
    //when it goes over initialCapacity of 8, the list expands to make room for more elements.
    //If no initial value is entered, it starts with 10.

    public static void viewBoxes() {
        Scanner scanner = new Scanner(System.in);
        boolean viewingBoxes = true;
//        int numOfBoxes = 0;
//        for (ArrayList<Pokemon> boxes : pcBox) {
//            numOfBoxes++;
//            System.out.print("Box " + numOfBoxes + "  ");
//        }
        do{
            displayBox();
            System.out.println("Boxes: 1-" + pcBox.size());
            System.out.println("Enter b first, and then the number (b1, b2, ...) to change boxes");
            System.out.println("Enter a pokemon's number to change/view them. Type Q to quit.");
            String input = scanner.nextLine();
            String inputLowerCase = input.toLowerCase();
            if ((inputLowerCase.length() == 2 || inputLowerCase.length() == 3) && inputLowerCase.charAt(0) == 'b'){
                if(inputLowerCase.length() == 2){
                    //checks length() at 2
                    if(Character.isDigit(input.charAt(1))){
                        switchBoxes(inputLowerCase);
                        //checks if it's in format: "b0, b1, b2, b3, ... b9"
                    }else{
                        System.out.println("Invalid Format");
                    }
                }else{
                    if(Character.isDigit(input.charAt(1)) && Character.isDigit(input.charAt(2))){
                        switchBoxes(inputLowerCase);
                        //checks if it's in format: "b11, b12, ... b99"
                    }else{
                        System.out.println("Invalid Format");
                    }
                }
            }else if(inputLowerCase.matches("\\d+")){
                viewPokemon(inputLowerCase);
                //if input has all numbers, then user wants to view a pokemon
            }
            else if(inputLowerCase.equals("q")){
                viewingBoxes = false;
                //quits checking boxes
            }else{
                System.out.println("Invalid format");
                //if user doesn't enter 'b' or 'q' in as char index 0
                //Used to be "Invalid box format", but entering '-' in '-1' counted, so now it's "Invalid Format."
            }
        }while(viewingBoxes);
    }
    public static void viewPokemon(String input){
        Scanner scanner = new Scanner(System.in);
        boolean viewingPokemon = true;
        do{
            try{
                int selectedPokemon = Integer.parseInt(input) - 1;
                //If we select Pokemon from 1, we most likely mean pokemon from index 0. Subtract by 1.
                if(selectedPokemon < 0 || selectedPokemon >= MAX_POKEMON_PER_BOX){
                    //used to be "selectedPokemon > 30" but is now
                    //greater than and equal to 30 because if user enters 31, prints out an
                    //IndexOutOfBoundsException error. This basically now checks for inputs of 31.
                    throw new IntegerException("Invalid Pokemon Index");
                }else if(pcBox.get(currentBox-1).get(selectedPokemon) == null){
                    throw new IntegerException("No Pokemon Selected");
                    //subtract currentBox by 1.
                }
                System.out.println(pcBox.get(currentBox-1).get(selectedPokemon).getName());
                System.out.println("1. Add to Party");
                System.out.println("2. Switch places");
                System.out.println("3. Release Pokemon");
                System.out.println("4. View Info");
                System.out.println("Type Q to quit");
                int choose = 0;
                String userInput = scanner.next();
                boolean isNum = isNumeric(userInput);
                if(isNum){
                    choose = Integer.parseInt(userInput);
                    //if userInput is an int, put its value in the int choose variable
                }
                String confirmLowerCase = userInput.toLowerCase();
                if(confirmLowerCase.equals("q")){
                    viewingPokemon = false;
                }else{
                    viewPokemonInfo(choose);
                    //checks if userInput is valid
                }
                if(choose == 1){
                    if(Party.party.size() < Party.MAX_POKEMON_IN_PARTY){
                        //if party isn't full, automatically add the pokemon to the party to first empty index
                        int firstSlot = 0;
                        int difference = Party.MAX_POKEMON_IN_PARTY - Party.party.size();
                        //firstSlot is used to ensure "manuallyAdd" isn't called numerous times
                        for(int i = 0; i < difference; i++){
                            //add temporary null spaces so that errors don't occur
                            party.add(null);
                        }
                        for(int i = 0; i < Party.party.size() + difference; i++){
                            if(firstSlot == 0 && Party.party.get(i) == null){
                                manuallyAdd(Party.party, i, selectedPokemon, currentBox-1);
                                System.out.println(Party.party.get(i) + "has been added to your party!");
                                firstSlot++;
                            }
                        }
                        for(int i = 0; i < Party.party.size(); i++){
                            if(party.get(i) == null){
                                party.remove(null);
                                //remove the temp null values
                            }
                        }
                        //this ensures that a pokemon wil be added to the next available slot without
                        //generating an error
                    }else {
                        //if party is full
                        boolean switchingPokemon;
                        do {
                            switchingPokemon = true;
                            try {
                                System.out.println("Which party pokemon do you want to switch?");
                                displayPartyPokemon();
                                System.out.println("Enter 1-6.");
                                int switchPokemon = scanner.nextInt();
                                switchPartyPokemon(switchPokemon);
                                //checks if "switchPokemon is between 1 and 6
                                manuallyAdd(Party.party, switchPokemon - 1, selectedPokemon, currentBox-1);
                                //switchPokemon - 1 since Java starts at 0
                                switchingPokemon = false;
                            } catch (IntegerException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (switchingPokemon);
                    }
                }else if(choose == 2){
                    boolean switchingPokemonInBoxes = true;
                    do{
                        displayBox();
                        System.out.println("Where do you want to switch " + pcBox.get(currentBox-1).get(selectedPokemon).getName() + "?");
                        System.out.println("To switch, enter b first, the number of the box, a '/', followed by the pokemon number to switch");
                        System.out.println("Example: b1/1, b8/20, b4/15");
                        System.out.println("To view boxes, Enter b first, and then the number (b1, b2, ...).");
                        System.out.println("Type Q to quit.");
                        String switchPokemonInBoxes = scanner.nextLine();
                        String inputLowerCase = switchPokemonInBoxes.toLowerCase();
                        if(inputLowerCase.equals("q")){
                            switchingPokemonInBoxes = false;
                        }else if(inputLowerCase.length() == 5 || inputLowerCase.length() == 4 && inputLowerCase.charAt(0) == 'b'){
                            switchSelectedPokemon(inputLowerCase, selectedPokemon);
                            //do code that splits the String by regex "/".
                            //if no "/" is found, then prompt the user the second println statement and the option to quit trying.
                            //if a "/" is found, split the function, use the "switchBoxes" method for the first half, and parse the second half
                            //and ensure the second half is a valid pc box.
                            //once ensured, use "switchPokemon" method
                            //after this, all that's left is making a method to switch pokemon around in the party.

                        }else if (inputLowerCase.length() == 2 || inputLowerCase.length() == 3 && inputLowerCase.charAt(0) == 'b'){
                            switchBoxes(inputLowerCase);
                        }
                    }while(switchingPokemonInBoxes);

                }else if(choose == 3){
                    releasePokemon(pcBox.get(currentBox-1).get(selectedPokemon), currentBox-1, selectedPokemon);
                }else if(choose == 4){
                    boolean viewingMember = true;
                    viewPokemon(selectedPokemon, viewingMember, pcBox.get(currentBox-1));
                    //view selectedPokemon, set viewingMember to true, view the pokemon in the box
                }
            }catch(IntegerException e){
                System.out.println(e.getMessage());
                viewingPokemon = false;
            }catch(Exception e){
                System.out.println(e);
                viewingPokemon = false;
            }
        }while(viewingPokemon);
    }
    public static void addInitialBoxes(){
        pcBox = new ArrayList<>(8);
        for(int i = 0; i < 8; i++){
            ArrayList<Pokemon> box = new ArrayList<>(MAX_POKEMON_PER_BOX);
            //adds 8 initial pc boxes
            for(int j = 0; j < MAX_POKEMON_PER_BOX; j++){
                box.add(null);
                //fills pcBoxes elements with 30 empty values
            }
            pcBox.add(box);
        }
        for(int k = 0; k < pcBox.size(); k++){
            if(pcBox.get(k).get(k) != null){
                System.out.println(pcBox.get(k).get(k));
                //for testing purposes later, displays elements of box arraylists
            }
        }
    }
    public static int addCaughtPokemon(Pokemon pokemon){
        //make sure it doesn't go above size = 30
        //goes to whichever pc box the player last left on
        boolean added = false;
        int pokemonAdded = 0;
        int tempCurrentBox = currentBox-1;
        ArrayList<Pokemon> box = pcBox.get(tempCurrentBox);
        while(!added){
            for(int i = 0; i < box.size(); i++){
                if(pcBox.get(i) == null && !added){
                    box.set(i, pokemon);
                    added = true;
                    pokemonAdded = 1;
                }
            } //end for loop
            if(pokemonAdded == 0){
                //then no pokemon was added to that box
                if(pcBox.size() - 1 == tempCurrentBox){
                    tempCurrentBox = 0;
                    //use example of pcBox.size() = 8 and tempCurrentBox = 7
                    // and you'll see that this works
                }else{
                    tempCurrentBox++;
                    box = pcBox.get(tempCurrentBox);
                }
            }
        }
        return tempCurrentBox+1;
    }
    public static void manuallyAdd(ArrayList<Pokemon> party, int partyIndex, int boxIndex, int boxNumber){
        if(boxNumber < 0 || boxNumber >= pcBox.size()){
            throw new IllegalArgumentException("Invalid PC box number!");
        }
        ArrayList<Pokemon> box = pcBox.get(boxNumber);
        if(box.size() >= MAX_POKEMON_PER_BOX){
            throw new IllegalArgumentException("Pokemon box is full");
        }
        if(boxIndex < 0 || boxIndex >= box.size()){
            throw new IllegalArgumentException("Invalid Pokemon Index!");
        }

        Pokemon partyPokemon = party.get(partyIndex);
        Pokemon boxPokemon = box.get(boxIndex);

        box.set(boxIndex, partyPokemon);
        party.set(partyIndex, boxPokemon);
        if(party.get(partyIndex) == null){
            party.remove(partyIndex);
            //REMOVE it if it's null.
        }
        //manually adding requires you to add pokemon from your party
    }
    public static void releasePokemon(Pokemon pokemon, int boxNumber, int boxIndex){
        boolean releasing = true;
        do{
            System.out.println("Are you sure you want to release your pokemon?");
            System.out.println("You will never get it back. (y/yes/n/no)");
            Scanner scanner = new Scanner(System.in);
            String confirmRelease = scanner.next();
            String confirmLowerCase = confirmRelease.toLowerCase();
            if(confirmLowerCase.equals("yes") || confirmLowerCase.equals("y")){
                pcBox.get(boxNumber).set(boxIndex, null);
                releasing = false;
                UI.setTotalPokemon(getTotalPokemon()-1);
            }else if(confirmLowerCase.equals("no") || confirmLowerCase.equals("n")){
                releasing = false;
            }
        }while(releasing);


    }
    public static void switchPokemon(int sourceIndex, int sourceBoxNumber, int destIndex, int destBoxNumber){
        if(sourceBoxNumber < 0 || sourceBoxNumber >= pcBox.size() || destBoxNumber < 0 || destBoxNumber >= pcBox.size()){
            throw new IllegalArgumentException("Invalid PC box number!");
            //checks if the sourceBoxNumber and destBoxNumber are real pc boxes
            //source -> where you're getting pokemon from
            //dest -> where you want to switch that pokemon to
        }
        ArrayList<Pokemon> sourceBox = pcBox.get(sourceBoxNumber);
        ArrayList<Pokemon> destBox = pcBox.get(destBoxNumber);
        //create new ArrayLists representing the boxes

        if(sourceIndex < 0 || sourceIndex >= sourceBox.size() || destIndex < 0 || destIndex >= destBox.size()){
            throw new IllegalArgumentException("Invalid Pokemon Index!");
            //checks if the sourceIndex and destIndex are real values in the sourceBox and destBox
        }
        Pokemon sourcePokemon = sourceBox.get(sourceIndex);
        Pokemon destPokemon = destBox.get(destIndex);
        //stores the pokemon, so that we don't lose their info

        sourceBox.set(sourceIndex, destPokemon);
        destBox.set(destIndex, sourcePokemon);
        //switches the pokemon
    }
    public static int switchBoxes(String input){
        String oneLetter = "";
        String twoLetters;
        int firstDigit = -1;
            try{
                if(Character.isDigit(input.charAt(1))){
                    if(input.length() == 3){
                        if(Character.isDigit(input.charAt(2))){
                            twoLetters = input.charAt(1) + String.valueOf(input.charAt(2));
                            //Java automatically converts "input.charAt(1) to a string and then concatenates
                            //System.out.println(twoLetters); <- Used to ArchivedCode.test output
                            firstDigit = Integer.parseInt(twoLetters) - 1;
                            //-1 needed since user may input "b32", which has its spot at 31
                            //since Java starts at 0.
                        }
                    }else if(input.length() > 3){
                        throw new IllegalArgumentException("Invalid format.");
                    }else{
                        oneLetter = String.valueOf(input.charAt(1));
                        firstDigit = Integer.parseInt(oneLetter) - 1;
                    }
                }else{
                    System.out.println("Invalid format.");
                }
                //System.out.println("Digit: " + firstDigit); <- Used to ArchivedCode.test output
                if(firstDigit >= 0 && firstDigit < pcBox.size()){
                    currentBox = firstDigit + 1;
                    //ex. if input is 5 then currentBox will be 5 since firstDigit is 4
                }else {
                    throw new IllegalArgumentException("Invalid box.");
                }

            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }catch(Exception e){
                System.out.println(e);
            }
        return firstDigit;
    }
    public static void switchSelectedPokemon(String input, int selectedPokemon) {
        //method ensures that input entered by user is correct, and then switches pokemon
        try {
            if(input.charAt(2) == '/' || input.charAt(3) == '/') {
                String[] splitInput = input.split("/");
                String firstHalf = splitInput[0];
                //firstHalf contains "b1, b12, b2..." format
                String secondHalf = splitInput[1];
                //secondHalf contains "1-30" format
                int destBoxNumber = switchBoxes(firstHalf);
                //checks if firstHalf is valid
                int pokemonIndex = Integer.parseInt(secondHalf);
                if(pokemonIndex < 0 || pokemonIndex >= 30){
                    throw new IntegerException("Invalid pokemon index.");
                }
                pokemonIndex--;
                //subtract pokemonIndex by 1 since Java starts at 0 (meaning its from 0-29)
                switchPokemon(selectedPokemon, currentBox, pokemonIndex, destBoxNumber);
                System.out.println(pcBox.get(currentBox-1).get(selectedPokemon).getName() + "has been moved to " + destBoxNumber + ", " + pokemonIndex);

            }else {
                throw new IllegalArgumentException("Invalid format. Enter a '/' in the middle.");
            }
        }catch(IllegalArgumentException | IntegerException e) {
            System.out.println(e.getMessage());
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void addBoxes(){
        //when you add pokemon to the first index of every pc box up to 24,
        //you get 8 additional pc boxes.
        if(pcBox.size() != 32){
            System.out.println(pcBox.size());
            int firstIndexCounter = 0;
            for(ArrayList<Pokemon> pcBoxes : pcBox){
                if(pcBoxes.get(0) != null){
                    firstIndexCounter += 1;
                }
            }
            if(firstIndexCounter == 8){
                for(int i = 8; i < 16; i++){
                    ArrayList<Pokemon> box = new ArrayList<>(MAX_POKEMON_PER_BOX);
                    for(int j = 0; j < MAX_POKEMON_PER_BOX; j++){
                        box.add(null);
                        //fills boxes with empty values
                    }
                    pcBox.add(box);
                }
                for(int k = 0; k < pcBox.size(); k++){
                    if(pcBox.get(k).get(k) != null){
                        System.out.println(pcBox.get(k).get(k));
                    }
                }
            }
            else if(firstIndexCounter == 16){
                for(int i = 16; i < 24; i++){
                    ArrayList<Pokemon> box = new ArrayList<>(MAX_POKEMON_PER_BOX);
                    for(int j = 0; j < MAX_POKEMON_PER_BOX; j++){
                        box.add(null);
                    }
                    pcBox.add(box);
                }
                for(int k = 0; k < pcBox.size(); k++){
                    if(pcBox.get(k).get(k) != null){
                        System.out.println(pcBox.get(k).get(k));
                    }
                }
            }
            else if(firstIndexCounter == 24){
                for(int i = 24; i < 32; i++){
                    ArrayList<Pokemon> box = new ArrayList<>(MAX_POKEMON_PER_BOX);
                    for(int j = 0; j < MAX_POKEMON_PER_BOX; j++){
                        box.add(null);
                    }
                    pcBox.add(box);
                }
                for(int k = 0; k < pcBox.size(); k++){
                    if(pcBox.get(k).get(k) != null){
                        System.out.println(pcBox.get(k).get(k));
                    }
                }
            }
        }
    }
    public static void displayBox(){
        System.out.println();
        int pokemonIndex = 0;
        int emptyBoxCheck = 0;
        //game automatically starts on the box you closed off on
        //when player initiates this for the first time, starts with box 1
        for(int i = 0; i < pcBox.get(currentBox-1).size(); i++){
            if(pcBox.get(currentBox-1).get(i) != null){
                emptyBoxCheck++;
                //ensure currentBox is subtracted by 1, otherwise the last element in pcBox won't display.
            }
        }
        if(emptyBoxCheck == 0){
            System.out.println("Box " + currentBox + ": Empty");
        }else{
            System.out.println("Box " + currentBox);
        }
        for(int i = 0; i < 5; i++){
            int nullCheck = 6;
            for(int j = 0; j < 6; j++){
                pokemonIndex++;
                if(pcBox.get(currentBox - 1).get(pokemonIndex-1) != null){
                    System.out.print(pokemonIndex + ". " + pcBox.get(currentBox -1).get(pokemonIndex-1).getName() +  "   ");
                    nullCheck--;
                    System.out.println(nullCheck);
                }
            }
            if(nullCheck < 6){
                System.out.println();
            }
        }
    }
    public static void viewPokemonInfo(int input) throws IntegerException{
        if(input < 0 || input >= 5){
            throw new IntegerException("Try Again. Enter 1-4 or Q to quit.");
        }
    }
    public static void displayPartyPokemon() {
        for (int i = 0; i < Party.party.size(); i++) {
            System.out.println(i + 1 + ". " + Party.party.get(i).getName());
        }
    }
    public static void switchPartyPokemon(int input) throws IntegerException {
        if(input < 0 || input >= 6){
            throw new IntegerException("Try Again. Enter 1-4 or Q to quit.");
        }
    }
}
