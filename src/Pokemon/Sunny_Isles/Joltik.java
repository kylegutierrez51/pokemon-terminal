package Pokemon.Sunny_Isles;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Joltik extends Pokemon{
    public Joltik(int level){
        super(level);
        setName("Joltik");
        setNickname(getName());
        setType("Bug/Electric");
        setBaseCatchRate(190);
        setBaseHP(50);
        setBaseAttack(47);
        setBaseDefense(50);
        setBaseSpAttack(57);
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
    public void moveList() {

    }
}
