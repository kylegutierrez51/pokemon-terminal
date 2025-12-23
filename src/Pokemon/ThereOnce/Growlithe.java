package Pokemon.ThereOnce;
import Pokemon.Pokemon;
import Pokemon.Gender;

import java.util.Random;
import Pokemon.EVType;

public class Growlithe extends Pokemon{
    public Growlithe(int level){
        super(level);
        setName("Growlithe");
        setNickname(getName());
        setType("Fire");
        setBaseCatchRate(190);
        setBaseHP(55);
        setBaseAttack(70);
        setBaseDefense(45);
        setBaseSpAttack(70);
        setBaseSpDef(50);
        setBaseSpeed(60);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.ATTACK};
        int[] evYield = {1};
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
        if(randomGender <= 0.25){
            gender = Gender.FEMALE;
        }else{
            gender = Gender.MALE;
        }
    }
    @Override
    public void moveList() {

    }
}
