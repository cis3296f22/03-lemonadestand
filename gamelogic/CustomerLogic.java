import java.util.Random;
public class CustomerLogic {
    Random random = new Random();

    WeatherForecast obj = new WeatherForecast();
    int customers2 = obj.customers;

    //Customer Logic for amount
    if(pricePerCup >2){
        customers2 = customers2 - (customers2 * 10 / 100);//reduce customers by 10%
    }
    else if(pricePerCup< 0.50){
        customers2 = customers2 + (customers2 * 10 / 100);//Increase Customers by 10%
    }
    if(lemonsPerCup >4||lemonsPerCup< 2){
        customers2 = customers2 - (customers2 * 10 / 100);
    }
    if(sugarPerCup >4||sugarPerCup< 2){
        customers2 = customers2 - (customers2 * 10 / 100);
    }
    if(icePerCup >3||icePerCup< 1){
        customers2 = customers2 - (customers2 * 10 / 100);
    }

}
