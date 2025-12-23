package Pokemon.ThereOnce;
import Pokemon.Pokemon;
import Pokemon.Gender;

import java.util.Random;
import Pokemon.EVType;

public class Snorlax extends Pokemon{
    public Snorlax(int level){
        super(level);
        setName("Snorlax");
        setNickname(getName());
        setType("Normal");
        setBaseCatchRate(25);
        setBaseHP(160);
        setBaseAttack(110);
        setBaseDefense(65);
        setBaseSpAttack(65);
        setBaseSpDef(110);
        setBaseSpeed(30);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.HP};
        int[] evYield = {2};
        setEVType(evType);
        setEVYield(evYield);
    }
    @Override
    public void calculateStats(){
        super.calculateStats();
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
    @Override
    public void moveList() {

    }
}
