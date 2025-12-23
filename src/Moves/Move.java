package Moves;
import Pokemon.*;
import StatusConditions.StatusCondition;

public abstract class Move {
    private final String name;
    private String type;
    private String category; //special, physical, status
    //category is there for the user to know what the type is. It doesn't do anything else.
    private int power;
    int accuracy;
    private int pp;
    private int probability; //for applying status effect;

    public Move(String name, String type, String category, int power, int accuracy, int pp){
        this.name = name;
        this.type = type;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
    }
    public void decreasePP(){
        if (pp > 0) {
            pp--;
        }else{
            System.out.println(name + " has no PP left!");
        }
    }
    public abstract void moveDescription();
    public abstract void use(Pokemon pokemon, Pokemon opposingPokemon, int moveIndex) throws InterruptedException;


    //account this for types later on
    public void calculateDamage(Pokemon pokemon, Pokemon opposingPokemon, Move move){
        if(move.category.equals("Physical")){
            int damage = ((2*pokemon.getLevel())/5 + 2) * move.power * pokemon.getAttack()/opposingPokemon.getDefense();
            if(pokemon.getStatusEffect().getCondition() == StatusCondition.BURNED){
                damage /= 2;
            }
            System.out.println("damage dealt by " + pokemon.getName() + ": " + damage);
            opposingPokemon.setHp(opposingPokemon.getHp() - damage);
        }else if(move.category.equals("Special")){
            int damage = ((2*pokemon.getLevel())/5 + 2) * move.power * pokemon.getSpAttack()/opposingPokemon.getSpDef();
            System.out.println("damage dealt by " + pokemon.getName() + ": " + damage);
            opposingPokemon.setHp(opposingPokemon.getHp() - damage);
        }else {
            System.out.println("Move is neither physical or special");
        }
    }

    public String getName() {
        return name;
    }
}
