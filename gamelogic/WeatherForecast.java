import java.util.Random;

public class WeatherForecast {
     Random random = new Random();
     int min = 30;
     int max = 100;
     int temperature = (int)(Math.random()*(max-min+1)+min);
     int rain = (int)(Math.random()*(2-1+1)+1);

     public int getWeather(int rain)
    {
        if (rain > 1) {
            System.out.println("It's raining");
        } else {
            System.out.println("It's not raining");
        }
        return rain;
    }
    public int getTemperature(int temperature){
         if(temperature >= 30){
             if (rain == 1) {
                 System.out.println("It's snowing");
             } else {
                 System.out.println("clear weather");
             }
             return rain;
         }
         else if((30 > temperature) || (temperature < 60)){
             if (rain == 1) {
                 System.out.println("It's raining");
             } else {
                 System.out.println("clear weather");
             }
             return rain;
         }
         else{
             if (rain == 1) {
                 System.out.println("It's raining");
             } else {
                 System.out.println("clear weather");
             }
             return rain;
         }
    }
}
