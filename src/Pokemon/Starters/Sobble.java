package Pokemon.Starters;
import Pokemon.Pokemon;
import Pokemon.Gender;
import java.util.Random;
import Pokemon.EVType;
public class Sobble extends Pokemon{
    public Sobble(int level){
        super(level);
        setName("Sobble");
        setNickname(getName());
        setType("Water");
        setBaseCatchRate(45);
        setBaseHP(50);
        setBaseAttack(40);
        setBaseDefense(40);
        setBaseSpAttack(70);
        setBaseSpDef(40);
        setBaseSpeed(70);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.SP_DEFENSE, EVType.SPEED};
        int[] evYield = {1, 1};
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
    }@Override
    public void moveList() {

    }
}
