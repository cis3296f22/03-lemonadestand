package UserInterface;

public class LemonadeStandModel {
    // inventory available
    private double ice;
    private double lemons;
    private double cups;
    private double money;
    private double sugar;

    // inventory used per cup
    private double cupsPer;
    private double sugarPer;
    private double lemonsPer;
    private double icePer;
    private double pricePer;

    //current and total days
    private double currentDay;
    private double totalDay;

    //expenses and liquidated values
    private double expense;
    private double liquidate;

    //counter for progress bar
    private int counter;

    // constructor
    public LemonadeStandModel(){
        ice = 0.0;
        lemons = 0.0;
        cups = 0.0;
        money = 20.0;
        sugar = 0.0;

        sugarPer = 4.0;
        lemonsPer = 4.0;
        icePer = 4.0;
        pricePer = 25;

        currentDay = 1;
        totalDay = 7;

        expense = 0.0;
        liquidate = 0.0;

        counter = 0;
    }

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

    public double getSugar(){
        return sugar;
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

    public double getSugarPer(){
        return sugarPer;
    }

    public double getPricePer(){
        return pricePer;
    }

    public double getCurrentDay(){
        return currentDay;
    }

    public double getTotalDay(){
        return totalDay;
    }

    public double getExpense(){
        return expense;
    }

    public double getLiquidate(){
        return liquidate;
    }

    public double getCounter(){
        return counter;
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

    public void setSugar(double i){
        sugar = i;
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

    public void setSugarPer(double i){
        sugarPer = i;
    }

    public void setPricePer(double i){
        pricePer = i;
    }

    public void setCurrentDay(double i){
        currentDay = i;
    }

    public void setTotalDay(double i){
        totalDay = i;
    }

    public void setExpense(double i){
        expense = i;
    }

    public void setLiquidate(double i){
        liquidate = i;
    }

    public void setCounter(int i){
        counter = i;
    }

    // ACTIONS

    // set recipe (ice, cups, price)
    public void setRecipe(double l, double i, double p, double s){
        lemonsPer = l;
        icePer = i;
        pricePer = p;
        sugarPer = s;
        // can only use one cup per lemonade
        cupsPer = 1;
    }

    // set inventory (ice, cups, price)
    public void setInventory(double l, double i, double s, double c){
        lemons = l;
        ice = i;
        sugar = s;
        cups = c;
    }

    // add lemons, such as after purchasing more from the store
    public void addLemons(double l){
        lemons += l;
    }

    public void addMoney(double m){
        money += m;
    }

    // add ice, such as after purchasing more from the store
    public void addIce(double i){
        ice += i;
    }

    // add cups, such as after purchasing more from the store
    public void addCups(double c){
        cups += c;
    }

    // add cups, such as after purchasing more from the store
    public void addSugar(double c){
        sugar += c;
    }

    // check if we have enough lemons left
    public boolean canSubtractLemons(){
        if(lemons - lemonsPer >= 0) return true;
        return false;
    }

    // check if we have enough ice left
    public boolean canSubtractIce(){
        if(ice - icePer >= 0) return true;
        return false;
    }

    // check if we have enough cups left
    public boolean canSubtractCups(){
        if(cups - cupsPer >= 0) return true;
        return false;
    }

    // check if we have enough sugar left
    public boolean canSubtractSugar(){
        if(sugar - sugarPer >= 0) return true;
        return false;
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
        cups -= cupsPer;
    }

     // subtract sugar based on recipe
     public void subtractSugar(){
        sugar -= sugarPer;
    }

    // accept currency from customer
    public void acceptPurchase(){
        money += pricePer;
    }


    // sell cup of lemonade based on recipe
    public void sellCup(){
        // if we have the inventory
        if(canSellCup()){
            // subtract inventory based on recipe to create lemonade
            subtractCups();
            subtractIce();
            subtractLemons();
            subtractSugar();

            // sell cup
            acceptPurchase();
            System.out.println("Cup sold!");
        }
    }

    // helper to check if possible to sell cup
    public boolean canSellCup(){
        return canSubtractIce() && canSubtractCups() && canSubtractLemons() && canSubtractSugar();
    }


}