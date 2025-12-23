package Items.Potions;
import Items.Item;
import Menu.Bag;
import Menu.UI;
import Pokemon.*;
public class SuperPotion extends Potion {
    public SuperPotion() {
        super("Super Potion");
        setItemIndex(1);
    }

    @Override
    public void description() {
        System.out.println("A spray-type medicine for treating wounds. It can be");
        System.out.println("used to restore 60 HP to a Pokemon.");
    }

    @Override
    public void useOn(Pokemon pokemon) {
        int hpGain;
        if(pokemon.getCurrentHP() != pokemon.getHp()){
            int hpRestored = pokemon.getHp() - pokemon.getCurrentHP();
            //150, 120, 135
            //first checks for hpGain, then applies it to the pokemon
            if(hpRestored < 60) {
                hpGain = pokemon.getHp() - pokemon.getCurrentHP();
                pokemon.setCurrentHP(pokemon.getCurrentHP() + hpGain);
            }else{
                hpGain = 60;
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
