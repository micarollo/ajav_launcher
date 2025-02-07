package aircrafts;

import src.WeatherTower;

public class Helicopter extends Aircraft {
    public Helicopter (String type, String name, int lo, int la, int he) {
        super(type, name, lo, la, he);
        weatherMsg.put("SUN", "Helicopter sun");
        weatherMsg.put("FOG", "Helicopter fog");
        weatherMsg.put("RAIN", "Helicopter rain");
        weatherMsg.put("SNOW", "Helicopter snow");
    }

    @Override
    public void reactToWeather(String weather, WeatherTower tower) {
        if (!tower.isRegistered(this))
            return;
        switch (weather) {
            case "SUN" -> this.updateCoord(0, 10, 2, tower);
            case "RAIN" -> this.updateCoord(0, 5, 0, tower);
            case "FOG" -> this.updateCoord(1, 0, 0, tower);
            case "SNOW" -> this.updateCoord(0, 0, -12, tower);
        }
    }
}