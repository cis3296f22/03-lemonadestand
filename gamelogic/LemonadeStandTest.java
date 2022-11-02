public class LemonadeStandTest {
    public static void main(String[] args){
        LemonadeStand L = new LemonadeStand();
        L.setInventory(100, 200, 200, 100);
        L.setRecipe(1, 4, 0.75, 3);
        L.sellCup();
        update(L);
        printInventory(L);
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
}
