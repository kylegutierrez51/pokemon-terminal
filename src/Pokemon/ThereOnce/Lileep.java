package Pokemon.ThereOnce;
import Pokemon.Pokemon;
import Pokemon.Gender;

import java.util.Random;
import Pokemon.EVType;
public class Lileep extends Pokemon {
    public Lileep(int level){
        super(level);
        setName("Lileep");
        setNickname(getName());
        setType("Grass/Rock");
        setBaseCatchRate(45);
        setBaseHP(66);
        setBaseAttack(41);
        setBaseDefense(77);
        setBaseSpAttack(61);
        setBaseSpDef(87);
        setBaseSpeed(23);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.SP_DEFENSE};
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
