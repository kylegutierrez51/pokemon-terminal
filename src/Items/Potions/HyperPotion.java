package Items.Potions;
import Items.Item;
import Menu.Bag;
import Menu.UI;
import Pokemon.*;
public class HyperPotion extends Potion {


    public HyperPotion() {
        super("Hyper Potion");
        setItemIndex(2);
    }

    @Override
    public void description() {
        System.out.println("A spray-type medicine for treating wounds. It can be");
        System.out.println("used to restore 120 HP to a Pokemon.");
    }

    @Override
    public void useOn(Pokemon pokemon) {
        int hpGain = 0;
        if(pokemon.getCurrentHP() != pokemon.getHp()){
            int hpRestored = pokemon.getHp() - pokemon.getCurrentHP();
            //150, 120, 135
            //first checks for hpGain, then applies it to the pokemon
            if(hpRestored < 120) {
                hpGain = pokemon.getHp() - pokemon.getCurrentHP();
                pokemon.setCurrentHP(pokemon.getCurrentHP() + hpGain);
            }else{
                hpGain = 120;
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
            }
        }else{
            System.out.println("It won't have any effect.");
            //if the if statement is false, then it means the pokemon has max HP.
        }

    }
}
