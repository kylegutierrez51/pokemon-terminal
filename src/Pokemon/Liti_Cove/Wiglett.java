package Pokemon.Liti_Cove;
import Pokemon.EVType;
import Pokemon.Pokemon;

public class Wiglett extends Pokemon {
    public Wiglett(int level){
        super(level);
        setName("Wiglett");
        setNickname(getName());
        setType("Water");
        setBaseCatchRate(255);
        setBaseHP(10);
        setBaseAttack(55);
        setBaseDefense(25);
        setBaseSpAttack(35);
        setBaseSpDef(25);
        setBaseSpeed(95);
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
