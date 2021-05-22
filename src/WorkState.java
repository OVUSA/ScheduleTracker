import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WorkState implements State {
    Manager manager;
    Tracker tracker;



    WorkState (Tracker tracker){
        this.tracker = tracker;
    }

    public String onWork(){
        System.out.println("Have been working since:"+ manager.startedWorking.get(manager.startedWorking.size()-1));
        return "Inactive..., press stop if you wish to terminate the activity!";
    }

    public String onRest(){
        tracker.setWorking(false);
        LocalTime eTime = LocalTime.now();
        manager.stopWorking.add(timeFormatting(eTime));
        tracker.changeState(new RestingState(tracker));
        return "Stop working at "+ eTime;

    }
    public String onStop (){
        tracker.setWorking(false);
        tracker.changeState(new StopState(tracker));
        LocalTime eTime = LocalTime.now();
        manager.stopWorking.add(timeFormatting(eTime));
        return "Stop working at: " + eTime;
    }

    public String timeFormatting(LocalTime time){
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("hh:mm:ss");
        return  time.format(myFormatObj1);

    }
    public void calculateDuration (Long time){
        List<Long> currentTime = new ArrayList<>();
        if(currentTime.get(0)== null){
            currentTime.add(time);
        }
    }



}

