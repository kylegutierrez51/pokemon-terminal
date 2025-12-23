package Moves;


//Outdated classification of moves that has no business being in this program.
//Every Move has to be its own script to work.
public class Moves {
    private int basePower;
    private String type;
    private int accuracy;
    private String attackType;

    public Moves(){

    }
    public int ember(){
        attackType = "Special";
        type = "fire";
        basePower = 40;
        return basePower;
    }
    public int waterGun(){
        attackType = "Special";
        type = "water";
        basePower = 40;
        return basePower;
    }
    public int vineWhip(){
        attackType = "Physical";
        type = "grass";
        basePower = 45;
        return basePower;
    }
    public int thunderShock(){
        attackType = "Special";
        type = "electric";
        basePower = 40;
        return basePower;
    }

}
