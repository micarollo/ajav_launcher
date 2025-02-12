package aircraft;

public class AircraftFactory {
    private static long count = 0;
    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        switch (p_type.toLowerCase()) {
            case "jetplane":
                return (new JetPlane(++count, p_name, p_coordinates));
            case "helicopter" :
                return (new Helicopter(++count, p_name, p_coordinates));
            case "baloon":
                return (new Baloon(++count, p_name, p_coordinates));
        }
        // if (p_type.toLowerCase().equals("jetplane")) {
        //     return (new JetPlane(++count, p_name, p_coordinates));
        // }
        // else if (p_type.toLowerCase().equals("helicopter")) {
        //     return (new Helicopter(++count, p_name, p_coordinates));
        // }
        // else if (p_type.toLowerCase().equals("baloon")) {
        //     return (new Baloon(++count, p_name, p_coordinates));
        // }
    }
}