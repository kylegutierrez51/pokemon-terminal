package Pokemon.Lemur_Resort;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Crobat extends Pokemon{
    public Crobat(int level) {
        super(level);
        setName("Crobat");
        setNickname(getName());
        setType("Flying/Poison");
        setBaseCatchRate(90);
        setBaseHP(85);
        setBaseAttack(90);
        setBaseDefense(80);
        setBaseSpAttack(70);
        setBaseSpDef(80);
        setBaseSpeed(130);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.SPEED};
        int[] evYield = {3};
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
