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
    public void sellCup(){

    }

}