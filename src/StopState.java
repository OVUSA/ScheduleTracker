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
        long start = System.currentTimeMillis();
        storage.startedWorking.add(start);
        return "Started working at: "+ currentTime;
    }

    @Override
    public String onRest() {
        tracker.changeState(new RestingState(tracker));
       // tracker.setWorking(false);
        LocalTime eTime = LocalTime.now();
        String currentTime = tracker.timeFormatting(eTime);
        long start = System.currentTimeMillis();
        storage.startedResting.add(start);
        return "Started resting at "+ currentTime;
    }

    @Override
    public String onStop() {
       // tracker.report();
        return "Inactive 'STOP' button";
    }


}