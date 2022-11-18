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

    // constructor
    public LemonadeStandModel(){
        ice = 0.0;
        lemons = 0.0;
        cups = 0.0;
        money = 0.0;

        cupsPer = 0.0;
        sugarPer = 0.0;
        lemonsPer = 0.0;
        icePer = 0.0;
        pricePer = 0.0;
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

    public void setSugarPer(double i){
        sugarPer = i;
    }

    public void setPricePer(double i){
        pricePer = i;
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
        this.sugar -= sugarPer;
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

    public int[] CustomerLogic(){
        WeatherForecast obj = new WeatherForecast();
        //int customers[0] = obj.getTemperature();
        int[] customers = new int[5];
        customers[0] = obj.getTemperature();

        int temperature = obj.temperature;


        System.out.println("LemonadeStand Temperature " + temperature);
        System.out.println("Customers2 unmodified "+ customers[0]);//Test for modifying

        if (pricePer > 2) {
            customers[0] = customers[0] - (customers[0] * 10 / 100);//reduce customers by 10%
            customers[1] = customers[1] + (customers[0] * 10 / 100);
        }
        else if (pricePer < 0.50) {
            customers[0] = customers[0] + (customers[0] * 10 / 100);//Increase Customers by 10%

        }
        if (lemonsPer > 3 || lemonsPer < 2) {
            customers[0] = customers[0] - (customers[0] * 10 / 100);
            customers[2] = customers[1] + (customers[0] * 10 / 100);
        }
        if (sugarPer > 4 || sugarPer < 2) {
            customers[0] = customers[0] - (customers[0] * 10 / 100);
            customers[3] = customers[1] + (customers[0] * 10 / 100);
        }
        if(temperature > 80)
            if (icePer > 3) {
                customers[0] = customers[0] + (customers[0] * 10 / 100);
            }
            else if(icePer == 0){
                customers[0] = customers[0] - (customers[0] * 10 / 100);
                customers[4] = customers[1] + (customers[0] * 10 / 100);
            }
            else if(temperature <= 80)
                if (icePer == 0){
                    customers[0] = customers[0] - (customers[0] * 10 / 100);
                    customers[4] = customers[1] + (customers[0] * 10 / 100);
                }
        return customers;
    }
}