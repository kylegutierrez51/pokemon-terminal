package Pokemon.ThereOnce;
import Pokemon.Pokemon;
import Pokemon.Gender;
import Pokemon.EVType;
public class Milcery extends Pokemon{
    public Milcery(int level){
        super(level);
        setName("Milcery");
        setNickname(getName());
        setType("Fairy");
        setBaseCatchRate(200);
        setBaseHP(45);
        setBaseAttack(40);
        setBaseDefense(40);
        setBaseSpAttack(50);
        setBaseSpDef(61);
        setBaseSpeed(34);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.SP_DEFENSE};
        int[] evYield = {1};
        setEVType(evType);
        setEVYield(evYield);
    }
    @Override
    public void calculateStats(){
        super.calculateStats();
    }
    @Override
    public void setGender(){
        gender = Gender.FEMALE;
    }
    @Override
    public void moveList() {

    }
}
