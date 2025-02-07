package aircrafts;

import src.WeatherTower;

public class Baloon extends Aircraft {
    public Baloon (String type, String name, int lo, int la, int he) {
        super(type, name, lo, la, he);
        weatherMsg.put("SUN", "Baloon sun");
        weatherMsg.put("FOG", "Baloon fog");
        weatherMsg.put("RAIN", "Baloon rain");
        weatherMsg.put("SNOW", "Baloon snow");
    }

    @Override
    public void reactToWeather(String weather, WeatherTower tower) {
        if (!tower.isRegistered(this))
            return;
        switch (weather) {
            case "SUN" -> this.updateCoord(0, 2, 4, tower);
            case "RAIN" -> this.updateCoord(0, -5, 0, tower);
            case "FOG" -> this.updateCoord(0, -3, 0, tower);
            case "SNOW" -> this.updateCoord(0, 0, -15, tower);
        }
    }
}