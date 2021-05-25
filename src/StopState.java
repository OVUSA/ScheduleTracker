import java.time.LocalTime;

class StopState implements State{

    Tracker tracker;
    Manager storage = new Manager();
    StopState(Tracker tracker){
        this.tracker = tracker;
    }


    @Override
    public String onWork() {
        tracker.changeState(new WorkState(tracker));
        LocalTime eTime = LocalTime.now();
        String currentTime = tracker.timeFormatting(eTime);
        storage.startedWorking.add(currentTime);
        return "Started working at: "+ currentTime;
    }

    @Override
    public String onRest() {
        tracker.changeState(new RestingState(tracker));
       // tracker.setWorking(false);
        LocalTime eTime = LocalTime.now();
        String currentTime = tracker.timeFormatting(eTime);
        storage.startedResting.add(currentTime);
        return "Started resting at "+ currentTime;
    }

    @Override
    public String onStop() {
        return "Inactive 'STOP' button";
    }


}