package Items.Potions;
import Items.ItemType;
import Pokemon.Pokemon;
import Items.Item;

public abstract class Potion extends Item {

    public Potion(String name) {
        super(name, ItemType.POTION);
        setItemCategory(1);
        setBattleFunction(false);
    }
    @Override
    public abstract void useOn(Pokemon pokemon);
}
