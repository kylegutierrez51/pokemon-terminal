package Pokemon.Lemur_Resort;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Passimian extends Pokemon{
    public Passimian(int level){
        super(level);
        setName("Passimian");
        setNickname(getName());
        setType("Fighting");
        setBaseCatchRate(45);
        setBaseHP(100);
        setBaseAttack(120);
        setBaseDefense(90);
        setBaseSpAttack(40);
        setBaseSpDef(60);
        setBaseSpeed(80);
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
