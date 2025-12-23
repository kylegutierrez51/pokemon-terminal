package Pokemon.Liti_Cove;
import Pokemon.EVType;
import Pokemon.Pokemon;

public class Snom extends Pokemon {
    public Snom(int level){
        super(level);
        setName("Snom");
        setNickname(getName());
        setType("Bug/Ice");
        setBaseCatchRate(190);
        setBaseHP(30);
        setBaseAttack(25);
        setBaseDefense(35);
        setBaseSpAttack(45);
        setBaseSpDef(30);
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
