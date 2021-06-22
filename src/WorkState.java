import java.time.LocalTime;


public class WorkState implements State {
    Tracker tracker;
    Manager storage = new Manager();


    WorkState (Tracker tracker){
        this.tracker = tracker;
    }

    public String onWork(){
          return "Inactive..., press STOP if you wish to terminate the activity!";
    }

    public String onRest(){
        tracker.changeState(new RestingState(tracker));
        LocalTime eTime = LocalTime.now();
        long stop = System.currentTimeMillis();
        System.out.println("Stop working at "+ storage.timeFormatting(eTime));
        System.out.println();
        // save time of the state' change
        storage.stopWorking.add(stop);
        storage.startedResting.add(stop);
        return " Started resting at "+ storage.timeFormatting(eTime);
    }

    public String onStop (){
        long stop = System.currentTimeMillis();
        storage.stopWorking.add(stop);
        tracker.changeState(new StopState(tracker));
        LocalTime eTime = LocalTime.now();
        String times = storage.timeFormatting(eTime);
        return " Stop working at: " + times;
    }

}
