package Pokemon.Lemur_Resort;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Zubat extends Pokemon{
    public Zubat(int level){
        super(level);
        setName("Zubat");
        setNickname(getName());
        setType("Flying/Poison");
        setBaseCatchRate(255);
        setBaseHP(40);
        setBaseAttack(45);
        setBaseDefense(35);
        setBaseSpAttack(30);
        setBaseSpDef(40);
        setBaseSpeed(55);
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
