package Pokemon.Sunny_Isles;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Ralts extends Pokemon{
    public Ralts(int level){
        super(level);
        setName("Ralts");
        setNickname(getName());
        setType("Psychic/Fairy");
        setBaseCatchRate(235);
        setBaseHP(28);
        setBaseAttack(25);
        setBaseDefense(25);
        setBaseSpAttack(45);
        setBaseSpDef(35);
        setBaseSpeed(40);
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
