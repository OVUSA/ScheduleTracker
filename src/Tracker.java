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


    public String timeFormatting(LocalTime time){
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("hh:mm:ss");
        return  time.format(myFormatObj1);

    }

    public void report(){

    }
}
