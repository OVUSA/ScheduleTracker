import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Tracker {


    private State state;
    private boolean working = false;

    public Tracker(){
        this.state = new StopState(this);
        setWorking(true);
    }

    public void changeState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }

    public void setWorking (boolean working){
        this.working = working;
    }
    public boolean isWorking(){
        return working;
    }

    
    public void report(){
        Manager storage = new Manager();
        System.out.println("Here is your daily report, \n" +
                "here you can see how much time you worked \n and how much time you rested");
        for ( String a: storage.startedWorking){
            System.out.print("Started work at :"+a);
            for (String b:storage.stopWorking){
                System.out.println("Started work at :"+b);
                break;
            }
        }

    public String timeFormatting(LocalTime time){
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("hh:mm:ss");
        return  time.format(myFormatObj1);

    }
}
