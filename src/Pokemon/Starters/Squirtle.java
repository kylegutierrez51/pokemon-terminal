package Pokemon.Starters;

import Items.Pokeballs.StandardPokeball;
import Pokemon.Pokemon;
import Pokemon.Gender;
import java.util.Random;
import Pokemon.EVType;

public class Squirtle extends Pokemon {
    public Squirtle(int level){
        super(level);
        //if the parameter for String nickname were left between String name and int level,
        //the code would run normally since the Pokemon constructor only has String name and int level.
        setType("Water");
        setName("Squirtle");
        setNickname(getName());
        setBaseHP(44);
        setBaseCatchRate(45);
        setBaseAttack(48);
        setBaseDefense(65);
        setBaseSpAttack(50);
        setBaseSpDef(64);
        setBaseSpeed(43);
        calculateStats();
        setCurrentHP(getHp());
        setGender();
        EVType[] evType = {EVType.DEFENSE};
        setEVType(evType);
        int[] evYield = {1};
        setEVYield(evYield);
    }
    public void calculateStats(){
        super.calculateStats();
    }

    @Override
    public void setMoves(){
        super.setMoves();
    }
    @Override
    public void moveList() {

    }

    @Override
    public void setGender(){
        Random random = new Random();
        double randomGender = random.nextDouble();
        if(randomGender <= 0.125){
            gender = Gender.FEMALE;
        }else{
            gender = Gender.MALE;
        }
    }
}
