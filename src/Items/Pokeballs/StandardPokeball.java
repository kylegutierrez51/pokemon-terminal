package Items.Pokeballs;
import Items.Item;
import Pokemon.*;
public class StandardPokeball extends Pokeball {
    public StandardPokeball() {
        super("Poke Ball", 1);
        //remember, super() is automatically implemented
        setItemIndex(0);
    }

    @Override
    public void description() {
        System.out.println("A device for catching wild Pokemon. It's thrown like");
        System.out.println("a ball at a Pokemon, comfortably encapsulating\nits target.");
    }
}
