package src;

public class WeatherProvider {
    private final String[] weather = {"SUN", "FOG", "RAIN", "SNOW"};
    private static final WeatherProvider weatherProvider = new WeatherProvider();

    private WeatherProvider() {};

    public static WeatherProvider getWeatherProvider() {
        return weatherProvider;
    }
    
    public String getCurrentWeather(Coordinates p_coordinates) {
        int i = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight();
        return weather[i % 4];
    }
}
