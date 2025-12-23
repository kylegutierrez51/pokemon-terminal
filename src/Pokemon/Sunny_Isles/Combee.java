package Pokemon.Sunny_Isles;
import Pokemon.Pokemon;
import Pokemon.Gender;

import java.util.Random;
import Pokemon.EVType;
public class Combee extends Pokemon{
    public Combee(int level){
        super(level);
        setName("Combee");
        setNickname(getName());
        setType("Bug/Flying");
        setBaseCatchRate(120);
        setBaseHP(30);
        setBaseAttack(30);
        setBaseDefense(42);
        setBaseSpAttack(30);
        setBaseSpDef(42);
        setBaseSpeed(70);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.SPEED};
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
