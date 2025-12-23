package Pokemon.Lemur_Resort;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Heracross extends Pokemon{
    public Heracross(int level){
        super(level);
        setName("Heracross");
        setNickname(getName());
        setType("Bug/Fighting");
        setBaseCatchRate(45);
        setBaseHP(80);
        setBaseAttack(125);
        setBaseDefense(75);
        setBaseSpAttack(40);
        setBaseSpDef(95);
        setBaseSpeed(85);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.ATTACK};
        int[] evYield = {2};
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
