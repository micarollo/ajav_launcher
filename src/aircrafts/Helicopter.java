package aircrafts;

import aircraft.Flyable;
import src.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower tower;
    public Helicopter (long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions () {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.tower = weatherTower;
        
    }
    // public Helicopter (String type, String name, int lo, int la, int he) {
    //     super(type, name, lo, la, he);
    //     weatherMsg.put("SUN", "Sun's out, rotors out! Time to soar like a happy bird!");
    //     weatherMsg.put("FOG", "My rotors are slicing through the fog, but my GPS is on vacation today!");
    //     weatherMsg.put("RAIN", "Rain is just a reason to spin faster! Who needs an umbrella when you have blades?");
    //     weatherMsg.put("SNOW", "Snowstorm? More like a winter wonderland in the air! But someone get me a hot cocoa!");
    // }

    // @Override
    // public void reactToWeather(String weather, WeatherTower tower) {
    //     if (!tower.isRegistered(this))
    //         return;
    //     switch (weather) {
    //         case "SUN" -> this.updateCoord(0, 10, 2, tower);
    //         case "RAIN" -> this.updateCoord(0, 5, 0, tower);
    //         case "FOG" -> this.updateCoord(1, 0, 0, tower);
    //         case "SNOW" -> this.updateCoord(0, 0, -12, tower);
    //     }
    // }
}