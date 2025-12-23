package Pokemon.Liti_Cove;
import Pokemon.EVType;
import Pokemon.Pokemon;

public class Slugma extends Pokemon {
    public Slugma(int level){
        super(level);
        setName("Slugma");
        setNickname(getName());
        setType("Fire");
        setBaseCatchRate(190);
        setBaseHP(40);
        setBaseAttack(40);
        setBaseDefense(40);
        setBaseSpAttack(70);
        setBaseSpDef(40);
        setBaseSpeed(20);
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
