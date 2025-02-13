package src;

import aircrafts.Coordinates;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getWeatherProvider().getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        conditionChanged();
    }

    // public static final String RESET = "\033[0m";  // Resetea el color
    // public static final String RED = "\033[0;31m"; // Rojo
    // public static final String GREEN = "\033[0;32m";

    // private List<Aircraft> registeredAircrafts = new ArrayList<>();
    
    // public void register(List<Aircraft> aircrafts_li) {
    //     for (Aircraft aircraft : aircrafts_li) {
    //         registeredAircrafts.add(aircraft);
    //         System.out.println(GREEN + aircraft.getName() + " registered to WeatherTower" + RESET);
    //     }
    // }
    
    // public void unregister(Aircraft aircraft) {
    //     if (registeredAircrafts.remove(aircraft))
    //         System.out.println(RED + "Aircraft " + aircraft.getType() + " " + aircraft.getName() + " landed. Unregistered from the Weather Tower" + RESET);
    //     else
    //         System.out.println("Aircraft not registered in the Weather Tower");
    // }

    // public boolean isRegistered(Aircraft aircraft) {
    //     return registeredAircrafts.contains(aircraft);
    // }

    // public String changeWeather() {
    //     Random rand = new Random();
    //     int randomNum = rand.nextInt(4);
    //     String weather = "";
        
    //     switch (randomNum) {
    //         case 0 -> weather = "SUN";
    //         case 1 -> weather = "RAIN";
    //         case 2 -> weather = "FOG";
    //         case 3 -> weather = "SNOW";
    //     }
    //     return weather;
    // }

}