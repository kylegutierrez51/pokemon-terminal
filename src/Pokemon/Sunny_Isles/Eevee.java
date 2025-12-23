package Pokemon.Sunny_Isles;
import Pokemon.Pokemon;

import java.util.Random;
import Pokemon.Gender;
import Pokemon.EVType;
public class Eevee extends Pokemon{
    public Eevee(int level){
        super(level);
        setName("Eevee");
        setNickname(getName());
        setType("Normal");
        setBaseCatchRate(45);
        setBaseHP(55);
        setBaseAttack(55);
        setBaseDefense(50);
        setBaseSpAttack(45);
        setBaseSpDef(65);
        setBaseSpeed(55);
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
