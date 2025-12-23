package Pokemon.ThereOnce;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Axew extends Pokemon{
    public Axew(int level){
        super(level);
        setName("Axew");
        setNickname(getName());
        setType("Dragon");
        setBaseCatchRate(75);
        setBaseHP(46);
        setBaseAttack(87);
        setBaseDefense(60);
        setBaseSpAttack(30);
        setBaseSpDef(40);
        setBaseSpeed(57);
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
