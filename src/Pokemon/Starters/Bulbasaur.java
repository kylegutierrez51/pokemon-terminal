package Pokemon.Starters;
import Items.Pokeballs.StandardPokeball;
import Pokemon.Pokemon;
import java.util.Random;
import Pokemon.Gender;
import Pokemon.EVType;

public class Bulbasaur extends Pokemon {
    public Bulbasaur(int level){
        super(level);
        setName("Bulbasaur");
        setNickname(getName());
        setType("Grass/Poison");
        setBaseCatchRate(45);
        setBaseHP(45);
        setBaseAttack(49);
        setBaseDefense(49);
        setBaseSpAttack(65);
        setBaseSpDef(65);
        setBaseSpeed(45);
        calculateStats();
        setCurrentHP(getHp());
        setGender();
        EVType[] evType = {EVType.SP_ATTACK};
        setEVType(evType);
        int[] evYield = {1};
        setEVYield(evYield);
    }
    public void calculateStats(){
        super.calculateStats();
    }

    @Override
    public void setGender(){
        Random random = new Random();
        double randomGender = random.nextDouble();
        if(randomGender <= 0.125){
            gender = Gender.FEMALE;
        }else{
            gender = Gender.MALE;
        }
    }
    @Override
    public void moveList() {

    }
}
