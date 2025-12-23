package Pokemon.Sunny_Isles;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Mimikyu extends Pokemon{
    public Mimikyu(int level){
        super(level);
        setName("Mimikyu");
        setNickname(getName());
        setType("Ghost/Fairy");
        setBaseCatchRate(45);
        setBaseHP(55);
        setBaseAttack(90);
        setBaseDefense(80);
        setBaseSpAttack(50);
        setBaseSpDef(105);
        setBaseSpeed(96);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.SP_DEFENSE};
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
