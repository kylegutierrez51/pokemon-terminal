package Pokemon.Lemur_Resort;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Finizen extends Pokemon {
    public Finizen(int level){
        super(level);
        setName("Finizen");
        setNickname(getName());
        setType("Water");
        setBaseCatchRate(200);
        setBaseHP(70);
        setBaseAttack(45);
        setBaseDefense(40);
        setBaseSpAttack(45);
        setBaseSpDef(40);
        setBaseSpeed(75);
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
