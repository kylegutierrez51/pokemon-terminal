package Pokemon.ThereOnce;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Lapras extends Pokemon{
    public Lapras(int level){
        super(level);
        setName("Lapras");
        setNickname(getName());
        setType("Water/Ice");
        setBaseCatchRate(45);
        setBaseHP(130);
        setBaseAttack(85);
        setBaseDefense(80);
        setBaseSpAttack(85);
        setBaseSpDef(95);
        setBaseSpeed(60);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.HP};
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
