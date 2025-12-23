package Pokemon.Liti_Cove;
import Pokemon.EVType;
import Pokemon.Pokemon;

public class Rookidee extends Pokemon {
    public Rookidee(int level){
        super(level);
        setName("Rookidee");
        setNickname(getName());
        setType("Flying");
        setBaseCatchRate(255);
        setBaseHP(38);
        setBaseAttack(47);
        setBaseDefense(35);
        setBaseSpAttack(33);
        setBaseSpDef(35);
        setBaseSpeed(57);
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
