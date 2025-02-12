package aircrafts;

import aircraft.Flyable;
import src.WeatherTower;

public class Baloon extends Aircraft implements Flyable{
     public Baloon (long p_id, String p_name, Coordinates coordinates) {
        super(p_id, p_name, coordinates);
    }

    @Overrid
    public void updateConditions () {

    }
    // public Baloon (String type, String name, int lo, int la, int he) {
    //     super(type, name, lo, la, he);
    //     weatherMsg.put("SUN", "I'm floating with joy! Sun is my best friend, let's get some tan!");
    //     weatherMsg.put("FOG", "I can't see a thing, but I’m still floating like a ghost in the mist!");
    //     weatherMsg.put("RAIN", "The rain is falling, but I'm still floating high. Guess I'm just too cool to get wet!");
    //     weatherMsg.put("SNOW", "I'm not just floating, I'm gliding through the snow! If only I had a scarf...");
    // }

    // @Override
    // public void reactToWeather(String weather, WeatherTower tower) {
    //     if (!tower.isRegistered(this))
    //         return;
    //     switch (weather) {
    //         case "SUN" -> this.updateCoord(0, 2, 4, tower);
    //         case "RAIN" -> this.updateCoord(0, -5, 0, tower);
    //         case "FOG" -> this.updateCoord(0, -3, 0, tower);
    //         case "SNOW" -> this.updateCoord(0, 0, -15, tower);
    //     }
    // }
}