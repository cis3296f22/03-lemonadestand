package UserInterface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Tests {
    LemonadeStandModel ls;
    
    @Test
    public void testSellCup(){
        ls = new LemonadeStandModel();
        ls.setInventory(10, 10, 10, 10);
        ls.setRecipe(2, 2, 2, 2);

        ls.setPricePer(0.75);
        ls.setMoney(0);

        ls.sellCup();

        assertEquals(0.75, ls.getMoney(), 0);
    }

    @Test
    public void testInventoryAfterSellCup(){
        ls = new LemonadeStandModel();
        ls.setInventory(10, 10, 10, 10);
        ls.setRecipe(2, 2, 2, 2);

        ls.setPricePer(0.75);
        ls.setMoney(0);

        ls.sellCup();

        assertEquals(8, ls.getLemons(), 0);
        assertEquals(8, ls.getIce(), 0);
        assertEquals(8, ls.getSugar(), 0);
        assertEquals(9, ls.getCups(), 0);
    }

    @Test
    public void testFloatingPointRound(){
        ls = new LemonadeStandModel();
        ls.setInventory(10, 10, 10, 10);
        ls.setRecipe(2, 2, 2, 2);

        ls.setPricePer(0.75);
        ls.setMoney(0);

        ls.sellCup();
        ls.sellCup();

        ls.setPricePer(0.33);

        ls.sellCup();

        String money = Double.toString(ls.getMoney());

        assertEquals(4, money.length(), 0);
    }

    @Test
    public void testCanSubtractLemons(){
        ls = new LemonadeStandModel();
        ls.setInventory(10, 10, 10, 10);

        assertTrue(ls.canSubtractLemons());
    }

    @Test
    public void testCanSubtractAll(){
        ls = new LemonadeStandModel();
        ls.setInventory(10, 10, 10, 10);

        assertTrue(ls.canSubtractLemons());
        assertTrue(ls.canSubtractCups());
        assertTrue(ls.canSubtractIce());
        assertTrue(ls.canSubtractSugar());
    }

    @Test
    public void cannotSubtract(){
        ls = new LemonadeStandModel();

        assertFalse(ls.canSubtractCups());
        assertFalse(ls.canSubtractLemons());
        assertFalse(ls.canSubtractIce());
        assertFalse(ls.canSubtractSugar());
    }

    @Test
    public void canGetDayAndMoney(){
        ls = new LemonadeStandModel();

        assertEquals(ls.getCurrentDay(), 1, 0);
        assertEquals(ls.getTotalDay(), 7, 0);
        assertEquals(ls.getMoney(), 20.0, 0);
    }

    @Test
    public void acceptPurcahseIncreasesMoney(){
        ls = new LemonadeStandModel();
        ls.setPricePer(2.0);
        ls.setRecipe(2,2,2,2);
        ls.setInventory(10,10,10,10);
        
        ls.sellCup();

        assertEquals(22.0, ls.getMoney(), 0);
    }

}
