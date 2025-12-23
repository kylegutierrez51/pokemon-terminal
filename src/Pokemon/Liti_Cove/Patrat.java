package Pokemon.Liti_Cove;

import Pokemon.Pokemon;
import Pokemon.EVType;
public class Patrat extends Pokemon {
    public Patrat(int level){
        super(level);
        setName("Patrat");
        setNickname(getName());
        setType("Normal");
        setBaseCatchRate(255);
        setBaseHP(45);
        setBaseAttack(55);
        setBaseDefense(39);
        setBaseSpAttack(35);
        setBaseSpDef(39);
        setBaseSpeed(42);
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
