import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by ImmortalWolf on 10.02.2015.
 */
public class User {
    private String name;
    private TimeZone timezone;
    private boolean status;
    private ArrayList<Event> event;
    public User() {}
    public User (String n, TimeZone t, boolean s)
    {
        name = n;
        timezone = t;
        status = s;
        event = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }
    public void setTimeAndStat(TimeZone t, boolean s)
    {
        timezone = t;
        status = s;
    }
    public void AddEvent(String t, Date d)
    {
        event.add(new Event(t, d));
    }
    public void ShowUser()
    {
        String buf = "passive";
        if (status)
            buf = "active";
        System.out.println(name + " " + timezone.getID() + " " + buf);
        for (int i = 0; i < event.size(); i++)
            event.get(i).ShowEvent();
    }
}
