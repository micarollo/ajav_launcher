package aircrafts;

import src.WeatherTower;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower tower;
    public JetPlane (long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions () {
        String weather = tower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                if ((coordinates.getHeight() + 2) > 100)
                    coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), 100);
                else
                    coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                System.out.println("The sun is so bright, I might just roast my wings!");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                System.out.println("Is this the sky or just a big cotton candy factory? Hard to tell in all this fog!");
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                System.out.println("Rain, rain, go away! I need clear skies for my turbocharged fun!");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                System.out.println("The snow's coming down, but I'm still flying high, looking like a snowplow in the sky!");
                break;
        }
        if(coordinates.getHeight() <= 0) {
            System.out.println("JetPlane " + name + ": landing... See on the ground!");
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