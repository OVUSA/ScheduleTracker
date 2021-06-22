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

        }



}
