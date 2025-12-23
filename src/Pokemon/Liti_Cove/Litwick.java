package Pokemon.Liti_Cove;
import Pokemon.EVType;
import Pokemon.Pokemon;

public class Litwick extends Pokemon {
    public Litwick(int level){
        super(level);
        setName("Litwick");
        setNickname(getName());
        setType("Fire/Ghost");
        setBaseCatchRate(190);
        setBaseHP(50);
        setBaseAttack(30);
        setBaseDefense(55);
        setBaseSpAttack(65);
        setBaseSpDef(55);
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
