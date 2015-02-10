import java.util.TimeZone;

/**
 * Created by ImmortalWolf on 10.02.2015.
 */
public class User {
    private String name;
    private TimeZone timezone;
    private boolean status;
    private Event event;
    public User() {}
    public User (String n, TimeZone t, boolean s)
    {
        name = n;
        timezone = t;
        status = s;
    }
}
