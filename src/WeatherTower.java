package src;

import aircrafts.Aircraft;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherTower {
    private List<Aircraft> registeredAircrafts = new ArrayList<>();
    
    public void register(List<Aircraft> aircrafts_li) {
        for (Aircraft aircraft : aircrafts_li) {
            registeredAircrafts.add(aircraft);
            System.out.println("Registered to WeatherTower: " + aircraft.getName());
        }
    }
    
    public void unregister(Aircraft aircraft) {
        if (registeredAircrafts.remove(aircraft))
            System.out.println("Aircraft: " + aircraft.getType() + " " + aircraft.getName() + " landed. Unregistered from the Weather Tower");
        else
            System.out.println("Aircraft not registered in the Weather Tower");
    }

    public boolean isRegistered(Aircraft aircraft) {
        return registeredAircrafts.contains(aircraft);
    }

    public String changeWeather() {
        Random rand = new Random();
        int randomNum = rand.nextInt(4);
        String weather = "";
        
        switch (randomNum) {
            case 0 -> weather = "SUN";
            case 1 -> weather = "RAIN";
            case 2 -> weather = "FOG";
            case 3 -> weather = "SNOW";
        }
        System.out.println(weather);
        return weather;
    }

}