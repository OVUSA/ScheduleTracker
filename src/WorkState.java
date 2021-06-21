
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
        long start = System.currentTimeMillis();

        String currentTime = tracker.timeFormatting(eTime);
        System.out.println("Stop working at "+ currentTime);
        //manager.stopWorking.add(currentTime);
        tracker.changeState(new RestingState(tracker));
        return " Started resting at "+ currentTime;


    }
    public String onStop (){
        tracker.setWorking(false);
        //tracker.changeState(new StopState(tracker));
        LocalTime eTime = LocalTime.now();
        String times = timeFormatting(eTime);
        tracker.changeState(new StopState(tracker));
        return " Stop working at: " + times;
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

// localitme.minusMinutes(long)
//long createdMillis = System.currentTimeMillis();

