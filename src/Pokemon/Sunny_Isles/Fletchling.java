package Pokemon.Sunny_Isles;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Fletchling extends Pokemon{
    public Fletchling(int level){
        super(level);
        setName("Fletchling");
        setNickname(getName());
        setType("Normal/Flying");
        setBaseCatchRate(255);
        setBaseHP(45);
        setBaseAttack(50);
        setBaseDefense(43);
        setBaseSpAttack(40);
        setBaseSpDef(38);
        setBaseSpeed(62);
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
