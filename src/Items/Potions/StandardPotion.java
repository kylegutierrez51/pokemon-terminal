package Items.Potions;
import Items.Item;
import Menu.Bag;
import Menu.UI;
import Pokemon.*;
public class StandardPotion extends Potion {
    public StandardPotion(){
       super("Potion");
       //if you have the parameter "String name" and
       // inside, the line "name = "Potion", when doing getName(),
       // system prints out "null" -- happened when Item didn't have a String name parameter
        setItemIndex(0);
        //can either add the name of the potion in  the parameter
        //or call "super()" and name the potion without the parameter
    }

    @Override
    public void description() {
        System.out.println("A spray-type medicine for treating wounds. It can be");
        System.out.println("used to restore 20 HP to a Pokemon.");
    }

    @Override
    public void useOn(Pokemon pokemon) {
        int hpGain;
        if(pokemon.getCurrentHP() != pokemon.getHp()){
            System.out.println(pokemon.getCurrentHP());
            System.out.println(pokemon.getHp());
            int hpRestored = pokemon.getHp() - pokemon.getCurrentHP();
            //150, 120, 135
            //first checks for hpGain, then applies it to the pokemon
            if(hpRestored < 20) {
                hpGain = pokemon.getHp() - pokemon.getCurrentHP();
                pokemon.setCurrentHP(pokemon.getCurrentHP() + hpGain);
            }else{
                hpGain = 20;
                //pokemon.getCurrentHP() += hpGain;
                //doesn't work since you attempt to modify the return value of getCurrentHP()
                pokemon.setCurrentHP(pokemon.getCurrentHP() + hpGain);
            }
            //now check for nickname
            if(!pokemon.getNickname().equals(pokemon.getName())){
                //if pokemon has a nickname
                System.out.println(pokemon.getNickname() + "'s HP was restored by " + hpGain + " points.");
                Bag.removeItem(UI.bag.get(getItemCategory()).get(getItemCategory()).peek());
            }else{
                System.out.println(pokemon.getName() + "'s HP was restored by " + hpGain + " points." );
                Bag.removeItem(UI.bag.get(getItemCategory()).get(getItemCategory()).peek());
                System.out.println(pokemon.getCurrentHP());
                System.out.println(pokemon.getHp());
                pokemon.calculateStats();
            }
        }else{
            System.out.println("It won't have any effect.");
            //if the if statement is false, then it means the pokemon has max HP.
        }
    }
}
