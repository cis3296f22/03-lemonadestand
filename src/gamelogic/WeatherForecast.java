package gamelogic;

import java.util.Random;

public class WeatherForecast {

        Random random = new Random();
        int min = 30;
        int max = 100;
        int temperature = (int) (Math.random() * (max - min + 1) + min);
        int rain = (int) (Math.random() * (2 - 1 + 1) + 1);
        int customers;


        public int getTemperature(){
            //System.out.println("WeatherForecast temperature " +temperature);
            if (temperature <= 30) {
                if (rain == 1) {
                    System.out.println("It's snowing");
                    customers = 10 - random.nextInt(10);
                } else {
                    System.out.println("clear weather");
                    customers = 20 - random.nextInt(10);
                }
                return customers;
            } else if ((30 < temperature) || (temperature < 60)) {
                if (rain == 1) {
                    System.out.println("It's raining");
                    customers = 30 - random.nextInt(10);
                } else {
                    System.out.println("clear weather");
                    customers = 40 - random.nextInt(10);
                }
                return customers;
            } else {
                if (rain == 1) {
                    System.out.println("It's raining");
                    customers = 50 - random.nextInt(10);
                } else {
                    System.out.println("clear weather");
                    customers = 60 + random.nextInt(20);
                }
                return customers;
            }
        }
    }