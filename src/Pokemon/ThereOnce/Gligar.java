package Pokemon.ThereOnce;
import Pokemon.Pokemon;
import Pokemon.EVType;
public class Gligar extends Pokemon{
    public Gligar(int level){
        super(level);
        setName("Gligar");
        setNickname(getName());
        setType("Ground/Flying");
        setBaseCatchRate(60);
        setBaseHP(65);
        setBaseAttack(75);
        setBaseDefense(105);
        setBaseSpAttack(35);
        setBaseSpDef(65);
        setBaseSpeed(85);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.DEFENSE};
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
