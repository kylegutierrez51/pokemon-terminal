package Pokemon.Lemur_Resort;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Croagunk extends Pokemon{
    public Croagunk(int level){
        super(level);
        setName("Croagunk");
        setNickname(getName());
        setType("Fighting/Poison");
        setBaseCatchRate(140);
        setBaseHP(48);
        setBaseAttack(61);
        setBaseDefense(40);
        setBaseSpAttack(61);
        setBaseSpDef(40);
        setBaseSpeed(50);
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
