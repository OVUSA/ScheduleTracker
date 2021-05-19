import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        System.out.println("Welcome to schedule tracker. Here you can accurately evaluate" +
                " time spend on certain tasks as well as on breaks throughout the workday.");

        System.out.println("Please, enter you name: ");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();

        Tracker tracker = new Tracker();
        User_Interface ui = new User_Interface(tracker);
        ui.init();
        System.out.println("Very well," + userName + "!");



    }
}



