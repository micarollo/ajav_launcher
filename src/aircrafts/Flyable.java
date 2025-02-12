package aircrafts;

import src.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower p_tower);
}