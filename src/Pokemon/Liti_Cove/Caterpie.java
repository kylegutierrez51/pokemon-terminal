package Pokemon.Liti_Cove;
import Pokemon.EVType;
import Pokemon.Pokemon;

public class Caterpie extends Pokemon {
    public Caterpie(int level){
        super(level);
        setType("Bug");
        setBaseCatchRate(255);
        setName("Caterpie");
        setNickname(getName());
        setBaseHP(45);
        setBaseAttack(30);
        setBaseDefense(35);
        setBaseSpAttack(20);
        setBaseSpDef(20);
        setBaseSpeed(45);
        calculateStats();
        setCurrentHP(getHp());
        setGender();
        EVType[] evType = {EVType.HP};
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
