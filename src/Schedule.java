import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ImmortalWolf on 10.02.2015.
 */
public class Schedule {
    public static void main(String[] args)
    {
        ArrayList<User> users = new ArrayList<User>();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        while (!s.equals("StartScheduling"))
        {
            int ind = s.indexOf('(');
            if (ind > 0) {
                String command = s.substring(0, ind);
                System.out.println(s);
                System.out.println(command);
                String name, timezone, status, text, datetime;
                boolean stat;
                switch (command) {
                    case "Create":
                        s = s.substring(ind + 1);
                        ind = s.indexOf(',');
                        name = s.substring(0, ind);
                        s = s.substring(ind + 2);
                        ind = s.indexOf(',');
                        timezone = s.substring(0, ind);
                        s = s.substring(ind + 2);
                        ind = s.indexOf(')');
                        status = s.substring(0, ind);
                        if (status.equals("active"))
                            stat = true;
                        else
                            stat = false;
                        users.add(new User(name, TimeZone.getTimeZone(timezone), stat));
                        //users.add(new User("name", TimeZone.getTimeZone("Europe/Moscow"), true));
                        break;

                    case "Modify":
                        s = s.substring(ind + 1);
                        ind = s.indexOf(',');
                        name = s.substring(0, ind);
                        s = s.substring(ind + 2);
                        ind = s.indexOf(',');
                        timezone = s.substring(0, ind);
                        s = s.substring(ind + 2);
                        ind = s.indexOf(')');
                        status = s.substring(0, ind);
                        if (status.equals("active"))
                            stat = true;
                        else
                            stat = false;
                        for (int i = 0; i < users.size(); i++)
                            if (name.equals(users.get(i).getName())) {
                                users.get(i).setTimeAndStat(TimeZone.getTimeZone(timezone), stat);
                                break;
                            }
                        break;

                    case "AddEvent":
                        s = s.substring(ind + 1);
                        ind = s.indexOf(',');
                        name = s.substring(0, ind);
                        s = s.substring(ind + 2);
                        ind = s.indexOf(',');
                        text = s.substring(0, ind);
                        s = s.substring(ind + 2);
                        ind = s.indexOf(')');
                        datetime = s.substring(0, ind);

                        try {
                            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss");
                            Date date = formatter.parse(datetime);
                            for (int i = 0; i < users.size(); i++)
                                if (name.equals(users.get(i).getName())) {
                                    users.get(i).AddEvent(text, date);
                                    break;
                                }
                        } catch (ParseException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case "ShowInfo":
                        s = s.substring(ind + 1);
                        name = s.substring(0, s.length() - 1);
                        for (int i = 0; i < users.size(); i++)
                            if (name.equals(users.get(i).getName())) {
                                users.get(i).ShowUser();
                                break;
                            }
                        break;
                }
            }
            else
            {
                System.out.println("Error");
            }
            s = in.nextLine();
        }
    }
}
