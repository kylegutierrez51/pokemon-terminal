package Pokemon;

import java.util.ArrayList;
import java.util.Random;

import Items.Item;
import Moves.Moves;
import Moves.Move;
import StatusConditions.*;

public abstract class Pokemon {
    private int hp, attack, defense, spAttack, spDef, speed;
    private int hpIV, attackIV, defenseIV, spAttackIV, spDefIV, speedIV;
    private int hpEVs = 0, attackEVs = 0, defenseEVs = 0, spAttackEVs = 0, spDefEVs = 0, speedEVs = 0;
    private int baseHP, baseAttack, baseDefense, baseSpAttack, baseSpDef, baseSpeed;
    private int battleAttack, battleDefense, battleSpAttack, battleSpDef, battleSpeed, battleAccuracy;
    private int level; String name; String nickname; String type; String nature; String shiny = "";
    private int maxHP = hp;
    private int accuracy = 100;
    private int currentHP = hp;
    private int baseCatchRate;
    private StatusEffect statusEffect;
    private StatusCondition statusCondition;
    protected Gender gender;
    private boolean shinyStatus;
    private Item heldItem;
    private EVType[] evType = new EVType[3];
    private int[] evYield = new int[3];
    private Move[] moves = new Move[4];
    private ArrayList<Move> movesLearned = new ArrayList<>();
    private final double[] stageMultipliers = {
            (double) 2/8, (double) 2 /7, (double) 2/6, (double) 2/5,
            (double) 2/4, (double) 2/3, (double) 2/2, (double) 3/2,
            (double) 4/2, (double) 5/2, (double) 6/2, (double) 7/2, (double) 8/2
            }; // -6 -> 0 -> 6

    private final double[] accuracyMultipliers = {
            (double) 3/9, (double) 3/8, (double) 3/7, (double) 3/6,
            (double) 3/5, (double) 3/4, (double) 3/3, (double) 4/3,
            (double) 5/3, (double) 6/3, (double) 7/3, (double) 8/3, (double) 9/3
            }; // -6 -> 0 -> 6

    private int attackModifier = 6, defenseMultiplier = 6, spAttackMultiplier = 6, spDefMultiplier = 6, speedMultiplier = 6;
    private int accuracyMultiplier = 6;
    //set them to 6 to represent stageMultipliers[6] and accuracyMultipliers[6], which is the default modifier

    String[][] natures = {{"Hardy", "Lonely", "Adamant", "Naughty", "Brave"},
        {"Bold", "Docile", "Impish", "Lax", "Relaxed"},
        {"Modest", "Mild", "Bashful", "Rash", "Quiet"},
        {"Calm", "Gentle", "Careful", "Quirky", "Sassy"},
        {"Timid", "Hasty", "Jolly", "Naive", "Serious"}};

    //public ArrayList<Moves> moves = new ArrayList<>();
    String[] types;
    public Pokemon(int level){
        this.level = level;
        this.statusCondition = StatusCondition.HEALTHY;
        this.statusEffect = new Healthy();
        IVRandomizer();
    }
    public Pokemon(String name, int level){
        this.name = name;
        this.nickname = name;
        this.level = level;
        this.statusCondition = StatusCondition.HEALTHY;
        this.statusEffect = new Healthy();
        IVRandomizer();
        //calculateStats();
        //doing calculateStats() here calls this first and THEN applies the base stats to charmander
        //which doesn't calculate the correct base stats. This assumes that calculateStats() isn't
        //in the charmander constructor
    }
    //public abstract void baseStats();
    //Not needed. Put it in the constructor


    //CONSIDER adding stageMultipliers into calculateStats(). Could be used incase I recalculate stats in battle, but be careful
    //Don't let stageMultipliers leak! --reset them in battle.
    public void calculateStats(){
        hp = (int) Math.floor(0.01 * (2 * baseHP + hpIV + Math.floor(0.25 * hpEVs)) * level) + level + 10;
        attack = (int) (Math.floor(0.01 * (2 * baseAttack + attackIV + Math.floor(0.25 * attackEVs)) * level) + 5);
        defense = (int) (Math.floor(0.01 * (2 * baseDefense + defenseIV + Math.floor(0.25 * defenseEVs)) * level) + 5);
        spAttack = (int) (Math.floor(0.01 * (2 * baseSpAttack + spAttackIV + Math.floor(0.25 * spAttackEVs)) * level) + 5);
        spDef = (int) (Math.floor(0.01 * (2 * baseSpDef + spDefIV + Math.floor(0.25 * spDefEVs)) * level) + 5);
        speed = (int) (Math.floor(0.01 * (2 * baseSpeed + speedIV + Math.floor(0.25 * speedEVs)) * level) + 5);
        natureModifier(natures);
    }

    //Decided it would be best to make calculateBattleStats() separate from calculateStats() cuz if a pokemon
    //leveled up in battle and I used "calculateStats()" to recalculate its stats for its level, it could remove any
    //stat changes (like if they used Swords Dance) that the Pokemon had
    public void calculateBattleStats(int attackModifier, int defenseModifier,int spAttackModifier,
                                     int spDefModifier, int speedModifier, int accuracyMultiplier){
        battleAttack = attack * attackModifier;
        battleDefense = defense * defenseModifier;
        battleSpAttack = spAttack * spAttackModifier;
        battleSpDef = spDef * spDefModifier;
        battleSpeed = speed * speedModifier;
    }
    public void IVRandomizer(){
        Random randomIVs = new Random();
        hpIV = randomIVs.nextInt(31) + 1;
        attackIV = randomIVs.nextInt(31) + 1;
        defenseIV = randomIVs.nextInt(31) + 1;
        spAttackIV = randomIVs.nextInt(31) + 1;
        spDefIV = randomIVs.nextInt(31) + 1;
        speedIV = randomIVs.nextInt(31) + 1;
    }
    public void setStatusCondition(StatusEffect statusEffect){
        this.statusEffect = statusEffect;
        //Could be a healthy, paralyzed, asleep constructor, etc.
        this.statusCondition = statusEffect.getCondition();
        //HEALTHY, POISONED, etc.

    }
    public abstract void moveList();

    //sets wild pokemon moves based on their level based on their move list
    //sets their moves to their last 4 moves
    public void setMoves(){
        int size = getMovesLearned().size() - 1; //if size is 2, then it's 1 here
        int i = 0;
        while(size >= 0 && i < 4){
            getMoves()[i++] = getMovesLearned().get(size--);
        }
    }

    //used for trainer battles; is not required right now. For now, the method is empty.
    public void customizeMoves(){

    }

    //Unused attempt to give a Pokemon EVs and ensure it doesn't go over 512.
    public void giveEVs(Pokemon userPokemon, Pokemon opposingPokemon){
        //int maxEVs = maxEVs();
        if(maxEVs() == 512){
            return;
        }else{
            int availableEVs = 512 - maxEVs();
            int evSum = 0;
            for(int i = 0; i < evYield.length; i++){
                evSum += evYield[i];
            }
            if(evSum > availableEVs){
                //loop occurs if availableEVs is very small, like 1-3.
                //happens if opposing pokemon give more EVs than what's available
                int[] temp = evYield;
                 for(int i = 0; i < evYield.length; i++){
                     if(temp[i] == 0){
                         //0 is equivalent to null for int[] in this case
                         break;
                     }
                     if(temp[i] > availableEVs){
                        temp[i] = availableEVs;
                        for(int j = i; j < evYield.length; j++){
                            if(j+1 < evYield.length){
                                temp[j+1] = 0;
                                //this determines if temp[j+1] exists and
                                //sets remaining to 0
                            }
                        }
                     }else{
                         //if availableEVs is greater than temp[i]
                         //availableEVs: 3
                         //evSum: 4
                         //attack ev: 2
                         //defense ev: 2
                         availableEVs -= temp[i];
                     }
                 }
            }
            for(int i = 0; i < evType.length; i++){
                //both arrays evType and evYield will have
                //the same length regardless
                switch(opposingPokemon.evType[i]){
                    case null -> { //does nothing
                    }
                    case HP -> {
                        if(userPokemon.getHpEVs() + opposingPokemon.evYield[i] >= 252){
                            userPokemon.setHpEVs(252);
                            break;
                        }
                        userPokemon.setHpEVs(hpEVs + opposingPokemon.evYield[i]);
                    }
                    case ATTACK -> {
                        if(userPokemon.getAttackEVs() + opposingPokemon.evYield[i] >= 252){
                            userPokemon.setAttackEVs(252);
                            break;
                        }
                        userPokemon.setAttackEVs(attackEVs + opposingPokemon.evYield[i]);
                    }
                    case DEFENSE -> {
                        if(userPokemon.getDefenseEVs() + opposingPokemon.evYield[i] >= 252){
                            userPokemon.setDefenseEVs(252);
                            break;
                        }
                        userPokemon.setDefenseEVs(defenseEVs + opposingPokemon.evYield[i]);
                    }
                    case SP_ATTACK -> {
                        if(userPokemon.getSpAttackEVs() + opposingPokemon.evYield[i] >= 252){
                            userPokemon.setSpAttackEVs(252);
                            break;
                        }
                        userPokemon.setSpAttackEVs(spAttackEVs + opposingPokemon.evYield[i]);
                    }
                    case SP_DEFENSE -> {
                        if(userPokemon.getSpDefEVs() + opposingPokemon.evYield[i] >= 252){
                            userPokemon.setSpDefEVs(252);
                            break;
                        }
                        userPokemon.setSpDefEVs(spDefEVs + opposingPokemon.evYield[i]);
                    }
                    case SPEED -> {
                        if(userPokemon.getSpeedEVs() + opposingPokemon.evYield[i] >= 252){
                            userPokemon.setSpeedEVs(252);
                            break;
                        }
                        userPokemon.setSpeedEVs(speedEVs + opposingPokemon.evYield[i]);
                    }
                }
            }
        }

    }
    public StatusEffect getStatusEffect() {
        return statusEffect;
    }

    public int getBaseCatchRate(){
        return baseCatchRate;
    }
    public void natureModifier(String[][] natures){
        Random random = new Random();
        int randomModifier = random.nextInt(natures.length);
        //natures multidimensional array has a length of 5
        //this chooses a number from 0 to 4

        int randomDemodifier = random.nextInt(natures[randomModifier].length);
        //chooses from 0 to 4
        double rounder1;
        double rounder2;
        nature = natures[randomModifier][randomDemodifier];

        if(randomModifier == 0){
            rounder1 = attack * 1.1;
            attack = (int) Math.floor(rounder1);
        }else if(randomModifier == 1){
            rounder1 = defense * 1.1;
            defense = (int) Math.floor(rounder1);
        }else if(randomModifier == 2){
            rounder1 = spAttack * 1.1;
            spAttack = (int) Math.floor(rounder1);
        }else if(randomModifier == 3){
            rounder1 = spDef * 1.1;
            spDef = (int) Math.floor(rounder1);
        }else if(randomModifier == 4){
            rounder1 = speed * 1.1;
            speed = (int) Math.floor(rounder1);
        }
        if(randomDemodifier == 0){
            rounder2 = attack * 0.9;
            attack = (int) Math.floor(rounder2);
        }else if(randomDemodifier == 1){
            rounder2 = defense * 0.9;
            defense = (int) Math.floor(rounder2);
        }else if(randomDemodifier == 2){
            rounder2 = spAttack * 0.9;
            spAttack = (int) Math.floor(rounder2);
        }else if(randomDemodifier == 3){
            rounder2 = spDef * 0.9;
            spDef = (int) Math.floor(rounder2);
        }else if(randomDemodifier == 4){
            rounder2 = speed * 0.9;
            speed = (int) Math.floor(rounder2);
        }
    }
    public int maxEVs(){
        return hpEVs + attackEVs + defenseEVs + spAttackEVs + spDefEVs + speedEVs;
    }
    public void setGender(){
        Random random = new Random();
        double randomGender = random.nextDouble();
        if(randomGender > 0.5){
            gender = Gender.FEMALE;
        }else{
            gender = Gender.MALE;
        }
    }
    public Gender getGender(){
        return gender;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getSpAttack() {
        return spAttack;
    }
    public void setSpAttack(int spAttack) {
        this.spAttack = spAttack;
    }
    public int getSpDef() {
        return spDef;
    }

    public void setSpDef(int spDef) {
        this.spDef = spDef;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHpIV() {
        return hpIV;
    }
    public void setHpIV(int hpIV) {
        this.hpIV = hpIV;
    }
    public int getAttackIV() {
        return attackIV;
    }
    public void setAttackIV(int attackIV) {
        this.attackIV = attackIV;
    }
    public int getDefenseIV() {
        return defenseIV;
    }
    public void setDefenseIV(int defenseIV) {
        this.defenseIV = defenseIV;
    }
    public int getSpAttackIV() {
        return spAttackIV;
    }
    public void setSpAttackIV(int spAttackIV) {
        this.spAttackIV = spAttackIV;
    }
    public int getSpDefIV() {
        return spDefIV;
    }
    public void setSpDefIV(int spDefIV) {
        this.spDefIV = spDefIV;
    }
    public int getSpeedIV() {
        return speedIV;
    }
    public void setSpeedIV(int speedIV) {
        this.speedIV = speedIV;
    }
    public int getHpEVs() {
        return hpEVs;
    }
    public void setHpEVs(int hpEVs) {
        this.hpEVs = hpEVs;
    }
    public int getAttackEVs() {
        return attackEVs;
    }
    public void setAttackEVs(int attackEVs) {
        this.attackEVs = attackEVs;
    }
    public int getDefenseEVs() {
        return defenseEVs;
    }
    public void setDefenseEVs(int defenseEVs) {
        this.defenseEVs = defenseEVs;
    }
    public int getSpAttackEVs() {
        return spAttackEVs;
    }
    public void setSpAttackEVs(int spAttackEVs) {
        this.spAttackEVs = spAttackEVs;
    }
    public int getSpDefEVs() {
        return spDefEVs;
    }
    public void setSpDefEVs(int spDefEVs) {
        this.spDefEVs = spDefEVs;
    }
    public int getSpeedEVs() {
        return speedEVs;
    }
    public void setSpeedEVs(int speedEVs) {
        this.speedEVs = speedEVs;
    }
    public int getBaseHP() {
        return baseHP;
    }
    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }
    public int getBaseAttack() {
        return baseAttack;
    }
    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }
    public int getBaseDefense() {
        return baseDefense;
    }
    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }
    public int getBaseSpAttack() {
        return baseSpAttack;
    }
    public void setBaseSpAttack(int baseSpAttack) {
        this.baseSpAttack = baseSpAttack;
    }
    public int getBaseSpDef() {
        return baseSpDef;
    }
    public void setBaseSpDef(int baseSpDef) {
        this.baseSpDef = baseSpDef;
    }
    public int getBaseSpeed() {
        return baseSpeed;
    }
    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }
    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
    public void setBaseCatchRate(int baseCatchRate){
         this.baseCatchRate = baseCatchRate;
    }

    public void setShinyStatus(boolean isShiny){
         this.shinyStatus = isShiny;
         if(isShiny){
             setShiny("*");
         }
    }

    public String getShiny() {
        return shiny;
    }

    public void setShiny(String shiny) {
        this.shiny = shiny;
    }

    public boolean isShiny(){
         return shinyStatus;
    }

    public Item getHeldItem() {
        return heldItem;
    }
    public void setHeldItem(Item heldItem) {
        this.heldItem = heldItem;
    }

    public EVType[] getEVType() {
        return evType;
    }

    public void setEVType(EVType[] evType) {
        this.evType = evType;
    }

    public int[] getEVYield() {
        return evYield;
    }
    public void setEVYield(int[] evYield) {
        this.evYield = evYield;
    }

    public int getAccuracy(){
        return battleAccuracy;
    }
    public void setAccuracy(int battleAccuracy){
        this.battleAccuracy = battleAccuracy;
    }

    public Move[] getMoves() {
        return moves;
        //access indices of moves for battle system
    }

    public ArrayList<Move> getMovesLearned() {
        return movesLearned;
    }

    public double[] getStageMultipliers() {
        return stageMultipliers;
    }

    public double[] getAccuracyMultipliers() {
        return accuracyMultipliers;
    }

    public int getAttackModifier() {
        return attackModifier;
    }

    public void setAttackModifier(int attackModifier) {
        this.attackModifier = attackModifier;
    }

    public int getDefenseMultiplier() {
        return defenseMultiplier;
    }

    public void setDefenseMultiplier(int defenseMultiplier) {
        this.defenseMultiplier = defenseMultiplier;
    }

    public int getSpAttackMultiplier() {
        return spAttackMultiplier;
    }

    public void setSpAttackMultiplier(int spAttackMultiplier) {
        this.spAttackMultiplier = spAttackMultiplier;
    }

    public int getSpDefMultiplier() {
        return spDefMultiplier;
    }

    public void setSpDefMultiplier(int spDefMultiplier) {
        this.spDefMultiplier = spDefMultiplier;
    }

    public int getSpeedMultiplier() {
        return speedMultiplier;
    }

    public void setSpeedMultiplier(int speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
    }

    public int getAccuracyMultiplier() {
        return accuracyMultiplier;
    }
    public void setAccuracyMultiplier(int accuracyMultiplier) {
        this.accuracyMultiplier = accuracyMultiplier;
    }

    public int getBattleAttack() {
        return battleAttack;
    }

    public void setBattleAttack(int battleAttack) {
        this.battleAttack = battleAttack;
    }

    public int getBattleDefense() {
        return battleDefense;
    }

    public void setBattleDefense(int battleDefense) {
        this.battleDefense = battleDefense;
    }

    public int getBattleSpAttack() {
        return battleSpAttack;
    }

    public void setBattleSpAttack(int battleSpAttack) {
        this.battleSpAttack = battleSpAttack;
    }

    public int getBattleSpDef() {
        return battleSpDef;
    }

    public void setBattleSpDef(int battleSpDef) {
        this.battleSpDef = battleSpDef;
    }

    public int getBattleSpeed() {
        return battleSpeed;
    }

    public void setBattleSpeed(int battleSpeed) {
        this.battleSpeed = battleSpeed;
    }
    public int getBattleAccuracy() {
        return battleAccuracy;
    }

    public void setBattleAccuracy(int battleAccuracy) {
        this.battleAccuracy = battleAccuracy;
    }
}
