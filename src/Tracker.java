import java.io.IOException;

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


    public void report() throws IOException {


        Manager storage = new Manager();
        storage.calculateDuration(storage.startedWorking, storage.stopWorking, storage.dif);
        storage.calculateDuration(storage.startedResting, storage.stopResting, storage.rest_dif);
        storage.printReport();

    }



}
