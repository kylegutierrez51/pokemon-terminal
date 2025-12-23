package Pokemon.ThereOnce;
import Pokemon.Pokemon;

import java.util.Random;
import Pokemon.EVType;
public class Starly extends Pokemon{
    public Starly(int level){
        super(level);
        setName("Starly");
        setNickname(getName());
        setType("Normal/Flying");
        setBaseCatchRate(255);
        setBaseHP(40);
        setBaseAttack(55);
        setBaseDefense(30);
        setBaseSpAttack(30);
        setBaseSpDef(30);
        setBaseSpeed(60);
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
