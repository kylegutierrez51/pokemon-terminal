package Pokemon.ThereOnce;
import Pokemon.Pokemon;
import Pokemon.Gender;
import java.util.Random;
import Pokemon.EVType;
public class Vulpix extends Pokemon{
    public Vulpix(int level){
        super(level);
        setName("Vulpix");
        setNickname(getName());
        setType("Fire");
        setBaseCatchRate(190);
        setBaseHP(38);
        setBaseAttack(41);
        setBaseDefense(40);
        setBaseSpAttack(50);
        setBaseSpDef(65);
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
        if(randomGender <= 0.25){
            gender = Gender.MALE;
        }else{
            gender = Gender.FEMALE;
        }
    }
    @Override
    public void moveList() {

    }
}
