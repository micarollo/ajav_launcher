package aircrafts;

import src.WeatherTower;

public class JetPlane extends Aircraft {
    public JetPlane(String type, String name, int longitude, int latitude, int height) {
        super(type, name, longitude, latitude, height);
        weatherMsg.put("SUN", "JetPlane sun");
        weatherMsg.put("FOG", "JetPlane fog");
        weatherMsg.put("RAIN", "JetPlane rain");
        weatherMsg.put("SNOW", "JetPlane snow");
    }

    @Override
    public void reactToWeather(String weather, WeatherTower tower) {
        if (!tower.isRegistered(this))
            return;
        switch (weather) {
            case "SUN" -> this.updateCoord(0, 10, 2, tower);
            case "RAIN" -> this.updateCoord(0, 5, 0, tower);
            case "FOG" -> this.updateCoord(0, 1, 0, tower);
            case "SNOW" ->this.updateCoord(0, 0, -7, tower);
        }
    }
}