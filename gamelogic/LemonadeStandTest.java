//import org.testng.annotations.Test;

public class LemonadeStandTest {
    public static void main(String[] args){
        LemonadeStand L = new LemonadeStand();
        L.setInventory(100, 200, 200, 100);
        L.setRecipe(1, 4, 0.75, 3);
        L.sellCup();
        update(L);
        printInventory(L);

        customers(L);
        WeatherForecast R = new WeatherForecast();
        temperature(R);
    }

    // HELPER FUNCTIONS
    public static void printInventory(LemonadeStand L){
        System.out.println("INVENTORY:");
        System.out.println("Cups: " + L.getCups() + ", Sugar: " + L.getSugar() + ", Lemons: " + L.getLemons() + ", Ice: " + L.getIce());
    }

    public static void update(LemonadeStand L){
        System.out.println("This stand has sold $" + L.getMoney());
    }

    // print inventory
    public static void customers(LemonadeStand L){
        int[] customers = L.CustomerLogic();
        System.out.printf("Amount of Customers2 %d %d %d %d %d \n", customers[0], customers[1], customers[2], customers[3], customers[4]);
        //customers0 amount of customers after reducing or increasing
        //customers1 amount of customers reduced due to price
        //customers2 amount of customers reduced due to lemons
        //customers3 amount of customers reduced due to sugar
        //customers4 amount of customers reduced due to ice
    }

    public static void temperature(WeatherForecast R){
        //System.out.println("Amount of customers " + R.getTemperature());
        System.out.println("Test Temperature" + R.temperature);
    }
}
