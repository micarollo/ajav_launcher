package ajav_launcher;

import java.util.Random;

public class WeatherTower {
    public void changeWeather() {
        Random rand = new Random();
        int randomNum = rand.nextInt(4);
        System.out.println(randomNum);
        String weather = "";
        
        switch (randomNum) {
            case 0:
                weather = "SUN";
                break;
            case 1:
                weather = "RAIN";
                break;
            case 2:
                weather = "FOG";
                break;
            case 3:
                weather = "SNOW";
                break;
        }
        System.out.println(weather);
    }
}