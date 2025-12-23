package Pokemon.ThereOnce;

import Items.Pokeballs.StandardPokeball;
import Pokemon.Pokemon;
import Pokemon.EVType;

public class Pikachu extends Pokemon {
    public Pikachu(int level){
        super(level);
        setType("Electric");
        setBaseCatchRate(190);
        setName("Pikachu");
        setNickname(getName());
        setBaseHP(35);
        setBaseAttack(55);
        setBaseDefense(40);
        setBaseSpAttack(50);
        setBaseSpDef(50);
        setBaseSpeed(90);
        calculateStats();
        setCurrentHP(getHp());
        setGender();
        EVType[] evType = {EVType.SPEED};
        int[] evYield = {2};
        setEVType(evType);
        setEVYield(evYield);
    }
    public void calculateStats(){
        super.calculateStats();
    }
    @Override
    public void moveList() {

    }
}
