package Pokemon.Sunny_Isles;
import Pokemon.Pokemon;

import java.util.Random;
import Pokemon.EVType;
public class Shinx extends Pokemon{
    public Shinx(int level){
        super(level);
        setName("Shinx");
        setNickname(getName());
        setType("Electric");
        setBaseCatchRate(235);
        setBaseHP(45);
        setBaseAttack(65);
        setBaseDefense(34);
        setBaseSpAttack(40);
        setBaseSpDef(34);
        setBaseSpeed(45);
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

