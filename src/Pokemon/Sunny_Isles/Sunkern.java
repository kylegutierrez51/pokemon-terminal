package Pokemon.Sunny_Isles;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Sunkern extends Pokemon{
    public Sunkern(int level){
        super(level);
        setName("Sunkern");
        setNickname(getName());
        setType("Grass");
        setBaseCatchRate(235);
        setBaseHP(30);
        setBaseAttack(30);
        setBaseDefense(30);
        setBaseSpAttack(30);
        setBaseSpDef(30);
        setBaseSpeed(30);
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
