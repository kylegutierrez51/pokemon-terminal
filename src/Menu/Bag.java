package Menu;
import CustomExceptions.IntegerException;
import Items.*;
import Items.ItemType;

import java.util.*;

import Items.Pokeballs.*;
import Items.Potions.*;
import Pokemon.Pokemon;

import static Menu.UI.*;

public class Bag {
    protected static int currentCategory = 1;
    private static boolean firstLook = true;
    private static HashMap<Integer, Integer> hashMap;
    //used to properly display the bag in different scenarios

    //includes methods for viewBag and sorting items by alphabet (for now)

    //How this works:
    //first ArrayList consists of categories
    //2nd ArrayList consists of the different types of pokeballs (Standard Pokeball, Greatball, etc.)
    //The stack consists of all the pokeballs within those different types (50 Standard Pokeballs, 20 Greatballs, etc.)
    public static void viewBag(){
        boolean viewingBag = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println(UI.bag);

        do{
            try{
                System.out.println();
                System.out.println();
                displayBag(); //displays categories and prompt
                //System.out.println("currentCategory: " + currentCategory);
                //System.out.println("First look: " + firstLook);
                if(firstLook){
                    //System.out.println("FirstLookTest");
                    viewCurrentCategory(); //views current category
                    firstLook = false;
                    //viewCurrentCategory() only goes once
                }
                boolean enteringInput = true;
                while(enteringInput){
                    try{
                        String userInput = scanner.next();
//                        System.out.println("User Input: " + userInput);
                        String inputLowerCase = userInput.toLowerCase();
                        int userChoice = -1;
                        if(inputLowerCase.equals("q")){
                            viewingBag = false;
                            enteringInput = false;
                            firstLook = true;
                        }else if(inputLowerCase.length() == 2 && inputLowerCase.charAt(0) == 'b'){
                            String s = String.valueOf(inputLowerCase.charAt(1));
                            //checks if you entered the same category
                            //System.out.println("Value of currentCategory: " + currentCategory);
                            if(s.equals(String.valueOf(currentCategory))){
                                System.out.println("You're already viewing this category!");
                            }else{
                                switchCategories(inputLowerCase);
                                //Check if input is valid
                                //if input is valid, view category.
                                //and set a new hashmap to view items
                            }
                        }else {
                            //user entered a number to view an item
                            if(hashMap == null){
                                System.out.println("There are no items to select");
                            }else{
                                boolean isNum = isNumeric(userInput);
                                if(isNum){
                                    userChoice = Integer.parseInt(userInput);
                                }
                                categorySize(userChoice);
                                //if userChoice is less than or equal to 0 and above hashMap.size(),
                                //then throw IntegerException
                                //this ensures the item is valid
//                                System.out.println("hashMap currentCategory: " + currentCategory);
//                                System.out.println("userChoice: " + userChoice);
//                                System.out.println("Hashmap: " + hashMap);
//                                System.out.println("hashMap.get(userChoice): " + hashMap.get(userChoice));
                                //used for testing
                                viewItem(hashMap.get(userChoice));

                            }
                        }
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }catch(Exception e){
                firstLook = true;
                System.out.println("hello");
                System.out.println(e.getMessage());
            }
        }while(viewingBag);
    }
    public static void viewCurrentCategory(){
        viewCategory(currentCategory);
    }
    public static void viewCategory(int userInput){
        //view different arrays of pokeballs/potions
        switch(userInput){
            case 1 ->
                printItems(0);
            case 2 ->
                printItems(1);
            case 3 ->
                printItems(2);
            case 4 ->
                printItems(3);
            default -> {
                System.out.println("Invalid Input. Try Again...");
                firstLook = true;
            }
        }
    }
    public static void viewItem(int index){
        //3 options: Item's description, give, and remove
        int realIndex = currentCategory - 1;
        //currentCategory is 1 above the index in the array
        //Ex. Potions are located in index 1 but currentCategory is 2
        //So, use realIndex to get the item's true location.
        boolean modifyingItem = true;
        Scanner scanner = new Scanner(System.in);
        //System.out.println("index: " + realIndex);
        Item item = bag.get(realIndex).get(index).peek();
        System.out.println();
        System.out.println();
        item.description();
        System.out.println();
        if(item.getItemType() != ItemType.KEY_ITEM){
            while(modifyingItem){
                System.out.println("1. Give Item");
                System.out.println("2. Use Item");
                System.out.println("Type Q to quit");
                String userInput = scanner.next();
                switch(userInput){
                    case "1" -> {
                        try{
                            boolean givingItem = true;
                            int pokemonInParty = 1;
                            int pokemonIndex = -1;
                            while(givingItem){
                                System.out.println("Which party member do you want to give the item to?");
                                System.out.println();
                                for(int i = 0; i < party.size(); i++){
                                    System.out.println(i+1 + ". " + party.get(i).getName());
                                    pokemonInParty += i;
                                    //iterates through the arraylist to see how many pokemon you have and lists them
                                }
                                if(pokemonInParty == 1){
                                    System.out.println("Enter 1. To exit, enter Q.");
                                    System.out.println();
                                }else{
                                    System.out.println("Enter 1-" + pokemonInParty + ". To exit, enter Q.");
                                    System.out.println();
                                }
                                String partyMember = scanner.next();
                                if(partyMember.equalsIgnoreCase("q")){
                                    givingItem = false;
                                }else{
                                    pokemonIndex = Integer.parseInt(partyMember) - 1;
                                    checkPartySize(pokemonIndex);
                                    giveItem(item, party.get(pokemonIndex));
                                    givingItem = false;
                                    modifyingItem = false;
                                    displayBag();
                                    viewCurrentCategory();
                                    //When this switch ends, you go back to the viewBag method and
                                    //can immediately enter another input.
                                    //So, load the bag and view the current category again.
                                }
                            }
                        }catch(IndexOutOfBoundsException e){
                            System.out.println(e.getMessage());
                            System.out.println("Invalid Pokemon Index");
                            scanner.nextLine();
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                            scanner.nextLine();
                        }
                    }
                    case "2" -> {
                        if(item.getItemType() != ItemType.POTION){
                            System.out.println("It won't have any effect.");
                            modifyingItem = false;
                            displayBag();
                            viewCurrentCategory();
                            //When this switch ends, you go back to the viewBag method and
                            //can immediately enter another input.
                            //So, load the bag and view the current category again.
                        }else{
                            try{
                                boolean usingItem = true;
                                int pokemonInParty = 1;
                                int pokemonIndex = -1;
                                while(usingItem){
                                    System.out.println("Which party member do you want to use it on?");
                                    System.out.println();
                                    for(int i = 0; i < party.size(); i++){
                                        System.out.println(i+1 + ". " + party.get(i).getName());
                                        pokemonInParty += i;
                                        //iterates through the arraylist to see how many pokemon you have and lists them
                                    }
                                    if(pokemonInParty == 1){
                                        System.out.println("Enter 1. To exit, enter Q.");
                                    }else{
                                        System.out.println("Enter 1-" + pokemonInParty + ". To exit, enter Q.");
                                    }
                                    String partyMember = scanner.next();
                                    if(partyMember.equalsIgnoreCase("q")){
                                        usingItem = false;
                                    }else{
                                        pokemonIndex = Integer.parseInt(partyMember) - 1;
                                        checkPartySize(pokemonIndex);
                                        useItem(item, party.get(pokemonIndex));
                                        usingItem = false;
                                        modifyingItem = false;
                                        displayBag();
                                        viewCurrentCategory();
                                        //When this switch ends, you go back to the viewBag method and
                                        //can immediately enter another input.
                                        //So, load the bag and view the current category again.

                                    }
                                }
                            }catch(IndexOutOfBoundsException e){
                                System.out.println(e.getMessage());
                                System.out.println("Invalid Pokemon Index");
                                scanner.nextLine();
                            }catch(Exception e){
                                System.out.println(e.getMessage());
                                scanner.nextLine();
                            }
                        }
                    }
                    case "q", "Q" -> {
                        displayBag();
                        viewCurrentCategory();
                        //When this switch ends, you go back to the viewBag method and
                        //can immediately enter another input.
                        //So, load the bag and view the current category again.
                        modifyingItem = false;
                    }
                    default -> {
                        System.out.println("Invalid Input.");
                        scanner.nextLine();
                    }
                }
            }

        }else{
            System.out.println("1. Use Item");
            System.out.println("Type Q to quit");
            String userInput = scanner.next();
            boolean modifyingKeyItem = true;
            while(modifyingKeyItem){
                if(userInput.equals("1")){
                    System.out.println("It won't have any effect.");
                    displayBag();
                    viewCurrentCategory();
                    modifyingKeyItem = false;
                }else if(userInput.equalsIgnoreCase("q")){
                    displayBag();
                    viewCurrentCategory();
                    //When this switch ends, you go back to the viewBag method and
                    //can immediately enter another input.
                    //So, load the bag and view the current category again.
                    modifyingKeyItem = false;
                }else{
                    System.out.println("Invalid Input.");
                }
            }

        }


    }
    public static void addItem(Item item){
        bag.get(item.getItemCategory()).get(item.getItemIndex()).push(item);
    }
    public static void removeItem(Item item){
        //deletes item but doesn't delete arraylist even if arraylist is empty
        if(bag.get(item.getItemCategory()).get(item.getItemIndex()).isEmpty()){
            System.out.println("Empty slot (Bag.removeItem())");
            return;
        }
        bag.get(item.getItemCategory()).get(item.getItemIndex()).pop();
    }
    public static void useItem(Item item, Pokemon pokemon) throws InterruptedException {
        if(item.getItemType() == ItemType.POTION){
            //if item is of type potion
            item.useOn(pokemon);
            System.out.println();
        }else{
            System.out.println("Something went wrong within Bag.useItem()");
        }
    }
    public static void giveItem(Item item, Pokemon pokemon){
        Scanner scanner = new Scanner(System.in);
        boolean holdingItem = UI.holdingItem(pokemon);
        if(item.getItemType() == ItemType.KEY_ITEM){
            return;
        }
        if(holdingItem){
            boolean confirmSwitch = true;
            while(confirmSwitch){
                System.out.println(pokemon.getNickname() + " is already holding " + pokemon.getHeldItem().getName());
                System.out.println("Would you like to switch the item? (y/yes/n/no)");
                String input = scanner.next();
                if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")){
                    switchItem(item, pokemon);
                    confirmSwitch = false;
                }else if(input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")){
                    confirmSwitch = false;
                }else{
                    System.out.println("Invalid Input.");
                }
            }

        }else{
            System.out.println(pokemon.getNickname() + " is now holding the " + item.getName());
            System.out.println();
            pokemon.setHeldItem(item);
            removeItem(item);
            //pop item from bag
        }
    }
    public static void switchItem(Item item, Pokemon pokemon){
        Item temp = pokemon.getHeldItem();
        pokemon.setHeldItem(item);
//        System.out.println("temp.getItemCategory(): " + temp.getItemCategory());
//        System.out.println("temp.getItemIndex(): " + temp.getItemIndex());
        addItem(temp);
        removeItem(item);
        System.out.println(pokemon.getNickname() + " is now holding the " + item.getName());
    }
    public static void printItems(int userChoice){
        hashMap = new HashMap<>();
        currentCategory = userChoice;
        //userChoice is subtracted by 1 (3 -> 2)
        int listedItems = 1;
        int sizeOfCategory = 0;
        //System.out.println("currentCategory: " + currentCategory);
        for(int i = 0; i < bag.get(currentCategory).size(); i++){
            if(!bag.get(currentCategory).get(i).isEmpty()){
                switch(userChoice){
                    case 0 -> System.out.print("");
                    case 1 -> System.out.print("                   ");
                    case 2 -> System.out.print("           ");
                    case 3 -> System.out.print("              ");
                }
                System.out.println(listedItems + ". x" + bag.get(currentCategory).get(i).size() + " " +
                        bag.get(currentCategory).get(i).get(0).getName() +
                        (bag.get(currentCategory).get(i).size() != 1 ? "s " : ""));
                hashMap.put(listedItems, sizeOfCategory);
                listedItems++;
                sizeOfCategory++;
            }else{
                //hashMap.put(listedItems, sizeOfCategory);
                sizeOfCategory++;
            }
            //1 2 3   //0 2 3 or //5 6 7

        }
        if (listedItems == 1){
            switch(userChoice){
                case 0 -> System.out.print("      ");
                case 1 -> System.out.print("                      ");
                case 2 -> System.out.print("                                            ");
                case 3 -> System.out.print("                                                        " +
                        "       ");
            }
            System.out.println("Empty");
            currentCategory++;
            //increment currentCategory back to its normal value
            hashMap = null;
            //no values were placed within hashmap
        }else{
            currentCategory++;
            //increment currentCategory back to its normal value
        }
    }
    public static void initializeBag(){
        for(int i = 0; i < 4; i++){
            ArrayList<Stack<Item>> category = new ArrayList<>();
            bag.add(category);
        }
        for(int i = 0; i < 8; i++){
            if(i < 4){
                Stack<Item> stack = new Stack<>();
                bag.get(0).add(stack);
                Stack<Item> stack1 = new Stack<>();
                bag.get(1).add(stack1);
            }
            Stack<Item> stack = new Stack<>();
            bag.get(2).add(stack);
            Stack<Item> stack1 = new Stack<>();
            bag.get(3).add(stack1);
        }
        for(int i = 0; i < 2; i++){
            Pokeball pokeball = new StandardPokeball();
            Pokeball greatball = new Greatball();
            Pokeball masterball = new Masterball();
            Pokeball ultraball = new Ultraball();
            Potion potion = new StandardPotion();
            Potion superPotion = new SuperPotion();
            Potion hyperPotion = new HyperPotion();
            Potion maxPotion = new MaxPotion();
            bag.get(superPotion.getItemCategory()).get(superPotion.getItemIndex()).push(superPotion);
            bag.get(hyperPotion.getItemCategory()).get(hyperPotion.getItemIndex()).push(hyperPotion);
            bag.get(maxPotion.getItemCategory()).get(maxPotion.getItemIndex()).push(maxPotion);
            bag.get(potion.getItemCategory()).get(potion.getItemIndex()).push(potion);
            bag.get(ultraball.getItemCategory()).get(ultraball.getItemIndex()).push(ultraball);
            bag.get(masterball.getItemCategory()).get(masterball.getItemIndex()).push(masterball);
            bag.get(0).get(0).push(pokeball);
            bag.get(0).get(1).push(greatball);
            bag.get(1).get(0).push(potion);

        }
    }
    public static void categorySize(int userInput) throws IntegerException {
        if(userInput <= 0 || userInput > hashMap.size()){
            //hashMap relates to the Items within the categories
            firstLook = true;
            throw new IntegerException("Invalid Input. Try Again.");
        }
    }
    public static int switchCategories(String input){
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
                        firstDigit = Integer.parseInt(twoLetters);
                        //-1 needed since user may input "b32", which has its spot at 31
                        //since Java starts at 0.
                    }
                }else if(input.length() > 3){
                    throw new IllegalArgumentException("Invalid format.");
                }else{
                    oneLetter = String.valueOf(input.charAt(1));
                    firstDigit = Integer.parseInt(oneLetter);
                }
            }else{
                System.out.println("Invalid format.");
            }
            //System.out.println("Digit: " + firstDigit); <- Used to ArchivedCode.test output
            if(firstDigit > 0 && firstDigit <= bag.size()){
                currentCategory = firstDigit;
                displayBag();
                viewCategory(firstDigit);
                //ex. if input is 2 then currentCategory will be 2 since firstDigit is 2
                //doesn't subtract in this method unlike box.
            }else {
                firstLook = true;
                throw new IllegalArgumentException("Invalid category.");
            }

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e);
        }
        return firstDigit;
    }
    public static void displayBag(){
        System.out.println("Enter b(1-4) respectively to view the category (b1, b2...)");
        System.out.println("Type Q to quit");
        System.out.println();
        System.out.print("    Pokeballs" + "        ");
        System.out.print("Potions" + "          ");
        System.out.print("  Battle Items" + "        ");
        System.out.print(" Key Items" + "         ");
        System.out.println(); //print new line for viewCategory
    }
}
