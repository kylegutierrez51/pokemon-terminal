package Items.Pokeballs;
import Items.Item;
import Pokemon.*;
public class Greatball extends Pokeball {
    public Greatball() {
        super("Great Ball", 1.5);
        //remember, super() is automatically implemented
        setItemIndex(1);
    }
    @Override
    public void description() {
        System.out.println("A good, high-performance Poke Ball that provides");
        System.out.println("a higher success rate for catching Pokemon than\na Poke Ball.");
    }
}
