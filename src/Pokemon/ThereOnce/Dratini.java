package Pokemon.ThereOnce;
import Pokemon.Pokemon;

import java.util.Random;
import Pokemon.EVType;
public class Dratini extends Pokemon{
    public Dratini(int level){
        super(level);
        setName("Dratini");
        setNickname(getName());
        setType("Dragon");
        setBaseCatchRate(45);
        setBaseHP(41);
        setBaseAttack(64);
        setBaseDefense(45);
        setBaseSpAttack(50);
        setBaseSpDef(50);
        setBaseSpeed(50);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.ATTACK};
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
