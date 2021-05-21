import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WorkState implements State {
    Tracker tracker;

    List<String> startedWorking = new ArrayList<>();
    List<String> stopWorking = new ArrayList<>();

    WorkState (Tracker tracker){
        this.tracker = tracker;
    }

    public String onWork(){
        System.out.println("Have been working since:"+ startedWorking.get(startedWorking.size()));
        return "Inactive..., press stop if you wish to terminate the activity!";
    }

    public String onRest(){
        tracker.setWorking(false);
        LocalTime eTime = LocalTime.now();
        stopWorking.add(timeFormatting(eTime));
        tracker.changeState(new RestingState(tracker));
        return "Stop working at "+ eTime;

    }
    public String onStop (){
        return "Stop working at: ";
    }

    public String timeFormatting(LocalTime time){
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("hh:mm:ss");
        String formattedDateStop = time.format(myFormatObj1);
        return formattedDateStop;

    }
    public void calculateDuration (Long time){
        List<Long> currentTime = new ArrayList<>();
        if(currentTime.get(0)== null){
            currentTime.add(time);
        }
    }



}

