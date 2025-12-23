package Items;

import Menu.Party;
import Pokemon.*;

import java.io.IOException;
import java.util.ArrayList;
public abstract class Item {
    private String name;
    private int itemCategory;
    private int itemIndex;
    private final ItemType itemType;
    private boolean battleFunction;

    public Item(String name, ItemType itemType){
        this.name = name;
        this.itemType = itemType;
    }
    public abstract void description();
    public abstract void useOn(Pokemon pokemon) throws InterruptedException;
    public String getName(){
        return name;

    }
    public void setName(String name){
        this.name = name;
    }
    public int getItemCategory(){
        return itemCategory;
    }
    public void setItemCategory(int itemCategory){
        this.itemCategory = itemCategory;
    }
    public int getItemIndex() {
        return itemIndex;
    }
    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public boolean isBattleFunction() {
        return battleFunction;
    }

    public void setBattleFunction(boolean battleFunction) {
        this.battleFunction = battleFunction;
    }

    public static void discardInput(){
        try{
            while(System.in.available() > 0){
                //checks if there are any bytes available in the input stream.
                System.in.read();
                //reads and discards the input.
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
