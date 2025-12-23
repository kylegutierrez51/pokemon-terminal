package Pokemon.Sunny_Isles;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Noibat extends Pokemon{
    public Noibat(int level){
        super(level);
        setName("Noibat");
        setNickname(getName());
        setType("Flying/Dragon");
        setBaseCatchRate(190);
        setBaseHP(40);
        setBaseAttack(30);
        setBaseDefense(35);
        setBaseSpAttack(45);
        setBaseSpDef(40);
        setBaseSpeed(55);
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
