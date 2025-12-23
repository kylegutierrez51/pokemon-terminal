package Pokemon.Lemur_Resort;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Shroodle extends Pokemon{
    public Shroodle(int level){
        super(level);
        setName("Shroodle");
        setNickname(getName());
        setType("Normal/Poison");
        setBaseCatchRate(190);
        setBaseHP(40);
        setBaseAttack(65);
        setBaseDefense(35);
        setBaseSpAttack(40);
        setBaseSpDef(35);
        setBaseSpeed(75);
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
