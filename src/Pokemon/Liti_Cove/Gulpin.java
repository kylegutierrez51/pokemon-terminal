package Pokemon.Liti_Cove;

import Pokemon.Pokemon;
import Pokemon.EVType;
public class Gulpin extends Pokemon {
    public Gulpin(int level){
        super(level);
        setName("Gulpin");
        setNickname(getName());
        setType("Poison");
        setBaseCatchRate(225);
        setBaseHP(70);
        setBaseAttack(43);
        setBaseDefense(53);
        setBaseSpAttack(43);
        setBaseSpDef(53);
        setBaseSpeed(40);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.HP};
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
