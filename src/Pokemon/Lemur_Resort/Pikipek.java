package Pokemon.Lemur_Resort;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Pikipek extends Pokemon{
    public Pikipek(int level){
        super(level);
        setName("Pikipek");
        setNickname(getName());
        setType("Normal/Flying");
        setBaseCatchRate(255);
        setBaseHP(35);
        setBaseAttack(75);
        setBaseDefense(30);
        setBaseSpAttack(30);
        setBaseSpDef(30);
        setBaseSpeed(65);
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
    public void moveList() {

    }
}
