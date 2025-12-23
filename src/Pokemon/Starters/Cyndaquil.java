package Pokemon.Starters;
import Pokemon.Pokemon;
import Pokemon.EVType;
import java.util.Random;
import Pokemon.Gender;
public class Cyndaquil extends Pokemon {
    public Cyndaquil(int level){
        super(level);
        setName("Cyndaquil");
        setNickname(getName());
        setType("Fire");
        setBaseCatchRate(45);
        setBaseHP(39);
        setBaseAttack(52);
        setBaseDefense(43);
        setBaseSpAttack(60);
        setBaseSpDef(50);
        setBaseSpeed(65);
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
