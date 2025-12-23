package Pokemon.ThereOnce;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Gastly extends Pokemon{
    public Gastly(int level){
        super(level);
        setName("Gastly");
        setNickname(getName());
        setType("Ghost");
        setBaseCatchRate(190);
        setBaseHP(30);
        setBaseAttack(35);
        setBaseDefense(30);
        setBaseSpAttack(100);
        setBaseSpDef(35);
        setBaseSpeed(80);
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
    public void moveList() {

    }
}
