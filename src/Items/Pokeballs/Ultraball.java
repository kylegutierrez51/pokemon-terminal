package Items.Pokeballs;
import Items.Item;
import Pokemon.*;
public class Ultraball extends Pokeball {


    public Ultraball() {
        super("Ultra Ball", 2);
        setItemIndex(2);
    }

    @Override
    public void description() {
        System.out.println("An ultra-high-performance Poke Ball that provides");
        System.out.println("a higher success rate for catching Pokemon than\na Great Ball.");
    }
}
