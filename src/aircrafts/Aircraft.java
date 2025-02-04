package ajav_launcher.aircrafts;

public abstract class Aircraft {
    protected String type;
    protected String name;
    protected int lo;
    protected int la;
    protected int he;
    private final int id; //once asigned cant change
    private static int counter = 0;

    public Aircraft (String type, String name, int longitude, int latitude, int height) {
        this.type = type;
        this.name = name;
        this.lo = longitude;
        this.la = latitude;
        this.he = height;
        this.id = ++counter;
    }

    public abstract void reactToWeather(String weather); //abstract to manage this function inside the class extend class : JetPlane, Ballon, Helicopter
}
