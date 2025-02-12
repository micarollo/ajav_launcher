package aircrafts;

public abstract class Aircraft {
    protected long id;
    protected String name;
    Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }
}
