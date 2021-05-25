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
       // System.out.println("Have been working since:"+ manager.startedWorking.get(manager.startedWorking.size()-1));
        return " WORKSTATE Inactive..., press stop if you wish to terminate the activity!";
    }

    public String onRest(){
        LocalTime eTime = LocalTime.now();
        //tracker.setWorking(false);
        System.out.println("Stop working at "+ timeFormatting(eTime));
          // need to save this time in array;
        tracker.changeState(new RestingState(tracker));
        return " Started resting at "+ timeFormatting(eTime);


    }
    public String onStop (){// doesn work
        tracker.setWorking(false);
        //tracker.changeState(new StopState(tracker));
        LocalTime eTime = LocalTime.now();
        String times = timeFormatting(eTime);
        tracker.changeState(new StopState(tracker));
        return " WORKSTATE Stop working at: " + times;
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

