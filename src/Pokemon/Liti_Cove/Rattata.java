package Pokemon.Liti_Cove;

import Pokemon.Pokemon;
import Pokemon.EVType;
public class Rattata extends Pokemon {
    public Rattata(int level){
        super(level);
        setType("Normal");
        setName("Rattata");
        setNickname(getName());
        setBaseCatchRate(255);
        setBaseHP(30);
        setBaseAttack(56);
        setBaseDefense(35);
        setBaseSpAttack(25);
        setBaseSpDef(35);
        setBaseSpeed(72);
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
