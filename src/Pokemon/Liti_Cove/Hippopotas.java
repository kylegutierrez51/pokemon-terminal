package Pokemon.Liti_Cove;

import Pokemon.Pokemon;
import Pokemon.EVType;
public class Hippopotas extends Pokemon {
    public Hippopotas(int level){
        super(level);
        setName("Hippopotas");
        setNickname(getName());
        setType("Ground");
        setBaseCatchRate(140);
        setBaseHP(68);
        setBaseAttack(72);
        setBaseDefense(78);
        setBaseSpAttack(38);
        setBaseSpDef(42);
        setBaseSpeed(32);
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
