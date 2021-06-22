import java.time.LocalTime;

class StopState implements State{

    Tracker tracker;
   Manager storage = new Manager();

    StopState(Tracker tracker){
        this.tracker = tracker;
    }

    @Override
    public String onWork() {
        LocalTime eTime = LocalTime.now();
        long start = System.currentTimeMillis();
        storage.startedWorking.add(start);
        tracker.changeState(new WorkState(tracker));
        return "Started working at: "+ storage.timeFormatting(eTime);
    }

    @Override
    public String onRest() {
        LocalTime eTime = LocalTime.now();
        long start = System.currentTimeMillis();
        storage.startedResting.add(start);
        tracker.changeState(new RestingState(tracker));
        return "Started resting at "+ storage.timeFormatting(eTime);
    }

    @Override
    public String onStop() {
        return "Inactive 'STOP' button";
    }
}
