package Items.Pokeballs;

import Items.Item;
import Items.ItemType;
import Menu.UI;
import Pokemon.Pokemon;

import java.util.Random;

public abstract class Pokeball extends Item {
    private final double ballModifier;
    public Pokeball(String name, double ballModifier) {
        super(name, ItemType.POKEBALL);
        this.ballModifier= ballModifier;
        setItemCategory(0);
        setBattleFunction(false);
    }
    public double getCatchRate(){
        return ballModifier;
    }
    @Override
    public void useOn(Pokemon pokemon) throws InterruptedException {
        try{
            //in battle, I need to make a check method for if party/boxes are full
            //can be done with an if statement
            // if(UI.getTotalPokemon() > UI.pcBox.size() * 30 + 6)
            Random random = new Random();
            double hpFactor = (double) (3 * pokemon.getHp() - 2 * pokemon.getCurrentHP()) /(3 * pokemon.getHp());
            double catchRate = (pokemon.getBaseCatchRate() * getCatchRate() * hpFactor) * pokemon.getStatusEffect().statusModifier();
            //implement shake checks
            boolean shakeCheck = true;
            int shakeCounter = 0;
            int generatedValue;
            //shakeChecks
            while(shakeCheck){
                if(shakeCounter == 4){
                    System.out.println("Gotcha! " + pokemon.getName() + " was caught!");
                    String statement = UI.addToTeam(pokemon);
                    if(statement.contains("party")){
                        UI.pokemonNickname(UI.party);
                    }else{
                        String boxNumberString = statement.substring(statement.length()-1);
                        int boxNumber = Integer.parseInt(boxNumberString);
                        UI.pokemonNickname(UI.pcBox.get(boxNumber-1));
                        //may be bad coding, as there is a better way to do it,
                        //but parse the String of the boxNumber variable in "addToTeam" in UI
                        //to get the pc box number
                    }
                    System.out.println(statement);
                    shakeCheck = false;
                    UI.setTotalPokemon(1);
                }
                double captureValue = (65536/Math.sqrt(Math.sqrt(255/catchRate)));
                generatedValue = random.nextInt(65536);
                if(captureValue > generatedValue && shakeCheck){
                    shakeCounter++;
                    System.out.println(shakeCounter + "shake...");
                    Thread.sleep(1500);
                    discardInput();
                }else{
                    switch(shakeCounter){
                        case 0:
                            System.out.println("Oh no! The Pokemon broke free!");
                            shakeCheck = false;
                            Thread.sleep(1500);
                            discardInput();
                            break;
                        case 1:
                            System.out.println("Aww! It appeared to be caught!");
                            shakeCheck = false;
                            Thread.sleep(1500);
                            discardInput();
                            break;
                        case 2:
                            System.out.println("Argh! Almost had it!");
                            shakeCheck = false;
                            Thread.sleep(1500);
                            discardInput();
                            break;
                        case 3:
                            System.out.println("Gah! It was so close, too!");
                            shakeCheck = false;
                            Thread.sleep(1500);
                            discardInput();
                            break;
                    } //end switch
                } //end else
            } //end while loop
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    } //end method
}
