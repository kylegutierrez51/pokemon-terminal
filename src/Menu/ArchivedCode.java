package Menu;

import static Menu.UI.bag;

public class ArchivedCode {
    public static void viewBag(){
        int currentCategory;
        currentCategory = 1;
        int tempCategory = currentCategory;
        //When all standard pokeballs are removed, (when it's null), it displays the next available thing
        //so, if we had standard pokeballs and greatballs, then greatballs would be listed as #1
        // if the ArrayList<Item> of standard pokeballs is empty.
        for(int i = 0; i < bag.size(); i++){
            switch(tempCategory){
                case 0 -> System.out.print("Pokeballs" + "     ");
                case 1 -> System.out.print("Potions" + "     ");
                case 2 -> System.out.print("Battle Items" + "     ");
                case 3 -> System.out.print("Key Items" + "     ");
            }
            if(tempCategory+1 == bag.size()){
                tempCategory = 0;
            }else{
                tempCategory++;
            }
        }
    }
}
