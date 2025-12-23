package Pokemon.Starters;
import Moves.Ember;
import Moves.Growl;
import Pokemon.*;
import Pokemon.Gender;
import java.util.ArrayList;
import java.util.Random;

public class Charmander extends Pokemon {
    //variables are treated as classes outside of methods
    public Charmander(int level){
        super(level);
        setName("Charmander");
        setNickname("Charmander");
        setType("Fire");
        setBaseCatchRate(45);
        setBaseHP(39);
        setBaseAttack(52);
        setBaseDefense(43);
        setBaseSpAttack(60);
        setBaseSpDef(50);
        setBaseSpeed(65);
        calculateStats();
        setCurrentHP(getHp());
        setGender();
        EVType[] evType = {EVType.SPEED};
        setEVType(evType);
        int[] evYield = {1};
        setEVYield(evYield);
        setMoves(); //ADD MOVES TO CHARMANDER
    }
    private ArrayList movesAllowed = new ArrayList<>();
    @Override
    public void calculateStats(){
        super.calculateStats();
        //uses calculateStats method from Pokemon.Pokemon abstract class
    }
    @Override
    public void setGender(){
        Random random = new Random();
        double randomGender = random.nextDouble();
        //returns 0 - 1
        if(randomGender <= 0.125){
            gender = Gender.FEMALE;
        }else{
            gender = Gender.MALE;
        }
    }

    //sets wild pokemon moves based on their level based on their move list
    //sets their moves to their last 4 moves
    @Override
    public void setMoves(){
        super.setMoves();
    }

    //sets arraylist movesLearned with already learned moves
    public void moveList(){
        if(getLevel() >= 1){
            getMovesLearned().add(new Growl());
        }
        if(getLevel() >= 4){
            getMovesLearned().add(new Ember());
        }
    }


}
