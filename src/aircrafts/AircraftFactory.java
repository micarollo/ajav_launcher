package aircrafts;

public class AircraftFactory {
    private static AircraftFactory instance = new AircraftFactory();
    private static long count = 0;

    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        return instance;
    }
    
    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        switch (p_type.toLowerCase()) {
            case "jetplane":
                return (new JetPlane(++count, p_name, p_coordinates));
            case "helicopter" :
                return (new Helicopter(++count, p_name, p_coordinates));
            case "baloon":
                return (new Baloon(++count, p_name, p_coordinates));
        }
        return null;
    }
}