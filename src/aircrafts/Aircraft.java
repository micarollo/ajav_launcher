package aircrafts;

import java.util.HashMap;
import java.util.Map;
import src.WeatherTower;

public abstract class Aircraft {
    protected String type;
    protected String name;
    protected int lo;
    protected int la;
    protected int he;
    private final int id; //once asigned cant change
    private static int counter = 0;
    protected Map<String, String> weatherMsg;

    public Aircraft (String type, String name, int longitude, int latitude, int height) {
        this.type = type;
        this.name = name;
        this.lo = longitude;
        this.la = latitude;
        this.he = height;
        this.id = ++counter;
        this.weatherMsg = new HashMap<>();
    }

    public String getWeatherMsg(String weather) {
        String RESET = "\033[0m";
        String VIOLET = "\033[35m";
        String BLUE = "\033[0;34m";
        String YELLOW = "\033[0;33m";
        // String msg = weatherMsg.get(weather);
        // if (weather.equals("SUN"))
        //     return (YELLOW + this.type + "#" + this.name + "(" + this.id + "): " + msg + RESET);
        // else if (weather.equals("RAIN"))
        //     return (BLUE + this.type + "#" + this.name + "(" + this.id + "): " + msg + RESET);
        // else if (weather.equals("FOG"))
        //     return (VIOLET + this.type + "#" + this.name + "(" + this.id + "): " + msg + RESET);
        // else
        //     return (this.type + "#" + this.name + "(" + this.id + "): " + msg);
        String msg = "";
        switch (weather) {
            case "SUN" -> msg = YELLOW + this.type + "#" + this.name + "(" + this.id + "): " + weatherMsg.get(weather) + RESET;
            case "RAIN" -> msg = BLUE + this.type + "#" + this.name + "(" + this.id + "): " + weatherMsg.get(weather) + RESET;
            case "FOG" -> msg = VIOLET + this.type + "#" + this.name + "(" + this.id + "): " + weatherMsg.get(weather) + RESET;
            case "SNOW" -> msg = this.type + "#" + this.name + "(" + this.id + "): " + weatherMsg.get(weather);
        }
        return msg;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getLongitude() {
        return this.lo;
    }

    public int getLatitude() {
        return this.la;
    }

    public int getHeight() {
        return this.he;
    }

    public abstract void reactToWeather(String weather, WeatherTower tower); //abstract to manage this function inside the class extend class : JetPlane, Ballon, Helicopter
    
    public void updateCoord(int longitude, int latitude, int height, WeatherTower tower) {
        this.lo += longitude;
        this.la += latitude;
        this.he += height;
        if (this.he > 100) {
            this.he = 100;
        }
        else if (this.he <= 0) {
            this.he = 0;
            tower.unregister(this);
        }
        // System.out.println("LO: " + getLongitude() + " | LA: " + getLatitude() + " | HE: " + getHeight());
    }
}
