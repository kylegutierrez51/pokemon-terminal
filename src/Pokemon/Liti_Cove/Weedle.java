package Pokemon.Liti_Cove;
import Pokemon.EVType;
import Pokemon.Pokemon;

public class Weedle extends Pokemon {
    public Weedle(int level){
        super(level);
        setName("Weedle");
        setNickname(getName());
        setType("Bug/Poison");
        setBaseCatchRate(255);
        setBaseHP(40);
        setBaseAttack(35);
        setBaseDefense(30);
        setBaseSpAttack(20);
        setBaseSpDef(20);
        setBaseSpeed(50);
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
