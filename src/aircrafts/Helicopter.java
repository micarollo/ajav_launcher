package aircrafts;

import src.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower tower;
    public Helicopter (long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = tower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                if ((coordinates.getHeight() + 2) > 100)
                    coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), 100);
                else
                    coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                System.out.println("Sun's out, rotors out! Time to soar like a happy bird!");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                System.out.println("My rotors are slicing through the fog, but my GPS is on vacation today!");
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                System.out.println("Rain is just a reason to spin faster! Who needs an umbrella when you have blades?");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                System.out.println("Snowstorm? More like a winter wonderland in the air! But someone get me a hot cocoa!");
                break;
        }
        if(coordinates.getHeight() <= 0) {
            System.out.println("Helicopter " + name + ": landing... See on the ground!");
            tower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.tower = weatherTower;
        tower.register(this);
        System.out.println("New Aircraft " + this.name + " registered to the weather tower.");
    }
}