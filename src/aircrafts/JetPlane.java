package ajav_launcher.aircrafts;

public class JetPlane extends Aircraft {
    public JetPlane(String type, String name, int longitude, int latitude, int height) {
        super(type, name, longitude, latitude, height);
    }

    @Override
    public void reactToWeather(String weather) {
        switch (weather) {
            case "SUN":
                this.la += 10;
                this.he += 2;
                break;
            case "RAIN":
                this.la += 5;
                break;
            case "FOG":
                this.la += 1;
                break;
            case "SNOW":
                this.he -= 7;
                break;
        }
    }
}