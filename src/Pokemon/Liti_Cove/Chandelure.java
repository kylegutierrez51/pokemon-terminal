package Pokemon.Liti_Cove;

import Pokemon.Pokemon;
import Pokemon.EVType;
public class Chandelure extends Pokemon {
    public Chandelure(int level){
        super(level);
        setType("Fire/Ghost");
        setName("Chandelure");
        setNickname(getName());
        setBaseCatchRate(45);
        setBaseHP(60);
        setAttack(55);
        setBaseDefense(90);
        setBaseSpAttack(145);
        setBaseSpDef(90);
        setBaseSpeed(80);
        calculateStats();
        setCurrentHP(getHp());
        setGender();
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
