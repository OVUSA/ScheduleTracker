import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    protected String userName;
    Scanner sc = new Scanner(System.in);
    Activity ac;
    WorkState work;
    BreakState resting;

    Manager(String userName){
        this.userName = userName;
    }
    public  String getUserName(){
        return userName;
    }

    ArrayList<Character>actions = new ArrayList<>();


    public void menu(){

    System.out.println("Press 'w'  to start working,\n"
                + "    'b' to start a break \n" +
                      "'s' to stop current action\n"+
                "     'e' to end the session.");
        char input = sc.next().charAt(0);
        actions.add(input);

        switch(input){
            case 'w':work();
                break;
            case 'b':rest();
                break;
            case 'e':exit();
                break;
            case 's':stopAction(actions.size());
                break;
            default:
                System.out.println("You need to select the option from the menu:");
                menu();
        }
    }

    public void work(){
        work = new WorkState();
        work.start();
        System.out.println();
        menu();
    }

    public void rest(){
         resting = new BreakState();
         resting.start();
        System.out.println();
        menu();

    }

    public void exit(){
        System.out.println("Good bye");
        System.out.println("You daily report is: ");
        report();

    }
    public void stopAction(int index){
        // add promp message
       if (actions.get(index-1)=='w'){
           work = new WorkState();
           work.stop();
       }else if(actions.get(index-1)=='b'){
           resting = new BreakState();
           resting.stop();
       }
        menu();
    }

    public void report() {

        System.out.println("User name : "+ getUserName());
        LocalDate today = LocalDate.now();

        System.out.println();
        System.out.println( "Report for "+ today);
        System.out.println();
        System.out.println("Categories \t Duration:");

        System.out.print(" Work   \t  ");
        for (int i = 0 ; i < work.DurationWork.size(); i ++) {
             work.DurationWork.get(i);
            System.out.print( work.DurationWork.get(i));
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("00:mm:ss");
       // Date date = new Date(workTimeDiff);
       // String time = simpleDateFormat.format(date);


       // element = 0;

        System.out.println();
        System.out.print(" Break   \t  ");
        for (int i = 0 ; i < resting.DurationRest.size(); i ++) {
             resting.DurationRest.get(i);
            System.out.print(resting.DurationRest.get(i));
        }
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("00:mm:ss");
        //Date date1 = new Date(element);
       // String time1 = simpleDateFormat1.format(date1);
      //  System.out.print(workTimeDiff);

    }



}
