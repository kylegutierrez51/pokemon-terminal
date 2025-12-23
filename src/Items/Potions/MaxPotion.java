package Items.Potions;
import Items.Item;
import Menu.Bag;
import Menu.UI;
import Pokemon.*;
public class MaxPotion extends Potion {


    public MaxPotion() {
        super("Max Potion");
        setItemIndex(3);
    }
    @Override
    public void description() {
        System.out.println("A spray-type medicine for treating wounds. It can be");
        System.out.println("used to fully restore the max HP of a Pokemon.");
    }

    @Override
    public void useOn(Pokemon pokemon) {
        int hpGain = 0;
        if(pokemon.getCurrentHP() != pokemon.getHp()){
            int hpRestored = pokemon.getHp() - pokemon.getCurrentHP();
            //150, 120, 135
            //first checks for hpGain, then applies it to the pokemon
            hpGain = pokemon.getHp() - pokemon.getCurrentHP();
            pokemon.setCurrentHP(pokemon.getCurrentHP() + hpGain);

            //now check for nickname
            if(!pokemon.getNickname().equals(pokemon.getName())){
                //if pokemon has a nickname
                System.out.println(pokemon.getNickname() + "'s HP was restored by " + hpGain + " points.");
                Bag.removeItem(UI.bag.get(getItemCategory()).get(getItemCategory()).peek());
            }else{
                System.out.println(pokemon.getName() + "'s HP was restored by " + hpGain + " points." );
                Bag.removeItem(UI.bag.get(getItemCategory()).get(getItemCategory()).peek());
            }
        }else{
            System.out.println("It won't have any effect.");
            //if the if statement is false, then it means the pokemon has max HP.
        }

    }
}
