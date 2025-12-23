package Items.Pokeballs;
import Items.Item;
import Pokemon.*;
public class Masterball extends Pokeball {
    public Masterball() {
        super("Masterball", 255);
        //remember, super() is automatically implemented
        setItemIndex(3);
    }

    @Override
    public void description() {
        System.out.println("The very best Poke Ball with the ultimate level of");
        System.out.println("performance. With it, you will catch any wild Pokemon\nwithout fail.");
    }
}
