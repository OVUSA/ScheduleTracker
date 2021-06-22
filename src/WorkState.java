
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WorkState implements State {
    Tracker tracker;
    Manager storage;
    long start;
    WorkState (Tracker tracker){
        this.tracker = tracker;
    }

    public String onWork(){
       // System.out.println("Have been working since:"+ manager.startedWorking.get(manager.startedWorking.size()-1));
        return "Inactive..., press STOP if you wish to terminate the activity!";
    }

    public String onRest(){
        LocalTime eTime = LocalTime.now();
        long stop = System.currentTimeMillis();
        String currentTime = storage.timeFormatting(eTime);
        System.out.println("Stop working at "+ currentTime);
        System.out.println();
        // save time of the state' change
        storage.stopWorking.add(stop);
        storage.startedResting.add(stop);
        tracker.changeState(new RestingState(tracker));
        return " Started resting at "+ currentTime;


    }
    public String onStop (){
        tracker.setWorking(false);
        long stop = System.currentTimeMillis();
        storage.stopWorking.add(stop);
        LocalTime eTime = LocalTime.now();
        String times = storage.timeFormatting(eTime);
        tracker.changeState(new StopState(tracker));
        return " Stop working at: " + times;
    }






}

// localitme.minusMinutes(long)
//long createdMillis = System.currentTimeMillis();

