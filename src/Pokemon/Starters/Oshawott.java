package Pokemon.Starters;
import Pokemon.Pokemon;
import Pokemon.EVType;
import java.util.Random;
import Pokemon.Gender;
public class Oshawott extends Pokemon{
    public Oshawott(int level){
        super(level);
        setName("Oshawott");
        setNickname(getName());
        setType("Water");
        setBaseCatchRate(45);
        setBaseHP(55);
        setBaseAttack(55);
        setBaseDefense(45);
        setBaseSpAttack(63);
        setBaseSpDef(45);
        setBaseSpeed(45);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.SP_ATTACK};
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
