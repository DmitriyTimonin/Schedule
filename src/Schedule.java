import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

/**
 * Created by ImmortalWolf on 10.02.2015.
 */
public class Schedule {
    public static void main(String[] args)
    {
        ArrayList<User> users = new ArrayList<User>();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int ind = s.indexOf('(');
        if (ind > 0) {
            String command = s.substring(0, ind);
            System.out.println(s);
            System.out.println(command);
            switch (command)
            {
                case "Create":
                    s = s.substring(ind + 1);
                    ind = s.indexOf(',');
                    String name = s.substring(0, ind - 1);
                    s = s.substring(ind + 2);
                    ind = s.indexOf(',');
                    String timezone = s.substring(0, ind - 1);
                    s = s.substring(ind + 2);
                    ind = s.indexOf(')');
                    String status = s.substring(0, ind - 1);
                    boolean stat;
                    if (status.equals("active"))
                        stat = true;
                    else
                        stat = false;
                    users.add(new User(name, TimeZone.getTimeZone(timezone), stat));
                 //users.add(new User("name", TimeZone.getTimeZone("Europe/Moscow"), true));
                    break;
                case "Modify": break;
                case "AddEvent": break;
            }
        }
        else if (s.equals("StartScheduling"))
        {
            System.out.println("Режим показа событий");
        }
        else
        {
            System.out.println("Error");
        }
    }
}
