package ajav_launcher.aircrafts;

public class Helicopter extends Aircraft {
    public Helicopter (String type, String name, int lo, int la, int he) {
        super(type, name, lo, la, he);
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
                this.he -= 12;
                break;
        }
    }
}