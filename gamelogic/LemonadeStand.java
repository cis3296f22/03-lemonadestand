public class LemonadeStand {
    // inventory available
    private double ice;
    private double lemons;
    private double cups;
    private double money;

    // inventory used per cup
    private double cupsPer;
    private double lemonsPer;
    private double icePer;
    private double pricePer;

    // GETTERS
    public double getIce(){
        return ice;
    }

    public double getLemons(){
        return lemons;
    }

    public double getCups(){
        return cups;
    }

    public double getCupsPer(){
        return cupsPer;
    }

    public double getLemonsPer(){
        return lemonsPer;
    }

    public double getMoney(){
        return money;
    }

    public double getIcePer(){
        return icePer;
    }

    public double getPricePer(){
        return pricePer;
    }

    // SETTERS
    public void setIce(double i){
        ice = i;
    }

    public void setLemons(double i){
        lemons = i;
    }

    public void setCups(double i){
        cups = i;
    }

    public void setMoney(double i){
        money = i;
    }

    public void setCupsPer(double i){
        cupsPer = i;
    }

    public void setLemonsPer(double i){
        lemonsPer = i;
    }

    public void setIcePer(double i){
        icePer = i;
    }

    public void setPricePer(double i){
        pricePer = i;
    }

    // ACTIONS

    // set recipe (ice, cups, price)
    public void setRecipe(double l, double i, double p){
        lemonsPer = l;
        icePer = i;
        pricePer = p;
    }

    // add lemons, such as after purchasing more from the store
    public void addLemons(double l){
        lemons += l;
    }

    // add ice, such as after purchasing more from the store
    public void addIce(double i){
        ice += i;
    }

    // add cups, such as after purchasing more from the store
    public void addCups(double c){
        cups += c;
    }

    // subtract lemons based on recipe
    public void subtractLemons(){
        lemons -= lemonsPer;
    }

    // subtract ice based on recipe
    public void subtractIce(){
        ice -= icePer;
    }

    // subtract cups based on recipe (always 1 cup per cup of lemonade)
    public void subtractCups(){
        cups -= 1;
    }


    // sell cup of lemonade based on recipe
    public void sellCup(){
        money += pricePer;
        subtractCups();
        subtractIce();
        subtractLemons();
    }


}