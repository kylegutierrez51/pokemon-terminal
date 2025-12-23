package Pokemon.Lemur_Resort;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Trapinch extends Pokemon{
    public Trapinch(int level){
        super(level);
        setName("Trapinch");
        setNickname(getName());
        setType("Ground");
        setBaseCatchRate(255);
        setBaseHP(45);
        setBaseAttack(100);
        setBaseDefense(45);
        setBaseSpAttack(45);
        setBaseSpDef(45);
        setBaseSpeed(10);
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
