package aircrafts;

import src.WeatherTower;

public interface Flyable {
    void registerTower(WeatherTower p_tower);
    void updateConditions();
}