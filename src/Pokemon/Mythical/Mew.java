package Pokemon.Mythical;

import Pokemon.Pokemon;
import Pokemon.Gender;

import java.util.Random;
import Pokemon.EVType;
public class Mew extends Pokemon {
    public Mew(int level){
        super(level);
        setName("Mew");
        setNickname(getName());
        setType("Normal");
        setBaseCatchRate(45);
        setBaseHP(100);
        setBaseAttack(100);
        setBaseDefense(100);
        setBaseSpAttack(100);
        setBaseSpDef(100);
        setBaseSpeed(100);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.HP};
        int[] evYield = {3};
        setEVType(evType);
        setEVYield(evYield);
    }
    @Override
    public void calculateStats(){
        super.calculateStats();
    }
    @Override
    public void setGender(){
        gender = Gender.GENDERLESS;
    }
    @Override
    public void IVRandomizer(){
        int[] ivs = {getHpIV(), getAttackIV(), getDefenseIV(), getSpAttackIV(), getSpDefIV(), getSpeedIV()};
        Random randomIVs = new Random();
        int perfectIV = randomIVs.nextInt(0, 6);
        //chooses from 0 to 5
        int[] perfectIVs = {-1, -1, -1};
        perfectIVs[0] = perfectIV;
        int addingPerfectIVs = 1;
        while(addingPerfectIVs <= 2){
            int nextPerfectIV = randomIVs.nextInt(0, 6);
            if(nextPerfectIV != perfectIVs[0] && nextPerfectIV != perfectIVs[1] && nextPerfectIV != perfectIVs[2]){
                perfectIVs[addingPerfectIVs] = nextPerfectIV;
                addingPerfectIVs++;
            }
        }
        //System.out.println(Arrays.toString(perfectIVs)); <- used to ArchivedCode.test code
        setHpIV(randomIVs.nextInt(31) + 1);
        setAttackIV(randomIVs.nextInt(31) + 1);
        setDefenseIV(randomIVs.nextInt(31) + 1);
        setSpAttackIV(randomIVs.nextInt(31) + 1);
        setSpDefIV(randomIVs.nextInt(31) + 1);
        setSpeedIV(randomIVs.nextInt(31) + 1);
        for (int iv : perfectIVs) {
            if (iv == 0) {
                setHpIV(31);
            } else if (iv == 1) {
                setAttackIV(31);
            } else if (iv == 2) {
                setDefenseIV(31);
            } else if (iv == 3) {
                setSpAttackIV(31);
            } else if (iv == 4) {
                setSpDefIV(31);
            } else if (iv == 5) {
                setSpeedIV(31);
            }
        }//end for loop
    } //end method

    @Override
    public void moveList() {

    }
}
