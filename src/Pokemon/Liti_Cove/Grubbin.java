package Pokemon.Liti_Cove;

import Pokemon.Pokemon;
import Pokemon.EVType;
public class Grubbin extends Pokemon {
    public Grubbin(int level){
        super(level);
        setName("Grubbin");
        setNickname(getName());
        setType("Bug");
        setBaseCatchRate(255);
        setBaseHP(47);
        setBaseAttack(62);
        setBaseDefense(45);
        setBaseSpAttack(55);
        setBaseSpDef(45);
        setBaseSpeed(46);
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
