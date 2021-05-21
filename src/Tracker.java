import java.time.LocalTime;

public class Tracker {


    private State state;
    private boolean working = false;

    public Tracker(){
        this.state = new StopState(this);
        setWorking(false);
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

}
