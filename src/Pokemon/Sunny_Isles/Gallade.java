package Pokemon.Sunny_Isles;
import Pokemon.Pokemon;
import Pokemon.Gender;
import java.util.Random;
import Pokemon.EVType;

public class Gallade extends Pokemon{
    public Gallade(int level) {
        super(level);
        setName("Gallade");
        setNickname(getName());
        setType("Psychic/Fighting");
        setBaseCatchRate(45);
        setBaseHP(68);
        setBaseAttack(125);
        setBaseDefense(65);
        setBaseSpAttack(65);
        setBaseSpDef(115);
        setBaseSpeed(80);
        calculateStats();
        setGender();
        setCurrentHP(getHp());
        EVType[] evType = {EVType.ATTACK};
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
        gender = Gender.MALE;
    }
    @Override
    public void moveList() {

    }
}
