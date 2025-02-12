package aircrafts;

import aircraft.Flyable;
import src.WeatherTower;

public class JetPlane extends Aircraft implements Flyable{
    public JetPlane (long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions () {

    }
    // public JetPlane(String type, String name, int longitude, int latitude, int height) {
    //     super(type, name, longitude, latitude, height);
    //     weatherMsg.put("SUN", "The sun is so bright, I might just roast my wings!");
    //     weatherMsg.put("FOG", "Is this the sky or just a big cotton candy factory? Hard to tell in all this fog!");
    //     weatherMsg.put("RAIN", "Rain, rain, go away! I need clear skies for my turbocharged fun!");
    //     weatherMsg.put("SNOW", "The snow's coming down, but I'm still flying high, looking like a snowplow in the sky!");
    // }

    // @Override
    // public void reactToWeather(String weather, WeatherTower tower) {
    //     if (!tower.isRegistered(this))
    //         return;
    //     switch (weather) {
    //         case "SUN" -> this.updateCoord(0, 10, 2, tower);
    //         case "RAIN" -> this.updateCoord(0, 5, 0, tower);
    //         case "FOG" -> this.updateCoord(0, 1, 0, tower);
    //         case "SNOW" ->this.updateCoord(0, 0, -7, tower);
    //     }
    // }
}