package aircrafts;

import src.WeatherTower;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower tower;
    private String type = "Baloon";

    public Baloon (long p_id, String p_name, Coordinates coordinates) {
        super(p_id, p_name, coordinates);
    }

   @Override
    public void updateConditions () {
        String weather = tower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                if ((coordinates.getHeight() + 4) > 100)
                    coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), 100);
                else
                    coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                System.out.println(type + "#" + name + "(" + id + "): I'm floating with joy! Sun is my best friend, let's get some tan!");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                System.out.println(type + "#" + name + "(" + id + "): I can't see a thing, but I’m still floating like a ghost in the mist!");
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                System.out.println(type + "#" + name + "(" + id + "): The rain is falling, but I'm still floating high. Guess I'm just too cool to get wet!");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                System.out.println(type + "#" + name + "(" + id + "): I'm not just floating, I'm gliding through the snow! If only I had a scarf...");
                break;
        }
        if(coordinates.getHeight() <= 0) {
            System.out.println("Baloon " + name + ": landing... See on the ground!");
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