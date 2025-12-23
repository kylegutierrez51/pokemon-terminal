package Pokemon.Sunny_Isles;
import Pokemon.Pokemon;

import java.util.Random;
import Pokemon.EVType;

public class Gardevoir extends Pokemon{
    public Gardevoir(int level){
        super(level);
        setName("Gardevoir");
        setNickname(getName());
        setType("Psychic/Fairy");
        setBaseCatchRate(45);
        setBaseHP(68);
        setBaseAttack(65);
        setBaseDefense(65);
        setBaseSpAttack(125);
        setBaseSpDef(115);
        setBaseSpeed(80);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.SP_ATTACK};
        int[] evYield = {3};
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
