package ajav_launcher.aircrafts;

public class Baloon extends Aircraft {
    public Baloon (String type, String name, int lo, int la, int he) {
        super(type, name, lo, la, he);
    }

    @Override
    public void reactToWeather(String weather) {
        switch (weather) {
            case "SUN":
                this.la += 2;
                this.he += 4;
                break;
            case "RAIN":
                this.la -= 5;
                break;
            case "FOG":
                this.la -= 3;
                break;
            case "SNOW":
                this.he -= 15;
                break;
        }
    }
}